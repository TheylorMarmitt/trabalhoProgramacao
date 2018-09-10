package principal.model;

public class Funcionario extends Pessoa {

	private Integer codigo;
	private String senha;
	private Double salario;

	public Funcionario() {

	}

	public Funcionario(Integer codigo, String senha, Double salario) {
		super();
		this.codigo = codigo;
		this.senha = senha;
		this.salario = salario;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", senha=" + senha + ", salario=" + salario + "]";
	}

	

}