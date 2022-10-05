package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.MascotaController;

/**
 * Servlet implementation class ServletMascotaModificar
 */
@WebServlet("/ServletMascotaModificar")
public class ServletMascotaModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMascotaModificar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
		// TODO Auto-generated method stub
		MascotaController mascota = new MascotaController();
                
		String username = request.getParameter("username");
		String contrasena = request.getParameter("contrasena");
		String nombre_mascota = request.getParameter("nombre_mascota");
		String raza = request.getParameter("raza");
		String sexo = request.getParameter("sexo");
		String edad = request.getParameter("edad");
		String peso = request.getParameter("peso");
		String propietario = request.getParameter("propietario");
                double saldo = Double.parseDouble(request.getParameter("saldo"));
        	boolean premium = Boolean.parseBoolean(request.getParameter("premium"));
                
		
		String mascotaStr = mascota.modificar(username,contrasena,nombre_mascota,raza,sexo,edad,peso,propietario,saldo, premium);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(mascotaStr);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}