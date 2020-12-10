package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import modelo.Pedido;
import modelo.Usuario;
import fachada.Fachada;


public class Listar {

	public Listar(){
		try {
			Fachada.inicializar();
			
			System.out.println("Listagem de usuários:");
			for(Usuario p : Fachada.listarUsuarios())		
				System.out.println(p);
			
			System.out.println("\nListagem de pedidos:");
			for(Pedido t : Fachada.listarPedidos())	
				System.out.println(t);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("fim do programa");
	}

	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

