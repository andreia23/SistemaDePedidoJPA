package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import modelo.Pedido;
import modelo.Usuario;
import fachada.Fachada2;


public class ListarUsuarios {

	public ListarUsuarios(){
		try {
			Fachada2.inicializar();
			
			System.out.println("Listagem de usuários:");
			for(Usuario p : Fachada2.listarUsuarios())		
				System.out.println(p);
			
			System.out.println("\nListagem de pedidos:");
			for(Pedido t : Fachada2.listarPedidos())	
				System.out.println(t);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada2.finalizar();
		System.out.println("fim do programa");
	}

	//=================================================
	public static void main(String[] args) {
		new ListarUsuarios();
	}
}

