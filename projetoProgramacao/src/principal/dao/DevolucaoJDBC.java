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
import principal.model.Devolucao;

public class DevolucaoJDBC implements DevolucaoDAO{

	@Override
	public void inserir(Devolucao dado) {
		try {
			String sql = "insert into Devolucao(dataChegada, quilometragemChegada, codAluguel, codTipoPagamento, valorTotal) values (?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setDate(1, Date.valueOf(dado.getDataChegada()));
			statement.setDouble(2, dado.getQuilometroChegada());
			statement.setInt(3, dado.getAluguel().getCodigo());
			statement.setInt(4, dado.getTipoPagamento().getCodigo());
			statement.setDouble(5, dado.getValorTotal());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void alterar(Devolucao dado) {
		try {
			String sql = "update Devolucao set dataChegada= ?, quilometragemChegada= ?, codAluguel= ?, codTipoPagamento=?, valorTotal = ? where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setDate(1, Date.valueOf(dado.getDataChegada()));
			statement.setDouble(2, dado.getQuilometroChegada());
			statement.setInt(3, dado.getAluguel().getCodigo());
			statement.setInt(4, dado.getTipoPagamento().getCodigo());
			statement.setDouble(5, dado.getValorTotal());
			statement.setInt(6, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(Devolucao dado) {
		try {
			String sql = "delete from Devolucao where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Devolucao> listar() {
		List<Devolucao> devolucoes = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from Devolucao");
			while (rs.next()) {
				Devolucao devolucao = new Devolucao();
				devolucao.setCodigo(rs.getInt("codigo"));
				Date data = rs.getDate("dataChegada");
				devolucao.setDataChegada(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());

				devolucao.setQuilometroChegada(rs.getDouble("quilometragemChegada"));
				
				AluguelJDBC aluguelJDBC = new AluguelJDBC();
				devolucao.setAluguel(aluguelJDBC.buscar(rs.getInt("codAluguel")));
				TipoPagamentoJDBC tipoPagamentoJDBC = new TipoPagamentoJDBC();
				devolucao.setTipoPagamento(tipoPagamentoJDBC.buscar(rs.getInt("codTipoPagamento")));
				devolucao.setValorTotal(rs.getDouble("valorTotal"));

				devolucoes.add(devolucao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devolucoes;

	}

	@Override
	public Devolucao buscar(Integer codigo) {
		Devolucao devolucao = null;
		try {
			String sql = "select * from Devolucao where codigo = ?";
			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				devolucao = new Devolucao();
				devolucao.setCodigo(rs1.getInt("codigo"));
				Date data = rs1.getDate("dataChegada");
				devolucao.setDataChegada(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());

				devolucao.setQuilometroChegada(rs1.getDouble("quilometragemChegada"));
				
				AluguelJDBC aluguelJDBC = new AluguelJDBC();
				devolucao.setAluguel(aluguelJDBC.buscar(rs1.getInt("codAluguel")));
				TipoPagamentoJDBC tipoPagamentoJDBC = new TipoPagamentoJDBC();
				devolucao.setTipoPagamento(tipoPagamentoJDBC.buscar(rs1.getInt("codTipoPagamento")));
				devolucao.setValorTotal(rs1.getDouble("valorTotal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devolucao;

	}
	

}
