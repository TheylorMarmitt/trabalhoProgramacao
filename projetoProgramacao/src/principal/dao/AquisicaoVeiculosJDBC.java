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
import principal.model.AquisicaoVeiculos;

public class AquisicaoVeiculosJDBC implements AquisicaoVeiculosDAO {

	@Override
	public void inserir(AquisicaoVeiculos dado) {
		try {
			String sql = "insert into AquisicaoVeiculos(dataAquisicao, dataDesapropriacao, codCarro, codFilial) values (?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setDate(1, Date.valueOf(dado.getDataDeAquisicao()));
			statement.setDate(2, Date.valueOf(dado.getDataDeDesapropriacao()));
			statement.setInt(3, dado.getCarro().getCodigo());
			statement.setInt(4, dado.getFilial().getCodigo());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(AquisicaoVeiculos dado) {
		try {
			String sql = "update AquisicaoVeiculos set dataAquisicao = ?, dataDesapropriacao= ?, codCarro= ?, codFilial=? where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);

			statement.setDate(1, Date.valueOf(dado.getDataDeAquisicao()));
			statement.setDate(2, Date.valueOf(dado.getDataDeDesapropriacao()));
			statement.setInt(3, dado.getCarro().getCodigo());
			statement.setInt(4, dado.getFilial().getCodigo());
			statement.setInt(5, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(AquisicaoVeiculos dado) {
		try {
			String sql = "delete from AquisicaoVeiculos where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<AquisicaoVeiculos> listar() {
		List<AquisicaoVeiculos> aquisicao = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from AquisicaoVeiculos");
			while (rs.next()) {
				AquisicaoVeiculos aquisicaoVeiculos = new AquisicaoVeiculos();
				aquisicaoVeiculos.setCodigo(rs.getInt("codigo"));

				Date data = rs.getDate("dataAquisicao");
				aquisicaoVeiculos.setDataDeAquisicao(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());

				data = rs.getDate("dataDesapropriacao");
				aquisicaoVeiculos.setDataDeDesapropriacao(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
				CarroJDBC carroJDBC = new CarroJDBC();
				aquisicaoVeiculos.setCarro(carroJDBC.buscar(rs.getInt("codCarro")));
				FilialJDBC filialJDBC = new FilialJDBC();
				aquisicaoVeiculos.setFilial(filialJDBC.buscar(rs.getInt("codFilial")));

				aquisicao.add(aquisicaoVeiculos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aquisicao;

	}

	@Override
	public AquisicaoVeiculos buscar(Integer codigo) {
		AquisicaoVeiculos aquisicao = null;
		try {
			String sql = "select * from AquisicaoVeiculos where codigo = ?";
			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				aquisicao = new AquisicaoVeiculos();
				aquisicao.setCodigo(rs1.getInt("codigo"));

				Date data = rs1.getDate("dataAquisicao");
				aquisicao.setDataDeAquisicao(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());

				data = rs1.getDate("dataDesapropriacao");
				aquisicao.setDataDeAquisicao(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());

				CarroJDBC carroJDBC = new CarroJDBC();
				aquisicao.setCarro(carroJDBC.buscar(rs1.getInt("codCarro")));
				FilialJDBC filialJDBC = new FilialJDBC();
				aquisicao.setFilial(filialJDBC.buscar(rs1.getInt("codFilial")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aquisicao;

	}

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
