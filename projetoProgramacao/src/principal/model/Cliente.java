package principal.model;

import java.time.LocalDate;

public class Cliente {

	private Integer codigo;
	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String telefone;
	private String cpf;
	private String email;
	private LocalDate dataDeCadastro;
	private String cnh;

	public Cliente() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Cliente(Integer codigo, String nome, String sobrenome, LocalDate dataNascimento, String telefone, String cpf,
			String email, LocalDate dataDeCadastro, String cnh) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
		this.dataDeCadastro = dataDeCadastro;
		this.cnh = cnh;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataNascimento="
				+ dataNascimento + ", telefone=" + telefone + ", cpf=" + cpf + ", email=" + email + ", dataDeCadastro="
				+ dataDeCadastro + ", cnh=" + cnh + "]";
	}

}
