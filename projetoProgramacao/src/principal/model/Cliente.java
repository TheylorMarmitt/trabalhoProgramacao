package principal.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente extends Pessoa {

	private Integer codigo;
	private LocalDate dataDeCadastro;
	private String cnh;

	
	/**
	 * 
	 * @return idade inteiro
	 */
	public Integer idade() {
		return (int) ChronoUnit.YEARS.between(LocalDate.now(), this.getDataNascimento());
	}

	public Cliente() {

	}

	public Cliente(Integer codigo, LocalDate dataDeCadastro, String cnh) {
		super();
		this.codigo = codigo;
		this.dataDeCadastro = dataDeCadastro;
		this.cnh = cnh;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(LocalDate dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	@Override
	public String toString() {
		return this.getNome() + " " + this.getSobrenome() + " - " + this.getCpf();
	}

}
