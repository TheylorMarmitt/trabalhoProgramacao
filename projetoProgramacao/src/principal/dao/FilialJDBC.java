package principal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import principal.conexao.ConexaoUtil;
import principal.model.Filial;

public class FilialJDBC implements FilialDAO {

	@Override
	public void inserir(Filial dado) {
		try {
			String sql = "insert into Filial values (?,?,?,?)";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(2, dado.getNome());
			statement.setString(3, dado.getCidade());
			statement.setString(4, dado.getUf());
			statement.executeUpdate();

			ResultSet rs = statement.getGeneratedKeys();
			rs.next();
			dado.setCodigo(rs.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Filial dado) {
		try {
			String sql = "update Filial set nome= ?, cidade= ?, uf= ? where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setString(1, dado.getNome());
			statement.setString(2, dado.getCidade());
			statement.setString(3, dado.getUf());
			statement.setInt(4, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(Filial dado) {
		try {
			String sql = "delete from Filial where codigo = ?";
			PreparedStatement statement = ConexaoUtil.getConn().prepareStatement(sql);
			statement.setInt(1, dado.getCodigo());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Filial> listar() {
		List<Filial> filiais = new ArrayList<>();
		try {
			Statement statement = ConexaoUtil.getConn().createStatement();
			ResultSet rs = statement.executeQuery("select * from Filial");
			while (rs.next()) {
				Filial filial = new Filial();
				filial.setCodigo(rs.getInt("codigo"));
				filial.setCidade(rs.getString("cidade"));
				filial.setNome(rs.getString("nome"));
				filial.setUf(rs.getString("uf"));
				filiais.add(filial);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filiais;

	}

	@Override
	public Filial buscar(Integer codigo) {
		Filial filial = null;
		try {
			String sql = "select * from Filial where codigo = ?";
			PreparedStatement ps = ConexaoUtil.getConn().prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				filial = new Filial();
				filial.setCodigo(rs1.getInt("codigo"));
				filial.setCidade(rs1.getString("cidade"));
				filial.setNome(rs1.getString("nome"));
				filial.setUf(rs1.getString("uf"));			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filial;

	}

}
