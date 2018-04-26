package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pais;

public class PaisDAO {		
	//CRUD.
   public int criar(Pais to) {
      String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
      try (Connection conn = ConnectionFactory.obtemConexao();
      			PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
         stm.setString(1, to.getNome());
         stm.setLong(2, to.getPopulacao());
         stm.setDouble(3, to.getArea());
         stm.execute();
         String sqlQuery = "SELECT LAST_INSERT_ID()";
         try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
         			ResultSet rs = stm2.executeQuery();) {
            if (rs.next()) {
               to.setId(rs.getInt(1));
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }					
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return to.getId();
   }
   public void atualizar(Pais to) {
      String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
      try (Connection conn = ConnectionFactory.obtemConexao();
      			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
         stm.setString(1, to.getNome());
         stm.setLong(2, to.getPopulacao());
         stm.setDouble(3, to.getArea());
         stm.setInt(4, to.getId());
         stm.execute();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void excluir(int id) {
      String sqlDelete = "DELETE FROM pais WHERE id = ?";
      try (Connection conn = ConnectionFactory.obtemConexao();
      			PreparedStatement stm = conn.prepareStatement(sqlDelete);){
         stm.setInt(1, id);
         stm.execute();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   public Pais carregar(int id) {
      Pais to = new Pais();
      to.setId(id);
      String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE pais.id = ?";
      try (Connection conn = ConnectionFactory.obtemConexao();
      			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
         stm.setInt(1, to.getId());
         try (ResultSet rs = stm.executeQuery();) {
            if (rs.next()) {
               to.setNome(rs.getString("nome"));
               to.setPopulacao(rs.getLong("populacao"));
               to.setArea(rs.getDouble("area"));
            }
            else {      
               to.setId(-1);     
               to.setNome(null);
               to.setPopulacao(0);
               to.setArea(0);
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      } catch (SQLException e1) {
         System.out.println(e1.getStackTrace());
      }
      return to;
   }
	//Outros Metodos.
   public Pais maiorPopulacao() {
      Pais maiorPopulacao = new Pais();
   		
   	//Banco de Dados.
      String sqlSelect = "SELECT id, nome, populacao, area FROM pais ORDER BY populacao DESC LIMIT 0,1";
      try (Connection conn = ConnectionFactory.obtemConexao();
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
      try (Connection conn = ConnectionFactory.obtemConexao();
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
      try (Connection conn = ConnectionFactory.obtemConexao();
      			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
         try (ResultSet rs = stm.executeQuery();) {
            while (rs.next()) {
            	vetorTresPaises[i] = new Pais();
            	vetorTresPaises[i].setId(rs.getInt("id"));
            	vetorTresPaises[i].setNome(rs.getString("nome"));
            	vetorTresPaises[i].setPopulacao(rs.getLong("populacao"));
            	vetorTresPaises[i].setArea(rs.getDouble("area"));
               i++;
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      } catch (SQLException e1) {
         System.out.println(e1.getStackTrace());
      }
   		
   		//Retornando os Paises.
      return vetorTresPaises;		
   }
   public ArrayList<Pais> listarTodos(){
	   ArrayList<Pais> paises = new ArrayList<>();
	   String sqlSelect = "SELECT id, nome, populacao, area FROM pais";
	   Pais pais;
	   
	   try (Connection conn = ConnectionFactory.obtemConexao();
			   PreparedStatement stm = conn.prepareStatement(sqlSelect);
			   ResultSet rs = stm.executeQuery();) {
		   while(rs.next()) {
			   pais = new Pais();
			   pais.setId(rs.getInt("id"));
			   pais.setNome(rs.getString("nome"));
			   pais.setPopulacao(rs.getLong("populacao"));
			   pais.setArea(rs.getDouble("area"));
			   paises.add(pais);
		   }
	   } catch (SQLException e1) {
		   System.out.println(e1.getStackTrace());
	   }
	   return paises;
	}
   
	public ArrayList<Pais> listarPaises(String chave) {
		Pais pais;
		ArrayList<Pais> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais where upper(nome) like ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					pais = new Pais();
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					lista.add(pais);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
   
}
