package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		String acao = request.getParameter("acao");

		// instanciar o service
		PaisService ps = new PaisService();
		RequestDispatcher dispatcher = null;

		switch (acao) {
		case "Criar":
			try {
				// instanciar o javabean
				Pais pais = new Pais();
				pais.setNome(pNome);

				pais.setPopulacao(Long.parseLong(pPopulacao));
				pais.setArea(Double.parseDouble(pArea));
				ps.criar(pais);
				pais = ps.carregar(pais.getId());

				// manda parametro para o JSP via request
				request.setAttribute("pais", pais);
				dispatcher = request.getRequestDispatcher("Pais.jsp");
				
			} catch (NumberFormatException ex) {
				PrintWriter out = response.getWriter();
				out.println("<html><head><title>Cadastrar Pais</title></head><body>");
				out.print("<h3>População e  Area devem ter somente numeros!!</h3>");
				out.println(
						"<div><a href=index.jsp\"><button type=\"submit\">Voltar</button></a></div>");
				out.println("</body></html>");
			}
			break;
		case "Listar":
			ArrayList<Pais> paises = ps.listarTodos();
			request.setAttribute("paises", paises);
			dispatcher = request.getRequestDispatcher("ListaDePaises.jsp");
		}

		// dispachar para o jSP correto
		dispatcher.forward(request, response);

	}
}
