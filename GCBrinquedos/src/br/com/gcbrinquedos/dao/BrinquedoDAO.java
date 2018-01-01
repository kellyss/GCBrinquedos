package br.com.gcbrinquedos.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.gcbrinquedos.bean.Brinquedo;
import br.com.gcbrinquedos.bean.Categoria;
import br.com.gcbrinquedos.bean.Equipe;
import br.com.gcbrinquedos.connection.Conexao;
import br.com.gcbrinquedos.controller.BrinquedoServlet;

public class BrinquedoDAO {

	public void salvar(Brinquedo b) throws Exception {
		PreparedStatement ps = null;
		String sql = "INSERT INTO t_brinquedo (descricao,categoria,marca,imagem,valor,detalhes) VALUES (?,?,?,?,?,?) ";
		try {
			Connection conn = Conexao.getConnection();
			ps = conn.prepareStatement(sql);
			String diretorio = "imagens/";
			Categoria c = null;
			ps.setString(1, b.getDescricao());
			ps.setInt(2, b.getCategoria().getCod());
			ps.setString(3, b.getMarca());
			// ps.setString(4, diretorio + b.getImagem());

			if (b.getImagem().equals("") || b.getImagem() == null) {
				ps.setString(4, "imagens/sem_imagem.jpg");
			} else {
				ps.setString(4, diretorio + b.getImagem());
			}

			ps.setDouble(5, b.getValor());
			ps.setString(6, b.getDetalhes());
			ps.execute();
			salvarArquivo(b.getImagem(), BrinquedoServlet.pasta);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao inserir os dados " + e);
		}
	}

	public void atualizar(Brinquedo b) throws Exception {
		PreparedStatement ps = null;
		String sql = "UPDATE  t_brinquedo  SET descricao=?,categoria=?,marca=?,imagem=?,valor=?,detalhes=? WHERE codigo=? ";
		try {
			Connection conn = Conexao.getConnection();
			ps = conn.prepareStatement(sql);
			String diretorio = "imagens/";

			ps.setString(1, b.getDescricao());
			ps.setInt(2, b.getCategoria().getCod());
			ps.setString(3, b.getMarca());

			if (b.getImagem().equals("") || b.getImagem() == null) {
				Brinquedo b2 = buscarBrinquedo(b.getCodigo());
				ps.setString(4, b2.getImagem());
			} else {
				ps.setString(4, diretorio + b.getImagem());
			}

			ps.setDouble(5, b.getValor());
			ps.setString(6, b.getDetalhes());
			ps.setInt(7, b.getCodigo());
			ps.executeUpdate();
			salvarArquivo(b.getImagem(), BrinquedoServlet.pasta);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao atualizar os dados " + e);
		}
	}

	public void excluir(int codigo) throws Exception {
		PreparedStatement ps = null;
		String sql = "DELETE FROM t_brinquedo WHERE codigo=? ";
		try {
			Connection conn = Conexao.getConnection();
			ps = conn.prepareStatement(sql);
			String diretorio = "imagens/";

			ps.setInt(1, codigo);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao excluir os dados " + e);
		}
	}

	public ArrayList<Brinquedo> listarBrinquedos() throws Exception {
		ArrayList<Brinquedo> lista = new ArrayList<>();
		Brinquedo b = null;
		Categoria c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT t1.codigo, t1.descricao, t2.descricao as categoria, t1.marca, t1.imagem, valor, detalhes "
				+ "FROM t_brinquedo t1 left join t_categoria t2 on (t1.categoria = t2.cod)";

		try {
			Connection conn = Conexao.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				b = new Brinquedo();
				c = new Categoria();
				b.setCodigo(rs.getInt(1));
				b.setDescricao(rs.getString(2));
				c.setDescricao(rs.getString(3));
				b.setCategoria(c);
				b.setMarca(rs.getString(4));
				b.setImagem(rs.getString(5));
				b.setValor(rs.getDouble(6));
				b.setDetalhes(rs.getString(7));
				lista.add(b);
			}

			return lista;
		} catch (Exception e) {

			throw new Exception("Erro ao listar os dados " + e);
		}
	}

	public ArrayList<Brinquedo> listarBrinquedosDestaque() throws Exception {
		ArrayList<Brinquedo> lista = new ArrayList<>();
		Brinquedo b = null;
		Categoria c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_brinquedo order by valor limit 10";

		try {
			Connection conn = Conexao.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				b = new Brinquedo();
				c = new Categoria();
				b.setCodigo(rs.getInt(1));
				b.setDescricao(rs.getString(2));

				c.setCod(rs.getInt(3));
				b.setCategoria(c);

				b.setMarca(rs.getString(4));
				b.setImagem(rs.getString(5));
				b.setValor(rs.getDouble(6));
				b.setDetalhes(rs.getString(7));
				lista.add(b);
			}

			return lista;
		} catch (Exception e) {

			throw new Exception("Erro ao listar os dados " + e);
		}
	}

	public ArrayList<Categoria> listarCategoria() throws Exception {
		ArrayList<Categoria> lista = new ArrayList<>();
		Categoria c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_categoria ";

		try {
			Connection conn = Conexao.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				c = new Categoria();

				c.setCod(rs.getInt(1));
				c.setDescricao(rs.getString(2));
				c.setImagem(rs.getString(3));

				lista.add(c);
			}

			return lista;
		} catch (Exception e) {

			throw new Exception("Erro ao listar os dados " + e);
		}
	}

	public ArrayList<Equipe> listarEquipe() throws Exception {
		ArrayList<Equipe> lista = new ArrayList<>();
		Equipe e = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_equipe";

		try {
			Connection conn = Conexao.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				e = new Equipe();

				e.setImagem(rs.getString(2));
				e.setNome(rs.getString(3));
				e.setRgm(rs.getInt(4));

				lista.add(e);
			}
			return lista;
		} catch (Exception e1) {

			throw new Exception("Erro ao listar os dados " + e1);
		}
	}

	public ArrayList<Brinquedo> listarBrinquedosPorCategoria(int codCategoria) throws Exception {
		ArrayList<Brinquedo> lista = new ArrayList<>();
		Brinquedo b = null;
		Categoria c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_brinquedo where categoria = ?";

		try {
			Connection conn = Conexao.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codCategoria);

			rs = ps.executeQuery();

			while (rs.next()) {
				b = new Brinquedo();
				c = new Categoria();
				b.setCodigo(rs.getInt(1));
				b.setDescricao(rs.getString(2));

				c.setCod(rs.getInt(3));
				b.setCategoria(c);

				b.setMarca(rs.getString(4));
				b.setImagem(rs.getString(5));
				b.setValor(rs.getDouble(6));
				b.setDetalhes(rs.getString(7));
				lista.add(b);
			}

			return lista;
		} catch (Exception e) {

			throw new Exception("Erro ao listar os dados " + e);
		}
	}

	public Brinquedo buscarBrinquedo(int codigo) throws Exception {
		Brinquedo b = null;
		Categoria c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_brinquedo where codigo = ?";

		try {
			Connection conn = Conexao.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);

			rs = ps.executeQuery();

			while (rs.next()) {
				b = new Brinquedo();
				c = new Categoria();
				b.setCodigo(rs.getInt(1));
				b.setDescricao(rs.getString(2));

				c.setCod(rs.getInt(3));
				b.setCategoria(c);

				b.setMarca(rs.getString(4));
				b.setImagem(rs.getString(5));
				b.setValor(rs.getDouble(6));
				b.setDetalhes(rs.getString(7));

			}

			return b;
		} catch (Exception e) {
			throw new Exception("Erro ao buscar os dados " + e);
		}
	}

	public static void salvarArquivo(String imagem, String novoDiretorio) throws IOException {
		try {
			String dir = "C:/imagens/";
			String dirAtual = dir + imagem;
			String dirNovo = novoDiretorio + imagem;
			if (dirAtual != "" && dirAtual != null) {
				File f = new File(dirNovo);
				if (!f.exists()) // Verifica se já existe a imagem na pasta webcontent/imagens. Caso não exista,
									// ele irá copiar o arquivo para a pasta
					Files.copy(Paths.get(dirAtual), Paths.get(dirNovo));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
