package model;

public class ProdutoNaoTributavel extends Produto {

	private double precoFinal;
	
	public ProdutoNaoTributavel(int codigo, double preco, String descricao, int tipo) {
		super(codigo, preco, descricao, tipo);
		this.setPrecoFinal(definirPrecoFinal(preco));
	}
	
	/**
	 * Função que retorna o preço final, baseado na classe em que se localiza.
	 * Para maior verossimilhança, os produtos com isenção de imposto não sofrem mudança pelo IPI, mas
	 * iremos inserir uma taxa "estadual" de 1%.
	 * @return precoFinal = O preço final.
	 */
	
	public double definirPrecoFinal(double preco) {
		return setPrecoFinal(preco + (preco * 0.01));
	}

	public double getPrecoFinal() {
		return precoFinal;
	}

	public double setPrecoFinal(double precoFinal) {
		this.precoFinal = precoFinal;
		return precoFinal;
	}


}
