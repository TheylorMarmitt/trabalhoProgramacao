package principal.model;

public class Funcionario extends Pessoa {

	private String senha;
	private Filial filial;
	private Double salario;

	/**
	 * 
	 * @return Double com acrescimo em comissao
	 */
	public Double comissao() {
		return null;
	}
	public Funcionario() {

	}
	public Funcionario(String senha, Filial filial, Double salario) {
		super();
		this.senha = senha;
		this.filial = filial;
		this.salario = salario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [senha=" + senha + ", filial=" + filial + ", salario=" + salario + "]";
	}

}
