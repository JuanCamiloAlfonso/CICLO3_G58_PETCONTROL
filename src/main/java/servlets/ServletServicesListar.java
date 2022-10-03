package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ServicesController;

/**
 * Servlet implementation class ServletServicesListar
 */
@WebServlet("/ServletServicesListar")
public class ServletServicesListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletServicesListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServicesController servicio = new ServicesController() {
                    @Override
                    public String devolver(int id, String username) {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public String sumarCantidad(int id) {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public String alquilar(int id, String username) {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public String modificar(int id) {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                };
		
		boolean ordenar = Boolean.parseBoolean(request.getParameter("ordenar"));
		String orden = request.getParameter("orden");
		
		String ofertaStr = servicio.listar(ordenar, orden);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println(ofertaStr);
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}