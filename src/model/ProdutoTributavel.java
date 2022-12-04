package model;

public class ProdutoTributavel extends Produto {

	private double precoFinal;
	
	public ProdutoTributavel(int codigo, double preco, String descricao, int tipo) {
		super(codigo, preco, descricao, tipo);
		this.setPrecoFinal(definirPrecoFinal(preco));
	}
	
	/**
	 * Função que retorna o preço final, baseado na classe em que se localiza.
	 * Para maior verossimilhança, a alíquota de IPI que incide sobre todos os produtos industrializados,
	 * sejam eles modificados ou não no processo (a maioria dos produtos, se não todos), é de 35%.
	 * @return precoFinal = O preço final.
	 */
	
	public double definirPrecoFinal(double preco) {
		return setPrecoFinal(preco + (preco * 0.35));
	}

	public double getPrecoFinal() {
		return precoFinal;
	}

	public double setPrecoFinal(double precoFinal) {
		this.precoFinal = precoFinal;
		return precoFinal;
	}


}
