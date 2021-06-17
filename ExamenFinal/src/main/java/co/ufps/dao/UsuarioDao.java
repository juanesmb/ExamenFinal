package co.ufps.dao;

import javax.persistence.EntityManager;

import co.ufps.entities.Usuario;
import co.ufps.util.ConexionMySQL;

public class UsuarioDao extends ConexionMySQL implements GenericDao{

	public UsuarioDao() {
		super(Usuario.class);
	}
	
	public Usuario findByUser(String user)
	{
		EntityManager em = this.getEm();
		Usuario u = em.createNamedQuery("Usuario.findByUser",Usuario.class).setParameter("usuario",user).getSingleResult();
		return u;
	}
}
