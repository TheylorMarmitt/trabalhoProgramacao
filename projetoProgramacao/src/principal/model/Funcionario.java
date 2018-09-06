package principal.model;

public class Funcionario extends Pessoa {

	private Integer codigo;
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

	public Funcionario(Integer codigo, String senha, Filial filial, Double salario) {
		super();
		this.codigo = codigo;
		this.senha = senha;
		this.filial = filial;
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
		return "Funcionario [codigo=" + codigo + ", senha=" + senha + ", filial=" + filial + ", salario=" + salario
				+ "]";
	}

}