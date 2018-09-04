package principal.model;

import java.time.LocalDate;

public class Aluguel {

	private int codigo;
	private LocalDate dataAluguel;
	private LocalDate dataDevolucao;

	public Aluguel() {

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

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Aluguel(int codigo, LocalDate dataAluguel, LocalDate dataDevolucao) {
		super();
		this.codigo = codigo;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public String toString() {
		return "Aluguel [codigo=" + codigo + ", dataAluguel=" + dataAluguel + ", dataDevolucao=" + dataDevolucao + "]";
	}

}
