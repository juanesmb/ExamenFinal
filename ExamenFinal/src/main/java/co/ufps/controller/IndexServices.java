package co.ufps.controller;

import java.io.IOException;

import co.ufps.dao.RolDao;
import co.ufps.dao.UsuarioDao;
import co.ufps.entities.Rol;
import co.ufps.entities.Usuario;
import co.ufps.util.ServicioEmail;
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
	String host = "http://localhost:8080/";
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
		try {
			switch(action){
			case "/showregistrarUsuario":
				showRegistroUsuario(request,response);
				break;
			case "/registrarUsuario":
				registrarUsuario(request,response);
				break;
			case "/validarRegistro":
				validarRegistro(request,response);
				break;
			default:
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
		
		u=this.usuarioDao.findByUser(usuario);
		
		String link = host+"/ExamenFinal/validarRegistro?id=" + u.getId();
		ServicioEmail servicioEmail = new ServicioEmail("ejemplo.email.ufps@gmail.com", "nfrbdxklxggkgoko");
		servicioEmail.enviarEmail(email, "Validación de inscripcion", "link para la validar su inscripción: " + link);
		
		
	}
	
	private void validarRegistro(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Usuario u = (Usuario) this.usuarioDao.find(id);
		short state = 1;
		u.setState(state);
		
		this.usuarioDao.update(u);
		System.out.println("validacion exitosa");
	}

}
