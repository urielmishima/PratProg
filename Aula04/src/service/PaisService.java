package service;

import dao.PaisDAO;
import model.Pais;


public class PaisService{
   PaisDAO dao = new PaisDAO();
	
	//CRUD.
   public int criar(Pais to) {
      return dao.criar(to);
   }
   public void atualizar(Pais to) {
      dao.atualizar(to);
   }
   public void excluir(int id) {
      dao.excluir(id);
   }
   public Pais carregar(int id) {
      return dao.carregar(id);		
   }
	
	//Outros Metodos
   public Pais maiorPopulacao() {
      return dao.maiorPopulacao();
   }
   public Pais menorArea() {
      return dao.menorArea();
   }
   public Pais[] vetorTresPaises(){
      return dao.vetorTresPaises();
   }	
}