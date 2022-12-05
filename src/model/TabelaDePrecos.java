package model;

import java.util.ArrayList;
import persistencia.Persistidor;

/**
 * Classe que implementa o preço de um produto na tabela.
 * Universidade de Caxias do Sul (UCS). Sob as ordens do professor Marcos.
 * 
 *
 * @author Gustavo Baldin
 * @version 27/11/2022
 */

public class TabelaDePrecos {

	private int capacidade;
	private ArrayList<Produto> produtos = new ArrayList<Produto>(capacidade);
	private Persistidor ps = new Persistidor();
	

	/**
	 * Construtor que inicializa a TabelaDePrecos com um tamanho pré-definido 
	 *
	 * @param capacidade - A máxima capacidade da tabela
	 */
	public TabelaDePrecos(int capacidade)
	{
		this.capacidade = capacidade;
	}

	/**
	 * Método que retorna o preço de um produto quando dado seu código.
	 *
	 * @param codigo - Código do produto cujo qual queira saber o preço.
	 * @return De acordo com o resultado, retorna um valor diferente; se o produto
	 * não existe, ele retorna -1.
	 */
	public double getPrecoDoProduto(int codigo)
	{
		double precoProduto = -1;
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getCodigo() == codigo) {
				precoProduto = produtos.get(i).getPreco();
				break;
			}
		}
		return precoProduto;
	}

	/**
	* Método que insere um produto dentro de uma tabela.

	* @param code - Código do produto
	* @param price - Preço do produto
	* @param descricao - Descrição do produto
	* @return Um inteiro informando a situação da inserção: 
	* 0 - a inserção aconteceu sem problemas.
	* 1 - inserção não aconteceu porque a tabela estava cheia.
	* 2 - inserção não aconteceu porque já tem um produto com este código na tabela.
	 */
	public int inserirProduto(int codigo, double preco, String descricao, int tipo)
	{
		int retorno = 3;
		
		Produto novoProduto = null;
		
		switch (tipo) {
			case 1: 	
				novoProduto = new ProdutoDigital(codigo, preco, descricao, tipo);
				break;
				
			case 2:
				novoProduto = new ProdutoTributavel(codigo, preco, descricao, tipo);
				break;
				
			case 3:
				novoProduto = new ProdutoNaoTributavel(codigo, preco, descricao, tipo);
				break;
			
			default:
				break;
			
		}
		
		if (produtos.size() > 0) {	
			for (int i = 0; i <= produtos.size(); i++) {
	
				if (produtos.get(i).getCodigo() == codigo) {
					retorno = 2;
					break;
				}
			}
		}
		
		if (retorno != 2) {	
			try {
				
				produtos.add(novoProduto);
				
				retorno = 0;
			}
			catch (ArrayIndexOutOfBoundsException e) {
				retorno = 1;
			}
			finally {
				System.out.println("Operação finalizada.");
			}
		}
		
		return retorno;
	}
	
	
	
	/**
	 * Método que remove um produto da tabela.
	 *
	 * @param codigo - Código do produto que será removido, se encontrado.
	 */
	public void removerProduto(int codigo)
	{
		Produto produto = null;
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getCodigo() == codigo) {
				produto = produtos.get(i);
			}
		}
		produtos.remove(produto);
		System.out.println("SUCESSO: Produto removido.");
	}
	
	/**
	 * Método que, dada uma palavra chave, procura na descrição de algum objeto se ela existe e retorna
	 * o objeto em forma de Array para ser usado.
	 * 
	 * @param chave - Palavra-Chave em String para ser pesquisada
	 * @return Uma ArrayList simples com o objeto selecionado nos loops.
	 */
	

	public ArrayList<Produto> pesquisaPorPalavraChave(String chave)
	{
		ArrayList<Produto> temp = new ArrayList<Produto>(capacidade);
		Produto novoProduto = null;
		
		for (int i = 0; i < produtos.size(); i++) {
			if (chave.equals(produtos.get(i).getDescricao()) && produtos.get(i).getTipo() == 1) {
				novoProduto = new ProdutoDigital(produtos.get(i).getCodigo(), produtos.get(i).getPreco(), 
						produtos.get(i).getDescricao(), produtos.get(i).getTipo());
			}
			else if (chave.equals(produtos.get(i).getDescricao()) && produtos.get(i).getTipo() == 2) {
				novoProduto = new ProdutoTributavel(produtos.get(i).getCodigo(), produtos.get(i).getPreco(), 
						produtos.get(i).getDescricao(), produtos.get(i).getTipo());
			}
			else if (chave.equals(produtos.get(i).getDescricao()) && produtos.get(i).getTipo() == 3) {
				novoProduto = new ProdutoNaoTributavel(produtos.get(i).getCodigo(), produtos.get(i).getPreco(), 
						produtos.get(i).getDescricao(), produtos.get(i).getTipo());
			}
		}
		temp.add(novoProduto);
		
		return temp;
	}
	
	/**
	 * Exibe todos os produtos, com sua descrição e com o preço final.
	 */
	
	public void exibirProdutos() {
		for (int i = 0; i < produtos.size(); i++) {
			System.out.println("DESCRIÇÃO PRODUTO: " + produtos.get(i).getDescricao());
			System.out.println("PREÇO FINAL: " + produtos.get(i).getPrecoFinal());
		}
			
	}
	
	/**
	 * Faz a consulta e exibe o preço de um produto, dado um código
	 * @param codigo - Código do produto.
	 */
	
	public void consultarPreco(int codigo) {
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getCodigo() == codigo) {
				System.out.println("O preço deste produto é: " + produtos.get(i).getPrecoFinal());
			}
		}
	}
	
	/**
	 * Faz a consulta e exibe produtos abaixo (ou iguais) ao valor.
	 * @param valor - Faixa de valores desejada.
	 */
	
	public void consultarPreco(double valor) {
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getPrecoFinal() <= valor) {
				System.out.println("DESCRIÇÃO PRODUTO: " + produtos.get(i).getDescricao());
				System.out.println("PREÇO FINAL: " + produtos.get(i).getPrecoFinal());
			}
		}
	}
	
	/**
	 * Método que salva os dados de uma array inteira.
	 */
	
	public void transferirDadosParaArquivos() {
		ps.salvarData(produtos);
	}
	
	/**
	 * Método que inicializa os dados na tabela.
	 */
	public void carregarDadosNaTabela() {
		produtos = ps.inicializarData();
	}
}


