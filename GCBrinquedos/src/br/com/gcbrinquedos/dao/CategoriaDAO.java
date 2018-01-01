package br.com.gcbrinquedos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.gcbrinquedos.bean.Categoria;
import br.com.gcbrinquedos.connection.Conexao;
import br.com.gcbrinquedos.controller.BrinquedoServlet;

public class CategoriaDAO {
	
	public void salvar(Categoria c) throws Exception {
		PreparedStatement ps = null;
		String sql = "INSERT INTO t_categoria (descricao,imagem) VALUES (?,?) ";
		try {
			Connection conn = Conexao.getConnection();
			ps = conn.prepareStatement(sql);
			String diretorio = "imagens/";

			ps.setString(1, c.getDescricao());
			ps.setString(2, diretorio + c.getImagem());
			ps.execute();
			
			BrinquedoDAO.salvarArquivo(c.getImagem(), BrinquedoServlet.pasta);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao inserir os dados " + e);
		}
	}
	
	public Categoria buscarCategoria(int codCategoria) throws Exception {
		Categoria c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_categoria where cod = ?";

		try {
			Connection conn = Conexao.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codCategoria);
			rs = ps.executeQuery();

			while (rs.next()) {
				c = new Categoria();
				
				c.setCod(rs.getInt(1));
				c.setDescricao(rs.getString(2));
				c.setImagem(rs.getString(3));
			}

			return c;
		} catch (Exception e) {
			// e.printStackTrace();
			throw new Exception("Erro ao buscar a categoria " + e);
		}
	}

}
