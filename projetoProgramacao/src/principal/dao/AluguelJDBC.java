package principal.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Aluguel;

public class AluguelJDBC implements AluguelDAO {

	@Override
	public void inserir(Aluguel dado) {
		try {
			String sql = "insert into Aluguel (dataAluguel, quilometroSaida, codTipoAluguel, codCliente, codCarro, "
					+ "codFuncionario, codFilial) values (?,?,?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setDate(1, Date.valueOf(dado.getDataAluguel()));
			statement.setDouble(2, dado.getQuilometrosSaida());
			statement.setInt(3, dado.getTipoAluguel().getCodigo());
			statement.setInt(4, dado.getCliente().getCodigo());
			statement.setInt(5, dado.getCarro().getCodigo());
			statement.setInt(6, dado.getFuncionario().getCodigo());
			statement.setInt(7, dado.getFilial().getCodigo());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Aluguel dado) {
		try {
			String sql = "update Aluguel set dataAluguel = ?, quilometroSaida= ?, codTipoAluguel= ?, codCliente=?, "
					+ "codCarro=?, codFuncionario=?, codFilial=? where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setDate(1, Date.valueOf(dado.getDataAluguel()));
			statement.setDouble(2, dado.getQuilometrosSaida());
			statement.setInt(3, dado.getTipoAluguel().getCodigo());
			statement.setInt(4, dado.getCliente().getCodigo());
			statement.setInt(5, dado.getCarro().getCodigo());
			statement.setInt(6, dado.getFuncionario().getCodigo());
			statement.setInt(7, dado.getFilial().getCodigo());
			statement.setInt(8, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(Aluguel dado) {
		try {
			String sql = "delete from aluguel where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Aluguel> listar() {
		List<Aluguel> alugueis = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from Aluguel");
			while (rs.next()) {
				Aluguel aluguel = new Aluguel();
				aluguel.setCodigo(rs.getInt("codigo"));

				Date data = rs.getDate("dataAluguel");
				aluguel.setDataAluguel(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());

				TipoAluguelJDBC tipoAluguelJDBC = new TipoAluguelJDBC();
				aluguel.setTipoAluguel(tipoAluguelJDBC.buscar(rs.getInt("codTipoAluguel")));
				ClienteJDBC clienteJDBC = new ClienteJDBC();
				aluguel.setCliente(clienteJDBC.buscar(rs.getInt("codCliente")));
				CarroJDBC carroJDBC = new CarroJDBC();
				aluguel.setCarro(carroJDBC.buscar(rs.getInt("codCarro")));
				FuncionarioJDBC funcionarioJDBC = new FuncionarioJDBC(); 
				aluguel.setFuncionario(funcionarioJDBC.buscar(rs.getInt("codFuncionario")));
				FilialJDBC filialJDBC = new FilialJDBC();
				aluguel.setFilial(filialJDBC.buscar(rs.getInt("codFilial")));

				alugueis.add(aluguel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alugueis;

	}

	@Override
	public Aluguel buscar(Integer codigo) {
		Aluguel aluguel = null;
		try {
			String sql = "select * from Aluguel where codigo = ?";
			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				aluguel = new Aluguel();
				aluguel.setCodigo(rs1.getInt("codigo"));

				Date data = rs1.getDate("dataAluguel");
				aluguel.setDataAluguel(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
				
				TipoAluguelJDBC tipoAluguelJDBC = new TipoAluguelJDBC();
				aluguel.setTipoAluguel(tipoAluguelJDBC.buscar(rs1.getInt("codTipoAluguel")));
				ClienteJDBC clienteJDBC = new ClienteJDBC();
				aluguel.setCliente(clienteJDBC.buscar(rs1.getInt("codCliente")));
				CarroJDBC carroJDBC = new CarroJDBC();
				aluguel.setCarro(carroJDBC.buscar(rs1.getInt("codCarro")));
				FuncionarioJDBC funcionarioJDBC = new FuncionarioJDBC(); 
				aluguel.setFuncionario(funcionarioJDBC.buscar(rs1.getInt("codFuncionario")));
				FilialJDBC filialJDBC = new FilialJDBC();
				aluguel.setFilial(filialJDBC.buscar(rs1.getInt("codFilial")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aluguel;

	}

	@Override
	public List<Aluguel> alugueisEmAndamento() {
		List<Aluguel> alugueis = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from alugueis_em_andamento");
			while (rs.next()) {
				Aluguel aluguel = new Aluguel();
				aluguel.setCodigo(rs.getInt("codigo"));
				
				aluguel.getCarro().setPlaca(rs.getString("placa"));;
				
				Date data = rs.getDate("dataAluguel");
				aluguel.setDataAluguel(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
				
				aluguel.getTipoAluguel().setDescricao(rs.getString("descricao"));
				aluguel.getCliente().setNome(rs.getString("nome"));
				aluguel.setQuilometrosSaida(rs.getDouble("quilometrosSaida"));
				
				alugueis.add(aluguel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alugueis;
	}
	
	

//	public TipoAluguel buscarTipoAluguel(Integer codigo) {
//		TipoAluguel tipoAluguel = null;
//		try {
//			String sql = "select * from TipoAluguel where codigo = ?";
//			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
//			ps.setInt(1, codigo);
//			ResultSet rs1 = ps.executeQuery();
//			while (rs1.next()) {
//				tipoAluguel = new TipoAluguel();
//				tipoAluguel.setCodigo(rs1.getInt("codigo"));
//				tipoAluguel.setDescricao(rs1.getString("descricao"));
//				tipoAluguel.setValor(rs1.getDouble("valor"));
//				tipoAluguel.setTaxa(rs1.getDouble("taxa"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return tipoAluguel;
//
//	}

//	public Cliente buscarCliente(Integer codigo) {
//		Cliente cliente = null;
//		try {
//			String sql = "select * from Cliente where codigo = ?";
//			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
//			ps.setInt(1, codigo);
//			ResultSet rs1 = ps.executeQuery();
//			while (rs1.next()) {
//				cliente = new Cliente();
//				cliente.setCodigo(rs1.getInt("codigo"));
//				cliente.setNome(rs1.getString("nome"));
//				cliente.setSobrenome("sobrenome");
//				Date data = rs1.getDate("dataNascimento");
//				cliente.setDataNascimento(
//						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
//
//				cliente.setTelefone(rs1.getString("telefone"));
//				cliente.setCpf(rs1.getString("cpf"));
//				cliente.setEmail(rs1.getString("email"));
//
//				data = rs1.getDate("dataCadastro");
//				cliente.setDataDeCadastro(
//						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
//
//				cliente.setCodigo(rs1.getInt("cnh"));
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return cliente;
//
//	}

//	public Carro buscarCarro(Integer codigo) {
//		Carro carro = null;
//		try {
//			String sql = "select * from Carro where codigo = ?";
//			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
//			ps.setInt(1, codigo);
//			ResultSet rs1 = ps.executeQuery();
//			while (rs1.next()) {
//				carro = new Carro();
//				carro.setCodigo(rs1.getInt("codigo"));
//				carro.setMarca(rs1.getString("marca"));
//				carro.setModelo(rs1.getString("modelo"));
//				carro.setValor(rs1.getDouble("valor"));
//				carro.setCor(rs1.getString("cor"));
//
//				Date data = rs1.getDate("ano");
//				carro.setAno(Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
//
//				carro.setPlaca(rs1.getString("placa"));
//
//				carro.setDisponivel(rs1.getBoolean("disponivel"));
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return carro;
//
//	}

//	public Funcionario buscarFuncionario(Integer codigo) {
//		Funcionario funcionario = null;
//		try {
//			String sql = "select * from Funcionario where codigo = ?";
//			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
//			ps.setInt(1, codigo);
//			ResultSet rs1 = ps.executeQuery();
//			while (rs1.next()) {
//				funcionario = new Funcionario();
//				funcionario.setCodigo(rs1.getInt("codigo"));
//
//				funcionario.setNome(rs1.getString("nome"));
//				funcionario.setSobrenome("sobrenome");
//				Date data = rs1.getDate("dataNascimento");
//				funcionario.setDataNascimento(
//						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
//
//				funcionario.setTelefone(rs1.getString("telefone"));
//				funcionario.setCpf(rs1.getString("cpf"));
//				funcionario.setEmail(rs1.getString("email"));
//
//				funcionario.setSenha(rs1.getString("senha"));
//
//				funcionario.setSalario(rs1.getDouble("salario"));
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return funcionario;
//
//	}

//	public Filial buscarFilial(Integer codigo) {
//		Filial filial = null;
//		try {
//			String sql = "select * from Filial where codigo = ?";
//			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
//			ps.setInt(1, codigo);
//			ResultSet rs1 = ps.executeQuery();
//			while (rs1.next()) {
//				filial = new Filial();
//				filial.setCodigo(rs1.getInt("codigo"));
//				filial.setNome(rs1.getString("nome"));
//				filial.setCidade(rs1.getString("cidade"));
//				filial.setUf(rs1.getString("uf"));
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return filial;
//
//	}

}
