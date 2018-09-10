package principal.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente extends Pessoa {

	private Integer codigo;
	private LocalDate dataDeCadastro;
	private String cnh;

	/**
	 * 
	 * @return true se cpf for valido
	 */
	public Boolean validaCpf() {
		boolean cpfValido = false;
		int decimaPosicao = 10;
		int total = 0;
		char[] chars = this.getCpf().toCharArray();

		for (int i = 0; i < 9; i++) {
			int valorCaracterEmPosicao = Integer.valueOf(String.valueOf(chars[i]));
			total = total + (valorCaracterEmPosicao * decimaPosicao);
			decimaPosicao--;
		}

		int validacao1 = total % 11;
		validacao1 = 11 - validacao1;
		if (validacao1 > 9) {
			validacao1 = 0;
		}

		int valorCaracterEmPosicao9 = Integer.valueOf(String.valueOf(chars[9]));

		if (validacao1 == valorCaracterEmPosicao9) {
			cpfValido = true;
		}

		int decimaPrimeiraPosicao = 11;
		total = 0;
		for (int i = 0; i < 10; i++) {
			int valorCaracterEmPosicao = Integer.valueOf(String.valueOf(chars[i]));
			total = total + (valorCaracterEmPosicao * decimaPrimeiraPosicao);
			decimaPrimeiraPosicao--;
		}

		int validacao2 = total % 11;
		validacao2 = 11 - validacao2;

		if (validacao2 > 9) {
			validacao2 = 0;
		}

		int valorCaracterEmPosicao10 = Integer.valueOf(String.valueOf(chars[10]));

		if (validacao2 == valorCaracterEmPosicao10) {
			cpfValido = true;
		}

		if (!cpfValido) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * 
	 * @return idade inteiro
	 */
	public Integer idade() {
		return (int) ChronoUnit.YEARS.between(LocalDate.now(), this.getDataNascimento());
	}

	public Cliente() {

	}

	public Cliente(Integer codigo, LocalDate dataDeCadastro, String cnh) {
		super();
		this.codigo = codigo;
		this.dataDeCadastro = dataDeCadastro;
		this.cnh = cnh;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(LocalDate dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", dataDeCadastro=" + dataDeCadastro + ", cnh=" + cnh + "]";
	}

}
