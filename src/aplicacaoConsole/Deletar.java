package aplicacaoConsole;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import modelo.Usuario;
import fachada.Fachada;

public class Deletar {

	public Deletar() {
		Fachada.inicializar();
		Usuario u = null;
		try {

			System.out.println("deletando...");
			Fachada.excluirUsuario("6687");
//			Fachada2.excluirPedidoPessoa(2);

			System.out.println("deletado");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("fim do programa");
	}

	// =================================================
	public static void main(String[] args) {
		new Deletar();
	}
}
