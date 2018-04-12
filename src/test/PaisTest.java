package test;

import static org.junit.Assert.assertEquals;
import model.Pais;
import service.PaisService;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {

   Pais pais, copia;
   PaisService paisService;
   static int id = 0;
	
   @Before
   public void setUp() throws Exception {
      System.out.println("setup");
      pais = new Pais();
      pais.setId(id);
      pais.setNome("Brasil");
      pais.setPopulacao(20103271);
      pais.setArea(8515049);
      copia = new Pais();
      copia.setId(id);
      copia.setNome("Brasil");
      copia.setPopulacao(20103271);
      copia.setArea(8515049);
      paisService = new PaisService();
      System.out.println(pais);
      System.out.println(copia);
      System.out.println(id);
   }
	
   @Test 
   public void test00Carregar() {
      System.out.println("carregar");
      Pais fixture = new Pais();
      fixture.setId(1);
      fixture.setNome("China");
      fixture.setPopulacao(1306313812);
      fixture.setArea(9596960);
      PaisService novoService = new PaisService();
      Pais novo = novoService.carregar(1);
      assertEquals("testa inclusao", fixture, novo);
   }
	
   @Test
   public void test01Criar() {
      System.out.println("criar");
      id = paisService.criar(pais);
      System.out.println(id);
      copia.setId(id);
      assertEquals("testa criaacao", pais, copia);
   }
	
   @Test
   public void test02Atualizar() {
      System.out.println("atualizar");
      pais.setPopulacao(999999);
      copia.setPopulacao(999999);		
      paisService.atualizar(pais);
      pais = paisService.carregar(pais.getId());
      assertEquals("testa atualizacao", pais, copia);
   }
	
   @Test
   public void test03Excluir() {
      System.out.println("excluir");
      copia.setId(-1);
      copia.setNome(null);
      copia.setPopulacao(0);
      copia.setArea(0);
      paisService.excluir(id);
      pais = paisService.carregar(id);
      assertEquals("testa exclusão",copia ,pais);
   }
	
   @Test
   public void test04MaiorPopulacao() {
      System.out.println("maiorPopulacao");
      Pais fixture = new Pais();
      fixture.setId(1);
      fixture.setNome("China");
      fixture.setPopulacao(1306313812);
      fixture.setArea(9596960);
      PaisService novoService = new PaisService();
      Pais novo = novoService.maiorPopulacao();
      assertEquals("testa maiorPopulacao", fixture, novo);
   }
	
   @Test
   public void test05MenorArea() {
      System.out.println("menorArea");
      Pais fixture = new Pais();
      fixture.setId(5);
      fixture.setNome("Atol Johnston");
      fixture.setPopulacao(396);
      fixture.setArea(2.8);
      PaisService novoService = new PaisService();
      Pais novo = novoService.menorArea();
      assertEquals("testa menorArea", fixture, novo);	
   }
	
   @Test
   public void test06VetorTresPaises() {
	   System.out.println("vetorTresPaises");
	   Pais fixture[] = new Pais[3];
	   for (int i = 0; i < fixture.length; i++) {
		   fixture[i] = new Pais();
	   }
	   for (int i = 0; i < fixture.length; i++) {
		   fixture[i].setId(i + 1);
	   }
	   fixture[0].setNome("China");
	   fixture[0].setPopulacao(1306313812);
	   fixture[0].setArea(9596960);
	   fixture[1].setNome("Rússia");
	   fixture[1].setPopulacao(143420309);
	   fixture[1].setArea(17075200);
	   fixture[2].setNome("Coreia do Sul");
	   fixture[2].setPopulacao(48422644);
	   fixture[2].setArea(98480);
	   PaisService novoService = new PaisService();
	   Pais[] novo = novoService.vetorTresPaises();
	   for (int i = 0; i < novo.length; i++) {
		assertEquals("teste vetorTresPaises", fixture[i], novo[i]);
	   }
   }
		

}
