$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarMascota();
    });

    $("#form-register").submit(function (event) {

        event.preventDefault();
        registrarMascota();
    });


});

function autenticarMascota() {

    let username = $("#usuario").val();
    let contrasena = $("#contrasena").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMascotaLogin",
        data: $.param({
            username: username,
            contrasena: contrasena
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let username = parsedResult['username'];
                document.location.href = "home.html?username=" + username;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}
function registrarMascota() {

    let username = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let contrasenaConfirmacion = $("#input-contrasena-repeat").val();
    let nombre_mascota = $("#input-nombre_mascota").val();
    let raza = $("#input-raza").val();
    let sexo = $("#input-sexo").val();
    let edad = $("#input-edad").val();
    let peso = $("#input-peso").val();
    let propietario = $("#input-propietario").val();
    let saldo = $("#input-saldo").val();
    let premium = $("#input-premium").prop("checked");
 

    if (contrasena == contrasenaConfirmacion) {

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletMascotaRegister",
            data: $.param({
                username: username,
                contrasena: contrasena,
                nombre_mascota: nombre_mascota,
                raza: raza,
                sexo: sexo,
                edad: edad,
                peso: peso,
                propietario: propietario,
                saldo: saldo,
                premium: premium
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let username = parsedResult['username'];
                    document.location.href = "home.html?username=" + username;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}