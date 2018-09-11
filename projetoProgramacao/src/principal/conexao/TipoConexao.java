package principal.conexao;

public enum TipoConexao {

	TESTES(new PropriedadesConexao("PPteste.properties")), 
	DESENVOLVIMENTO(new PropriedadesConexao("PPdesenvolvimento.properties")), 
	CLIENTE(new PropriedadesConexao("PPcliente.properties"));
	
	TipoConexao(PropriedadesConexao propriedadesConexao) {
		this.propriedadesConexao = propriedadesConexao;
	}
	
	private PropriedadesConexao propriedadesConexao;
	
	public String getUser() {
		return propriedadesConexao.getUser();
	}
	public String getPass() {
		return propriedadesConexao.getPass();
	}
	public String getUrl() {
		return propriedadesConexao.getUrl();
	}
	
}
