package principal.model;

import java.time.LocalDate;

public class Funcionario {

	private Integer codigo;
	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String telefone;
	private String cpf;
	private String email;
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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcionario(Integer codigo, String nome, String sobrenome, LocalDate dataNascimento, String telefone,
			String cpf, String email, String senha, Filial filial, Double salario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.filial = filial;
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataNascimento="
				+ dataNascimento + ", telefone=" + telefone + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha
				+ ", filial=" + filial + ", salario=" + salario + "]";
	}

}
