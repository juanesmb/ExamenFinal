package co.ufps.dao;

import co.ufps.entities.Rol;
import co.ufps.util.ConexionMySQL;

public class RolDao extends ConexionMySQL implements GenericDao{
	
	public RolDao(){
		super(Rol.class);
	}

}
