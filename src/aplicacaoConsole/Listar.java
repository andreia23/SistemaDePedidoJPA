package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import modelo.Pedido;
import modelo.Usuario;

import java.util.List;

import fachada.Fachada;


public class Listar {

	public Listar(){
		Fachada.inicializar();
		
		List<Usuario> usuarios = Fachada.listarUsuarios();
		String texto="-----------listagem de Usuarios-----------\n";
		for (Usuario pe : usuarios) {
			texto += pe +"\n";
		}
		System.out.println(texto);
		
		List<Pedido> pedidos = Fachada.listarPedidos();
		texto="-----------listagem de Pedidos-----------\n";
		for (Pedido t : pedidos) {
			texto += t +"\n";
		}
		System.out.println(texto);
		
		Fachada.finalizar();
	}

	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

