package principal.model;

import java.time.LocalDate;

public class ControleFuncionarios {

	private LocalDate dataDeAdmissao;
	private LocalDate dataDeDemissao = null;
	private Integer codigo;
	private Funcionario funcionario;
	private Filial filial;

	public void demitir() {
		this.dataDeDemissao = LocalDate.now();
	}
	
	public ControleFuncionarios() {

	}

	public ControleFuncionarios(LocalDate dataDeAdmissao, LocalDate dataDeDemissao, Integer codigo,
			Funcionario funcionario, Filial filial) {
		super();
		this.dataDeAdmissao = dataDeAdmissao;
		this.dataDeDemissao = dataDeDemissao;
		this.codigo = codigo;
		this.funcionario = funcionario;
		this.filial = filial;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDate getDataDeAdmissao() {
		return dataDeAdmissao;
	}

	public void setDataDeAdmissao(LocalDate dataDeAdmissao) {
		this.dataDeAdmissao = dataDeAdmissao;
	}

	public LocalDate getDataDeDemissao() {
		return dataDeDemissao;
	}

	public void setDataDeDemissao(LocalDate dataDeDemissao) {
		this.dataDeDemissao = dataDeDemissao;
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

	@Override
	public String toString() {
		return "ControleFuncionarios [dataDeAdmissao=" + dataDeAdmissao + ", dataDeDemissao=" + dataDeDemissao
				+ ", codigo=" + codigo + ", funcionario=" + funcionario + ", filial=" + filial + "]";
	}

}
