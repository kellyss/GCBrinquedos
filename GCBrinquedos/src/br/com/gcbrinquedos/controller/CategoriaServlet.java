package br.com.gcbrinquedos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gcbrinquedos.bean.Categoria;
import br.com.gcbrinquedos.dao.CategoriaDAO;

@WebServlet("/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {

	public static String pasta = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String retorno = "";
		String acao = request.getParameter("acao");

		retorno = direcao(request, acao);

		request.getRequestDispatcher(retorno).forward(request, response);

	}

	public String direcao(HttpServletRequest request, String acao) {
		BrinquedoServlet bs = new BrinquedoServlet();
		String retorno = "";
		switch (acao) {
		case "salvar":
			salvar(request);
			bs.listarCategoria(request);
			retorno = "catalogo.jsp";
			break;
		default:
			break;
		}
		return retorno;
	}

	public void salvar(HttpServletRequest request) {

		CategoriaDAO dao = new CategoriaDAO();
		Categoria c = new Categoria();
		try {
			pasta = request.getSession().getServletContext().getRealPath("/WebContent/imagens/")
					.replace("\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps", "");

			c.setDescricao(request.getParameter("descricao"));
			c.setImagem(request.getParameter("img"));

			dao.salvar(c);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
