package principal.model;

import java.time.LocalDate;

public class Cliente extends Pessoa {

	
	private LocalDate dataDeCadastro;


	public Cliente() {

	}

	public Cliente(LocalDate dataDeCadastro) {
		super();
		this.dataDeCadastro = dataDeCadastro;
	}


	public LocalDate getDataDeCadastro() {
		return dataDeCadastro;
	}


	public void setDataDeCadastro(LocalDate dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}


	@Override
	public String toString() {
		return "Cliente [dataDeCadastro=" + dataDeCadastro + "]";
	}

	
}
