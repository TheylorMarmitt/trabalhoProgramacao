package principal.model;

import java.time.LocalDate;

public class Aluguel {

	private int codigo;
	private LocalDate dataAluguel;
	private Double quilometrosSaida;
	private Carro carro = new Carro();
	private Filial filial = new Filial();
	private Vendedor vendedor = new Vendedor();
	private TipoAluguel tipoAluguel = new TipoAluguel();
	private Cliente cliente;

	public boolean confirmaAluguel() {
		return false;
	}

	public Double calculaQuilometros() {
		return null;
	}

	public Aluguel() {

	}

	public Double getQuilometrosSaida() {
		return quilometrosSaida;
	}

	public void setQuilometrosSaida(Double quilometrosSaida) {
		this.quilometrosSaida = quilometrosSaida;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public TipoAluguel getTipoAluguel() {
		return tipoAluguel;
	}

	public void setTipoAluguel(TipoAluguel tipoAluguel) {
		this.tipoAluguel = tipoAluguel;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(LocalDate dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public Aluguel(int codigo, LocalDate dataAluguel, Double quilometrosSaida, Carro carro, Filial filial,
			Vendedor vendedor, TipoAluguel tipoAluguel, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.dataAluguel = dataAluguel;
		this.quilometrosSaida = quilometrosSaida;
		this.carro = carro;
		this.filial = filial;
		this.vendedor = vendedor;
		this.tipoAluguel = tipoAluguel;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Aluguel [codigo=" + codigo + ", dataAluguel=" + dataAluguel + ", quilometrosSaida=" + quilometrosSaida
				+ ", carro=" + carro + ", filial=" + filial + ", vendedor=" + vendedor + ", tipoAluguel=" + tipoAluguel
				+ ", cliente=" + cliente + "]";
	}

}
