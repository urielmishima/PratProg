package test;


import static org.junit.Assert.assertEquals;
import model.Pais;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {

	Pais pais, copia;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais(id, "Brasil", 20103271, 8515049);
		copia = new Pais(id, "Brasil", 20103271, 8515049);
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test 
	public void test00Carregar() {
		System.out.println("carregar");
		Pais fixture = new Pais(1, "China", 1306313812, 9596960);
		Pais novo = new Pais(1, null, 0, 0);
		novo.carregar();
		assertEquals("testa inclusao", fixture, novo);
	}
	
	@Test
	public void test01Criar() {
		System.out.println("criar");
		pais.criar();
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criaacao", pais, copia);
	}
	
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setPopulacao(645);
		copia.setPopulacao(645);		
		pais.atualizar();
		pais.carregar();
		assertEquals("testa atualizacao", pais, copia);
	}
	
	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		pais.excluir();
		pais.carregar();
		assertEquals("testa exclusão", pais, copia);
	}
	
	@Test
	public void test04MaiorPopulacao() {
		System.out.println("maiorPopulacao");
		Pais fixture = new Pais(1, "China", 1306313812, 9596960);
		Pais novo = new Pais();
		novo = novo.maiorPopulacao();
		assertEquals("testa maiorPopulacao", fixture, novo);
	}
	
	@Test
	public void test05MenorArea() {
		System.out.println("menorArea");
		Pais fixture = new Pais(5, "Atol Johnston", 396, 2.8);
		Pais novo = new Pais();
		novo = novo.menorArea();
		assertEquals("testa menorArea", fixture, novo);	
	}
	
	@Test
	public void test06VetorTresPaises() {
		System.out.println("vetorTresPaises");
		Pais fixture[] = new Pais[3];
		fixture[0] = new Pais(1, "China", 1306313812, 9596960);
		fixture[1] = new Pais(2, "Rússia",	143420309,	17075200);
		fixture[2] = new Pais(3, "Coreia do Sul", 48422644, 98480);
		Pais[] novo = new Pais[3];
        Pais novoPais = new Pais();
        novo = novoPais.vetorTresPaises();
		for (int j = 0; j < novo.length; j++) {
			assertEquals("testa vetorTresPaises", fixture[j], novo[j]);
		}
		
	}
		

}
