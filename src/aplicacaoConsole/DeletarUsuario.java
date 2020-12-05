package aplicacaoConsole;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import modelo.Usuario;
import fachada.Fachada2;

public class DeletarUsuario {

	public DeletarUsuario() {
		Fachada2.inicializar();
		Usuario u = null;
		try {

			System.out.println("deletando...");
			Fachada2.excluirUsuario("1212");
			Fachada2.excluirPedidoPessoa(2);

			System.out.println("deletado");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada2.finalizar();
		System.out.println("fim do programa");
	}

	// =================================================
	public static void main(String[] args) {
		new DeletarUsuario();
	}
}
