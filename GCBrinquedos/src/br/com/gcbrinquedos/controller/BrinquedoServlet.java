package br.com.gcbrinquedos.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gcbrinquedos.bean.Brinquedo;
import br.com.gcbrinquedos.bean.Categoria;
import br.com.gcbrinquedos.bean.Equipe;
import br.com.gcbrinquedos.dao.BrinquedoDAO;
import br.com.gcbrinquedos.dao.CategoriaDAO;

/**
 * Servlet implementation class BrinquedoServlet
 */
@WebServlet("/BrinquedoServlet")
public class BrinquedoServlet extends HttpServlet {
	// private static final long serialVersionUID = 1L;
	BrinquedoDAO dao = new BrinquedoDAO();

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
		String retorno = "";
		switch (acao) {
		case "salvar":
			salvar(request);
			listarBrinquedos(request);
			retorno = "administracao.jsp";
			break;
		case "listar":
			listarBrinquedos(request);
			retorno = "catalogo.jsp";
			break;
		case "listarDestaque":
			listarBrinquedosDestaque(request);
			retorno = "home.jsp";
			break;
		case "listaCategorias":
			listarCategoria(request);
			retorno = "catalogo.jsp";
			break;
		case "listaBrinquedoPorCategoria":
			listaBrinquedoPorCategoria(request);
			buscarCategoria(request);
			retorno = "catalogoBrinquedos.jsp";
			break;
		case "cadastro":
			listarCategoria(request);
			retorno = "cadastro.jsp";
			break;
		case "listarBrinquedo":
			listarBrinquedos(request);
			retorno = "administracao.jsp";
			break;
		case "equipe":
			listarEquipe(request);
			retorno = "equipe.jsp";
			break;
		case "editar":
			buscar(request);
			listarCategoria(request);
			retorno = "cadastro.jsp";
			break;
		case "buscar":
			buscar(request);
			retorno = "detalhe.jsp";
			break;

		case "excluir":
			excluir(request);
			listarBrinquedos(request);
			retorno = "administracao.jsp";
			break;

		default:
			break;
		}

		return retorno;
	}

	public void salvar(HttpServletRequest request) {

		Brinquedo b = new Brinquedo();
		Categoria c = new Categoria();

		try {

			pasta = request.getSession().getServletContext().getRealPath("/WebContent/imagens/")
					.replace("\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps", "");

			b.setDescricao(request.getParameter("descricao"));

			c.setCod(request.getParameter("categoria") != null && request.getParameter("categoria") != ""  
					? Integer.parseInt(request.getParameter("categoria")) : 0);
			
			b.setCategoria(c);

			b.setMarca(request.getParameter("marca"));
			b.setImagem(request.getParameter("img"));
			b.setValor(request.getParameter("valor") != null && request.getParameter("valor") != ""
					? Double.parseDouble(request.getParameter("valor"))
					: 0);

			b.setDetalhes(request.getParameter("detalhes"));
			String codigo = request.getParameter("cd_brinquedo");
			if (codigo != "" && codigo != null) {
				b.setCodigo(Integer.parseInt(codigo));
				dao.atualizar(b);
			} else {
				dao.salvar(b);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void listarBrinquedos(HttpServletRequest request) {

		try {
			ArrayList<Brinquedo> lista = dao.listarBrinquedos();
			request.setAttribute("brinquedos", lista);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void excluir(HttpServletRequest request) {
		try {
			int c = Integer.parseInt(request.getParameter("codigo"));
			dao.excluir(c);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void buscar(HttpServletRequest request) {

		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			Brinquedo b = dao.buscarBrinquedo(codigo);
			request.setAttribute("brinquedo", b);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void listarCategoria(HttpServletRequest request) {

		try {
			ArrayList<Categoria> lista = dao.listarCategoria();
			request.setAttribute("categoria", lista);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void listaBrinquedoPorCategoria(HttpServletRequest request) {

		try {
			int categoria = Integer.parseInt(request.getParameter("categoria"));
			ArrayList<Brinquedo> lista = dao.listarBrinquedosPorCategoria(categoria);
			request.setAttribute("brinquedos", lista);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void buscarCategoria(HttpServletRequest request) {
		CategoriaDAO dao = new CategoriaDAO();
		try {
			int codigo = Integer.parseInt(request.getParameter("categoria"));
			Categoria c = dao.buscarCategoria(codigo);
			request.setAttribute("categoria", c);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void listarEquipe(HttpServletRequest request) {

		try {
			ArrayList<Equipe> lista = dao.listarEquipe();
			request.setAttribute("equipe", lista);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void listarBrinquedosDestaque(HttpServletRequest request) {

		try {
			ArrayList<Brinquedo> lista = dao.listarBrinquedosDestaque();
			request.setAttribute("brinquedos", lista);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
