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
import principal.model.Filial;
import principal.model.Funcionario;

public class ControleFuncionariosJDBC implements ControleFuncionariosDAO {

	@Override
	public void inserir(ControleFuncionarios dado) {
		try {
			String sql = "insert into ControleFuncionarios values (?,?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(2, dado.getFilial().getCodigo());
			statement.setInt(3, dado.getFuncionario().getCodigo());
			statement.setDate(4, Date.valueOf(dado.getDataDeAdmissao()));
			statement.setDate(5, Date.valueOf(dado.getDataDeDemissao()));
			statement.executeUpdate();

			ResultSet rs = statement.getGeneratedKeys();
			rs.next();
			dado.setCodigo(rs.getInt(1));

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
				control.setFilial(buscarFilial(rs.getInt("codFilial")));
				control.setFuncionario(buscarFuncionario(rs.getInt("codFuncionario")));

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
				controle.setFilial(buscarFilial(rs1.getInt("codFilial")));
				controle.setFuncionario(buscarFuncionario(rs1.getInt("codFuncionario")));

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

	public Filial buscarFilial(Integer codigo) {
		Filial filial = null;
		try {
			String sql = "select * from Filial where codigo = ?";
			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				filial = new Filial();
				filial.setCodigo(rs1.getInt("codigo"));
				filial.setNome(rs1.getString("nome"));
				filial.setCidade(rs1.getString("cidade"));
				filial.setUf(rs1.getString("uf"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filial;

	}

	public Funcionario buscarFuncionario(Integer codigo) {
		Funcionario funcionario = null;
		try {
			String sql = "select * from Funcionario where codigo = ?";
			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				funcionario = new Funcionario();
				funcionario.setCodigo(rs1.getInt("codigo"));

				funcionario.setNome(rs1.getString("nome"));
				funcionario.setSobrenome("sobrenome");
				Date data = rs1.getDate("dataNascimento");
				funcionario.setDataNascimento(
						Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());

				funcionario.setTelefone(rs1.getString("telefone"));
				funcionario.setCpf(rs1.getString("cpf"));
				funcionario.setEmail(rs1.getString("email"));

				funcionario.setSenha(rs1.getString("senha"));

				funcionario.setSalario(rs1.getDouble("salario"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionario;

	}

}
