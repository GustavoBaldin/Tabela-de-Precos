package model;

import java.util.ArrayList;

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
		// TO-DO
		return 0;
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
		// TO-DO
		return 0;
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
