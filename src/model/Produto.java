package model;

public abstract class Produto {
	private int codigo;
	private int tipo;
	private double preco;
	private String descricao;
	
	public Produto(int codigo, double preco, String descricao, int tipo) {
		this.codigo = codigo;
		this.preco = preco;
		this.descricao = descricao;
		this.tipo = tipo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public abstract double definirPrecoFinal(double preco);
}
