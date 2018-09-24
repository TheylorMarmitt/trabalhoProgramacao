package principal.dao;

import principal.model.Carro;
import principal.model.Funcionario;

import java.util.List;

public interface CarroDAO extends GenericDAO<Carro> {

	List<Carro> carrosDisponiveis();
	
	void desapropriar(Carro dado);
}
