package view;

import java.util.Scanner;
import model.TabelaDePrecos;

public class InterfaceDeUsuario {

	private TabelaDePrecos tabela = new TabelaDePrecos(100);
	private Scanner entrada = new Scanner(System.in);
	
	public void menu()
	{
		// local variables
		int codigo, opcao;
		String descricao;
		double preco;
		
		System.out.println("0.Sair");
		System.out.println("1.Inserir produto na tabela");
		System.out.println("2.Consultar pre�o");
		opcao = entrada.nextInt();
		while(opcao!=0)
		{
			switch(opcao)
			{
			case 1: //Insira o produto na tabela
				System.out.print("C�digo: ");
				codigo = entrada.nextInt();
				System.out.print("Pre�o: ");
				preco = entrada.nextDouble();
				System.out.print("Descri��o: ");
				descricao = entrada.nextLine();
				tabela.inserirProduto(codigo, preco, descricao, tipo);
				
				// TO-DO
				
				break;

			case 2: //Checar o preço
				System.out.print("C�digo: ");
				codigo = entrada.nextInt();

				// completar
				
				break;
			}
			System.out.println("0.Sair");
			System.out.println("1.Inserir produto na tabela");
			System.out.println("2.Consultar pre�o");
			opcao = entrada.nextInt();
		}


	}
	
}
