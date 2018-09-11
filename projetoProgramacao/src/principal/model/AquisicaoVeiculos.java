package principal.model;

import java.time.LocalDate;

public class AquisicaoVeiculos {

	private LocalDate dataDeAquisicao;
	private LocalDate dataDeDesapropriacao = null;
	private Integer codigo;
	private Carro carro;
	private Filial filial;

	public void desapropriarVeiculo() {
		this.dataDeDesapropriacao = LocalDate.now();
	}
	
	
	public AquisicaoVeiculos() {

	}

	public AquisicaoVeiculos(LocalDate dataDeAquisicao, LocalDate dataDeDesapropriacao, Integer codigo, Carro carro,
			Filial filial) {
		super();
		this.dataDeAquisicao = dataDeAquisicao;
		this.dataDeDesapropriacao = dataDeDesapropriacao;
		this.codigo = codigo;
		this.carro = carro;
		this.filial = filial;
	}

	public LocalDate getDataDeAquisicao() {
		return dataDeAquisicao;
	}

	public void setDataDeAquisicao(LocalDate dataDeAquisicao) {
		this.dataDeAquisicao = dataDeAquisicao;
	}

	public LocalDate getDataDeDesapropriacao() {
		return dataDeDesapropriacao;
	}

	public void setDataDeDesapropriacao(LocalDate dataDeDesapropriacao) {
		this.dataDeDesapropriacao = dataDeDesapropriacao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	@Override
	public String toString() {
		return "AquisicaoVeiculos [dataDeAquisicao=" + dataDeAquisicao + ", dataDeDesapropriacao="
				+ dataDeDesapropriacao + ", codigo=" + codigo + ", carro=" + carro + ", filial=" + filial + "]";
	}

}
