package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Pais {
	//Atributos.
	private int id;
	private String nome;
	private long populacao;
	private double area;
	
	//Importa o JDBC.
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Construtor.
	public Pais() {
		
	}
	public Pais(int id, String nome, long populacao, double area) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
	
	//Obtem conexão com o banco de dados.
	public Connection obtemConexao() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost/pratprogaula02?user=root&password=uh220799");
	}
	
	//CRUD.
	public void criar() {
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.execute();
			String sqlQuery  = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void atualizar() {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.setInt(4, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir() {
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public void carregar() {
		String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE pais.id = ?";
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setArea(rs.getDouble("area"));
				} else {
					setId(-1);
					setNome(null);
					setPopulacao(0);
					setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
	}
	
	//Gets e Sets.
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getPopulacao() {
		return populacao;
	}
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}

	//Outros Metodos.
	public Pais maiorPopulacao() {
		Pais maiorPopulacao = new Pais();
		
		//Banco de Dados.
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais ORDER BY populacao DESC LIMIT 0,1";
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					maiorPopulacao.setId(rs.getInt("id"));
					maiorPopulacao.setNome(rs.getString("nome"));
					maiorPopulacao.setPopulacao(rs.getLong("populacao"));
					maiorPopulacao.setArea(rs.getDouble("area"));
				} else {
					maiorPopulacao.setId(-1);
					maiorPopulacao.setNome(null);
					maiorPopulacao.setPopulacao(0);
					maiorPopulacao.setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return maiorPopulacao;
	}
	public Pais menorArea() {
		//Criando um pais.
		Pais menorArea = new Pais();
		
		//Banco de Dados.
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais ORDER BY area ASC LIMIT 0,1";
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					menorArea.setId(rs.getInt("id"));
					menorArea.setNome(rs.getString("nome"));
					menorArea.setPopulacao(rs.getLong("populacao"));
					menorArea.setArea(rs.getDouble("area"));
				} else {
					menorArea.setId(-1);
					menorArea.setNome(null);
					menorArea.setPopulacao(0);
					menorArea.setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		//Retornando o Pais.
		return menorArea;
		
	}
	public Pais[] vetorTresPaises(){		
		//Criando vetor de pais.
		Pais vetorTresPaises[] = new Pais[3];
		int i = 0;
		
		//Banco de Dados.
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais LIMIT 0,3";
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					vetorTresPaises[i] = new Pais(rs.getInt("id"), rs.getString("nome"), rs.getLong("populacao"), rs.getDouble("area"));
					i++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		//Retornando o Pais.
		return vetorTresPaises;
		
	}
	
	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", populacao=" + populacao
				+ ", area=" + area + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (area == 0) {
			if (other.area != 0)
				return false;
		} else if (area != other.area)
			return false;
		if (populacao == 0) {
			if (other.populacao != 0)
				return false;
		} else if (populacao != other.populacao)
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}