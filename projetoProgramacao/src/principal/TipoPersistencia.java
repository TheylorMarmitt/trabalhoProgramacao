package principal;

import principal.dao.DaoFactory;
import principal.dao.JDBCFactory;

public enum TipoPersistencia {

	BANCO(new JDBCFactory());
	
	TipoPersistencia(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	private DaoFactory daoFactory;

	public DaoFactory createFactory() {
		return daoFactory;
	}
}
