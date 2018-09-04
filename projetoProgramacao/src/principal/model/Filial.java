package principal.model;

public class Filial {

	private int codigo;
	private String nome;
	private String cidade;
	private String uf;
	private String cnpj;

	public Filial() {
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Filial(int codigo, String nome, String cidade, String uf, String cnpj) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
		this.uf = uf;
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Filial [codigo=" + codigo + ", nome=" + nome + ", cidade=" + cidade + ", uf=" + uf + ", cnpj=" + cnpj
				+ "]";
	}

}
