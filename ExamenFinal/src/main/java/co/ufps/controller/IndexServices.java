package co.ufps.controller;

import java.io.IOException;

import co.ufps.dao.RolDao;
import co.ufps.dao.UsuarioDao;
import co.ufps.entities.Rol;
import co.ufps.entities.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServices
 */
@WebServlet("/")
public class IndexServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDao usuarioDao;
	RolDao rolDao;
    /**
     * Default constructor. 
     */
    public IndexServices() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.usuarioDao = new UsuarioDao();
		this.rolDao = new RolDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch(action){
			case "/showregistrarUsuario":
				showRegistroUsuario(request,response);
				break;
			case "/registrarUsuario":
				registrarUsuario(request,response);
				break;
			default:
				System.out.println("entrando por default");
				showRegistroUsuario(request,response);
				break;
			}
		}catch(ServletException e)
		{
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showRegistroUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("inscripcionUsuario.jsp");
		dispatcher.forward(request, response); 
		
	}
	
	private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) {
		String usuario = request.getParameter("usuario");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		Rol rol = (Rol) this.rolDao.find(Integer.valueOf(2));
		
		Usuario u = new Usuario(usuario,email,pass);
		u.setRol(rol);
		short estado = 0;
		u.setState(estado);
		
		this.usuarioDao.insert(u);
		
		System.out.print("registro exitoso");
	}

}
