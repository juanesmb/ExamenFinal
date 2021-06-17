package co.ufps.dao;

import co.ufps.entities.Usuario;
import co.ufps.util.ConexionMySQL;

public class UsuarioDao extends ConexionMySQL implements GenericDao{

	public UsuarioDao() {
		super(Usuario.class);
	}
}
