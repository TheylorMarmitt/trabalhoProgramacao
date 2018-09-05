package principal.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	void inserir(T dado);
	
	void alterar(T dado);
	
	void excluir(T dado);
	
	List<T> listar();
	
	T buscar(Integer codigo);
}
