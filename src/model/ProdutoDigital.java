package model;

public class ProdutoDigital extends Produto {

	private double precoFinal;
	
	public ProdutoDigital(int codigo, double preco, String descricao, int tipo) {
		super(codigo, preco, descricao, tipo);
		this.setPrecoFinal(definirPrecoFinal(preco));
		
	}
	
	/**
	 * Função que retorna o preço final, baseado na classe em que se localiza.
	 * Para maior verossimilhança, o preço sobre os produtos digitais terá imposto de 27,5%, sendo isso um dos
	 * "atributos" que a questão exige.
	 * @return precoFinal = O preço final.
	 */
	
	public double definirPrecoFinal(double preco) {
		return setPrecoFinal(preco + (preco * 0.275));
	}

	public double getPrecoFinal() {
		return precoFinal;
	}

	public double setPrecoFinal(double precoFinal) {
		this.precoFinal = precoFinal;
		return precoFinal;
	}

}
