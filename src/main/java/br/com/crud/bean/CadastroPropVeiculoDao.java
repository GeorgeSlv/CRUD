package br.com.crud.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CadastroPropVeiculoDao {
	private String url = "jdbc:postgresql://localhost:5432/CRUD";
	private String usuario = "postgres";
	private String senha = "postgres";
	
	public List<Proprietario> buscarTodosProprietarios() {
		
		List<Proprietario> propList = new ArrayList<Proprietario>();
		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, usuario, senha);
//			System.out.println("Conexão Realizada com Sucesso!");
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM tb_proprietario");
						
			while (rs.next()) {
				Proprietario p = new Proprietario();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setCpf_cnpj(rs.getString("cpf_cnpj"));
				p.setEndereco(rs.getString("endereco"));
				propList.add(p);
			}
			
			rs.close();
			statement.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return propList;
	}

	public List<Cadastros> buscarTodosCadastros() {
		
		List<Cadastros> cadList = new ArrayList<Cadastros>();
		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, usuario, senha);
//			System.out.println("Conexão Realizada com Sucesso!");
			
			Statement statement = con.createStatement();
			String sql = "select * from tb_proprietario tp inner join tb_veiculo tv \n"
					   + "on tp.id = tv.id_prop";
			ResultSet rs = statement.executeQuery(sql);
						
			while (rs.next()) {
				Cadastros c = new Cadastros();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setCpf_cnpj(rs.getString("cpf_cnpj"));
				c.setEndereco(rs.getString("endereco"));
				c.setPlaca(rs.getString("placa"));
				c.setRenavam(rs.getString("renavam"));
				cadList.add(c);
			}
			
			rs.close();
			statement.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cadList;
	}

	public void addCad(Cadastros cad) {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, usuario, senha);
//			System.out.println("Conexão Realizada com Sucesso!");
				
			String sql = "SELECT inserir_proprietario_veiculo(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, cad.getNome());
			ps.setString(2, cad.getCpf_cnpj());
			ps.setString(3, cad.getEndereco());
			ps.setString(4, cad.getPlaca());
			ps.setString(5, cad.getRenavam());
			
			ps.execute();
			ps.close();
			con.close();
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Cadastros buscarCadastroPeloId(Integer id) {
		Cadastros c = new Cadastros();
		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, usuario, senha);
//			System.out.println("Conexão Realizada com Sucesso!");
			
			Statement statement = con.createStatement();
			String sql = "select * from tb_proprietario tp inner join tb_veiculo tv \n"
					   + "on tp.id = tv.id_prop where tp.id = " + id;
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setCpf_cnpj(rs.getString("cpf_cnpj"));
				c.setEndereco(rs.getString("endereco"));
				c.setPlaca(rs.getString("placa"));
				c.setRenavam(rs.getString("renavam"));	
			}	
			
			rs.close();
			statement.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;

	}

	public void atualizaCad(Cadastros cadUni) {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, usuario, senha);
//			System.out.println("Conexão Realizada com Sucesso!");
				
			String sql = "SELECT atualiza_proprietario_veiculo(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, cadUni.getId());
			ps.setString(2, cadUni.getNome());
			ps.setString(3, cadUni.getCpf_cnpj());
			ps.setString(4, cadUni.getEndereco());
			ps.setString(5, cadUni.getPlaca());
			ps.setString(6, cadUni.getRenavam());
			
			ps.execute();
			ps.close();
			con.close();
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deletarCadPeloId(Integer id) {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, usuario, senha);
//			System.out.println("Conexão Realizada com Sucesso!");
				
			String sql = "SELECT deletar_cadastro_pelo_id(?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
//			System.out.println(ps);
			
			ps.execute();
			ps.close();
			con.close();
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
