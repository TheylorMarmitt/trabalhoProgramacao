package principal.model;

public class TipoAluguel {

	private String descricao;
	private Double valor;
	private Double taxa;

	public TipoAluguel() {
		super();
	}

	public TipoAluguel(String descricao, Double valor, Double taxa) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.taxa = taxa;
	}
	
	public Double calculaValor() {
		return null;
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

}
