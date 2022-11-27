package model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that implements an product price table.
 * 
 *
 * @author Marcos & Gustavo Baldin
 * @version 27/11/2022
 */

public class TabelaDePrecos {

	private int capacidade;
	private ArrayList<Produto> produtos = new ArrayList<Produto>(capacidade);
	private Scanner in = new Scanner(System.in);
	

	/**
	 * Constructor that initializes a TabelaDePrecos with predefined size 
	 *
	 * @param capacidade - The max capacity of the table
	 */
	public TabelaDePrecos(int capacidade)
	{
		this.capacidade = capacidade;
	}

	/**
	 * Method that return a product price when has given its code. 
	 *
	 * @param codigo - The product's code that you want to get the price
	 * @return The price of the product in accord with the given code; if it returns
	 * nothing (the product doesn't exists) the method will return -1
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
	* Method that inserts a product into the table

	* @param code - The product's code
	* @param price - The price of the product
	* @param descricao - The description of the product
	* @return An integer informing the insertion status: 0 - insertion
	* happened without problems; 1- insertion did not happen because the table was full;
	* 2- insertion did not happen because there was already a product in the table with the code
	* informed
	 */
	public int inserirProduto(int codigo, double preco, String descricao)
	{
		int retorno = 3;
		System.out.println("Informe o código do produto: ");
		codigo = in.nextInt();
		System.out.println("Informe o preço do produto: ");
		preco = in.nextDouble();
		in.nextLine();
		System.out.println("Informe a descrição do produto: ");
		descricao = in.nextLine();
		
		Produto novoProduto = new Produto(codigo, preco, descricao);

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
	* Method that inserts a product into the table
	* 
	* @param product - The Product object to be included in the table
	* @return An integer informing the insertion status: 0 - insertion
	* happened without problems; 1- insertion did not happen because the table was full;
	* 2- insertion did not happen because there was already a product in the table with the code
	* informed
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
	 * Method that removes a product from the table
	 *
	 * @param codigo - The code of the product that should be removed
	 */
	public void removerProduto(int codigo)
	{
		// TO-DO
	}
	
	
	public ArrayList<Produto> pesquisaPorPalavraChave(String chave)
	{
		ArrayList<Produto> temp = new ArrayList<Produto>(capacidade);
			
		
		return temp;
	}

}
