package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		
		//instanciar o javabean
		Pais pais = new Pais();
		try {
			pais.setNome(pNome);
			pais.setPopulacao(Long.parseLong(pPopulacao));
			pais.setArea(Double.parseDouble(pArea));
			
			//instanciar o service
			PaisService ps= new PaisService();
			ps.criar(pais);
			pais = ps.carregar(pais.getId());
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Pais Cadastrado</title></head><body>");
			out.println(	"<h3> Pais Cadastrado</h3><br>");
			out.println(	"id: "+pais.getId()+"<br>");
			out.println(	"nome: "+pais.getNome()+"<br>");
			out.println(	"populacao: "+pais.getPopulacao()+"<br>");
			out.println(	"area: "+pais.getArea()+"<br>");
			out.println("</body></html>");
		} catch (NumberFormatException ex) {
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Cadastrar Pais</title></head><body>");
			out.print("<h3>População e  Area devem ter somente numeros!!</h3>");
			out.println("<div><a href=\"http://localhost:8080/Aula04/index.html\"><button type=\"submit\">Voltar</button></a></div>");
			out.println("</body></html>");						
		}
		
		
		
	}

}
