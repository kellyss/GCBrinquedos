package br.com.gcbrinquedos.bean;

public class Equipe {
	private int cod;
	private String nome;
	private int rgm;
	private String imagem;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRgm() {
		return rgm;
	}

	public void setRgm(int i) {
		this.rgm = i;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}
