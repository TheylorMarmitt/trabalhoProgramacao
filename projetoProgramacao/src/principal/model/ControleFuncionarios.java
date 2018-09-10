package principal.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControleFuncionarios {

	private LocalDate dataDeAdmissao;
	private LocalDate dataDeDemissao;
	private Integer codigo;
	private ArrayList<Funcionario> funcionario;
	private Filial filial;

	public void demitir(Funcionario fun) {
		for(Funcionario f: funcionario) {
			if(f.equals(fun)) {
				this.setDataDeDemissao(LocalDate.now());
				funcionario.remove(f);
			}
		}
		
	}
	
	public ControleFuncionarios() {
		
	}

	public ControleFuncionarios(LocalDate dataDeAdmissao, LocalDate dataDeDemissao, Integer codigo,
			ArrayList<Funcionario> funcionario, Filial filial) {
		super();
		this.dataDeAdmissao = dataDeAdmissao;
		this.dataDeDemissao = dataDeDemissao;
		this.codigo = codigo;
		this.funcionario = funcionario;
		this.filial = filial;
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

	public ArrayList<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(ArrayList<Funcionario> funcionario) {
		this.funcionario = funcionario;
		this.dataDeAdmissao = LocalDate.now();
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
