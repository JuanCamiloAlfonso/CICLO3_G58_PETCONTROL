var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getMascota().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?username=" + username);
        
        $("#user-saldo").html(user.saldo.toFixed(2) + "$");

        getServices(false, "ASC");

        $("#ordenar-id_servicio").click(ordenarServices);
    });
});


async function getMascota() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMascotaPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos de la mascota");
            }
        }
    });

}
function getServices(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletServicesListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarServices(parsedResult);
            } else {
                console.log("Error recuperando los datos de los servicios para Mascotas");
            }
        }
    });
}
function mostrarServices(servicess) {

    let contenido = "";

    $.each(servicess, function (index, services) {

        services = JSON.parse(services);
        let precio;

        if (services.cantidad > 0) {

            if (user.premium) {

                if (services.novedad) {
                    precio = (2 - (2 * 0.1));
                } else {
                    precio = (1 - (1 * 0.1));
                }
            } else {
                if (services.novedad) {
                    precio = 2;
                } else {
                    precio = 1;
                }
            }

            contenido += '<tr><th scope="row">' + services.id_servicio + '</th>' +
                    '<td>' + services.servicios + '</td>' +
                    '<td>' + services.descripcion + '</td>' +
                    '<td>' + services.precio + '</td>' +
                    '<td>' + services.cantidad + '</td>' +
                    '<td>' + services.invasividad + '</td>' +
                    '<td>' + services.medicacion + '</td>' +
                    '<td><input type="checkbox" name="novedad" id="novedad' + services.id_servicio + '" disabled ';
            if (services.novedad) {
                contenido += 'checked';
            }
            contenido += '></td>' +
                    '<td>' + precio + '</td>' +
                    '<td><button onclick="alquilarService(' + services.id_servicio + ',' + precio + ');" class="btn btn-success" ';
            if (user.saldo < precio) {
                contenido += ' disabled ';
            }

            contenido += '>Reservar</button></td></tr>'

        }
    });
    $("#servicess-tbody").html(contenido);
}

function ordenarServices() {

    if ($("#icono-ordenar").hasClass("fa-sort")) {
        getServices(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
        getServices(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
        getServices(false, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}

function alquilarPelicula(id, precio) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletPeliculaAlquilar",
        data: $.param({
            id: id,
            username: username

        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                restarDinero(precio).then(function () {
                    location.reload();
                })
            } else {
                console.log("Error en la reserva de la película");
            }
        }
    });
}


async function restarDinero(precio) {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioRestarDinero",
        data: $.param({
            username: username,
            saldo: parseFloat(user.saldo - precio)

        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                console.log("Saldo actualizado");
            } else {
                console.log("Error en el proceso de pago");
            }
        }
    });
}