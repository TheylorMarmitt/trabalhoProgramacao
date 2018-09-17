package principal.model;

public class TipoAluguel {

	private Integer codigo;
	private String descricao;
	private Double valor;
	private Double taxa;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public TipoAluguel() {

	}

	public TipoAluguel(Integer codigo, String descricao, Double valor, Double taxa) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.taxa = taxa;
	}

	@Override
	public String toString() {
		return "TipoAluguel [codigo=" + codigo + ", descricao=" + descricao + ", valor=" + valor + ", taxa=" + taxa
				+ "]";
	}

}
