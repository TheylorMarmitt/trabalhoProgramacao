package principal.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class AquisicaoVeiculos {

	private LocalDate dataDeAquisicao;
	private LocalDate dataDeDesapropriacao;
	private Integer codigo;
	private ArrayList<Carro> carros;
	private Filial filial;

	public void removerVeiculo(Carro carro) {
		for(Carro car: carros) {
			if(car.equals(carro)) {
				this.setDataDeDesapropriacao(LocalDate.now());
				carros.remove(car);
			}
		}
	}

	public AquisicaoVeiculos() {

	}

	public AquisicaoVeiculos(LocalDate dataDeAquisicao, LocalDate dataDeDesapropriacao, Integer codigo,
			ArrayList<Carro> carros, Filial filial) {
		super();
		this.dataDeAquisicao = dataDeAquisicao;
		this.dataDeDesapropriacao = dataDeDesapropriacao;
		this.codigo = codigo;
		this.carros = carros;
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

	public ArrayList<Carro> getCarros() {
		return carros;
	}

	public void setCarros(ArrayList<Carro> carros) {
		this.carros = carros;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	@Override
	public String toString() {
		return "AquisicaoVeiculos [dataDeAquisicao=" + dataDeAquisicao + ", dataDeDesapropriacao="
				+ dataDeDesapropriacao + ", codigo=" + codigo + ", carros=" + carros + ", filial=" + filial + "]";
	}

}
