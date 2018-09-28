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
import principal.model.ControleFuncionarios;

public class ControleFuncionariosJDBC implements ControleFuncionariosDAO {

	@Override
	public void inserir(ControleFuncionarios dado) {
		try {
			String sql = "insert into ControleFuncionarios(codFilial, codFuncionario, dataAdmissao, dataDemissao) values (?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getFilial().getCodigo());
			statement.setInt(2, dado.getFuncionario().getCodigo());
			statement.setDate(3, Date.valueOf(dado.getDataDeAdmissao()));
			statement.setDate(4, Date.valueOf(dado.getDataDeDemissao()));
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(ControleFuncionarios dado) {
		try {
			String sql = "update ControleFuncionarios set codFilial= ?, codFuncionario= ?, dataAdmissao= ?, dataDemissao=? where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getFilial().getCodigo());
			statement.setInt(2, dado.getFuncionario().getCodigo());
			statement.setDate(3, Date.valueOf(dado.getDataDeAdmissao()));
			statement.setDate(4, Date.valueOf(dado.getDataDeDemissao()));
			statement.setInt(5, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(ControleFuncionarios dado) {
		try {
			String sql = "delete from ControleFuncionarios where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<ControleFuncionarios> listar() {
		List<ControleFuncionarios> controle = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from ControleFuncionarios");
			while (rs.next()) {
				ControleFuncionarios control = new ControleFuncionarios();
				control.setCodigo(rs.getInt("codigo"));
				FilialJDBC filialJDBC = new FilialJDBC();
				control.setFilial(filialJDBC.buscar(rs.getInt("codFilial")));
				FuncionarioJDBC funcionarioJDBC = new FuncionarioJDBC();
				control.setFuncionario(funcionarioJDBC.buscar(rs.getInt("codFuncionario")));

				Date data = rs.getDate("dataAdmissao");
				control.setDataDeAdmissao(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());

				data = rs.getDate("dataDemissao");
				control.setDataDeDemissao(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());

				controle.add(control);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return controle;

	}

	@Override
	public ControleFuncionarios buscar(Integer codigo) {
		ControleFuncionarios controle = null;
		try {
			String sql = "select * from ControleFuncionarios where codigo = ?";
			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				controle = new ControleFuncionarios();
				controle.setCodigo(rs1.getInt("codigo"));
				FilialJDBC filialJDBC = new FilialJDBC();
				controle.setFilial(filialJDBC.buscar(rs1.getInt("codFilial")));
				FuncionarioJDBC funcionarioJDBC = new FuncionarioJDBC();
				controle.setFuncionario(funcionarioJDBC.buscar(rs1.getInt("codFuncionario")));

				Date data = rs1.getDate("dataAdmissao");
				controle.setDataDeAdmissao(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());

				data = rs1.getDate("dataDemissao");
				controle.setDataDeDemissao(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return controle;

	}

}
