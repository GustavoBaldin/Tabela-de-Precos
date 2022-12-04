package model;

import java.util.ArrayList;
import java.util.Scanner;

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
	private Scanner in = new Scanner(System.in);
	

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
		System.out.println("Informe o código do produto: ");
		codigo = in.nextInt();
		System.out.println("Informe o preço do produto: ");
		preco = in.nextDouble();
		in.nextLine();
		System.out.println("Informe a descrição do produto: ");
		descricao = in.nextLine();
		System.out.println("Escolha o tipo do produto: \n1 - Produto Digital, 2 - Produto Tributável, "
				+ "3 - Produto Não Tributável");
		tipo = in.nextInt();
		
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
		

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getCodigo() == codigo) {
				System.out.println("ERRO: O produto informado já existe.");
				retorno = 2;
				break;
			}
		}
		
		
		if (retorno != 2) {	
			try {
				
				produtos.add(novoProduto);
				System.out.println("SUCESSO: O produto foi adicionado na lista.");
				retorno = 0;
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("ERRO: A lista de produtos infelizmente está cheia. (" + e.getMessage() + ")");
				retorno = 1;
			}
			catch (Exception e) {
				System.out.println("ERRO: Algum erro de origem desconhecida aconteceu. (" + e.getMessage() + ")");
			}
			finally {
				System.out.println("Operação finalizada.");
			}
		}
		
		return retorno;
	}
	
	/**
	* Método que insere direto um objeto do tipo Produto dentro da tabela
	* 
	* @param produto - O objeto do produto a ser inserido na tabela.
	* @return Um inteiro informando a situação da inserção: 
	* 0 - a inserção aconteceu sem problemas.
	* 1 - inserção não aconteceu porque a tabela estava cheia.
	* 2 - inserção não aconteceu porque já tem um produto com este código na tabela.
	 */
	public int inserirProduto(Produto produto) // method overloading
										
	{
		int retorno = 3;
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getCodigo() == produto.getCodigo()) {
				System.out.println("ERRO: O produto informado já existe.");
				retorno = 2;
				break;
			}
		}
		
		
		if (retorno != 2) {	
			try {
				
				produtos.add(produto);
				System.out.println("SUCESSO: O produto foi adicionado na lista.");
				retorno = 0;
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("ERRO: A lista de produtos infelizmente está cheia. (" + e.getMessage() + ")");
				retorno = 1;
			}
			catch (Exception e) {
				System.out.println("ERRO: Algum erro de origem desconhecida aconteceu. (" + e.getMessage() + ")");
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

}
