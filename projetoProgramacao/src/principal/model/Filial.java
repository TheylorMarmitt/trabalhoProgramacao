package principal.model;

public class Filial {

	private Integer codigo;
	private String nome;
	private String cidade;
	private String uf;

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

	public Filial(int codigo, String nome, String cidade, String uf) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
		this.uf = uf;

	}

	@Override
	public String toString() {
		return this.nome + " - " + this.cidade + "(" + this.uf + ")";
	}

}
