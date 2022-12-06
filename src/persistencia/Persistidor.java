package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import model.Produto;

public class Persistidor implements Serializable {

	/**
	 * ID da serialização do objeto, para que não haja erros ou confusões de objetos pela JVM.
	 */
	private static final long serialVersionUID = 1001L;

	/**
	 * O ObjectOutputStream é utilizado para "streamar" um objeto, e o FileOutputStream para
	 * "streamar" um arquivo binário. O objeto, que é uma lista, é escrito e guardado.
	 * @param listaProduto - É a lista de produtos inteira, em um só objeto.
	 */
	
	public void salvarData(ArrayList<Produto> listaProduto) {
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("produtos.bin"));
			oos.writeObject(listaProduto);
			oos.close();
			System.out.println("DATA: Objeto salvo com sucesso.");
		}
		catch (IOException e) {
			System.out.println("ERRO DATA: Objetos incapazes de serem escritos.");
		}
		finally {
			System.out.println("DATA: Operações encerradas.");
		}
		
		
	}
	

	public ArrayList<Produto> inicializarData() {
		
		Object listaProdutos = null;
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("produtos.bin"));
			listaProdutos = ois.readObject();
			ois.close();
		}
		catch (ClassNotFoundException e) {
			System.out.println("ERRO DATA: A classe não foi encontrada.");
		}
		catch (IOException e) {
			System.out.println("INFO DATA: Não há data para ser lida (ainda) ou houve erro de leitura.");
		}

		return (ArrayList<Produto>) listaProdutos;
		
		
	}
	
}
