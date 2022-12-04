package view;

import java.util.Scanner;
import model.TabelaDePrecos;

public class InterfaceDeUsuario {

	private TabelaDePrecos tabela = new TabelaDePrecos(100);
	private Scanner in = new Scanner(System.in);
	
	public void menu()
	{
		// local variables
		int codigo, opcao, tipo;
		String descricao;
		double preco;
		
		System.out.println("0.Sair");
		System.out.println("1.Inserir produto na tabela");
		System.out.println("2.Consultar preço");
		opcao = in.nextInt();
		while(opcao!=0)
		{
			switch(opcao)
			{
			case 1: //Insira o produto na tabela
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
				
				int resultado = tabela.inserirProduto(codigo, preco, descricao, tipo);
				switch (resultado) {
					case 0:
						System.out.println("SUCESSO: O produto foi adicionado na lista.");
						break;
				
					case 1:
						System.out.println("ERRO: A lista de produtos infelizmente está cheia.");
						break;
						
					case 2:
						System.out.println("ERRO: O produto informado já existe.");
						break;
						
					default:
						System.out.println("ERRO: Algum erro de origem desconhecida aconteceu.");
						break;
				}
				
				break;

			case 2: //Checar o preço
				System.out.print("C�digo: ");
				codigo = in.nextInt();

				// completar
				
				break;
			}
			System.out.println("0.Sair");
			System.out.println("1.Inserir produto na tabela");
			System.out.println("2.Consultar pre�o");
			opcao = in.nextInt();
		}


	}
	
}
