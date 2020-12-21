package aplicacaoConsole;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;

public class Consultar {

	public Consultar() {
		Fachada.inicializar();
		try {

			System.out.println(Fachada.consultarUsuarioPorParteNome("ana"));
		

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("\nfim do programa");
	}

	// =================================================
	public static void main(String[] args) {
		new Consultar();
	}
}
