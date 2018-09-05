package principal.model;

import java.time.LocalDate;

public class Aluguel {

		private int codigo;
		private LocalDate dataAluguel;
		private LocalDate dataDevolucao;
		private Double quilometrosEntrada;
		private Double quilometrosSaida;
		
		private Carro carro = new Carro();
		private Filial filial = new Filial();
		private Vendedor vendedor = new Vendedor();
		private TipoAluguel tipoAluguel = new TipoAluguel();
		 
		public boolean confirmaAluguel(){
			return false;
		}
		public Double calculaQuilometros() {
			return null;
		}
		
		
		
		public Aluguel() {
		
		}
		
		public Double getQuilometrosEntrada() {
			return quilometrosEntrada;
		}
		public void setQuilometrosEntrada(Double quilometrosEntrada) {
			this.quilometrosEntrada = quilometrosEntrada;
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
			return "Aluguel [codigo=" + codigo + ", dataAluguel=" + dataAluguel + ", dataDevolucao=" + dataDevolucao
					+ "]";
		}
}