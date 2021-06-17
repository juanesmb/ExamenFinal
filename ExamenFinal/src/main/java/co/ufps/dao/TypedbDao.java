package co.ufps.dao;

import co.ufps.entities.Typedb;
import co.ufps.util.ConexionMySQL;

public class TypedbDao extends ConexionMySQL implements GenericDao{
	
	public TypedbDao()
	{
		super(Typedb.class);
	}
}
