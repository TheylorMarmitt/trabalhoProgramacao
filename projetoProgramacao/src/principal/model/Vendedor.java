package principal.model;

import java.time.LocalDate;

public class Vendedor {

	private int codigo;
	private String nome;
	private LocalDate dataNascimento;
	private String telefone;
	private String cpf;
	private String email;
	
	public Vendedor() {
	
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public Vendedor(int codigo, String nome, LocalDate dataNascimento, String telefone, String cpf, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Vendedor [codigo=" + codigo + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", telefone="
				+ telefone + ", cpf=" + cpf + ", email=" + email + "]";
	}

	
}
