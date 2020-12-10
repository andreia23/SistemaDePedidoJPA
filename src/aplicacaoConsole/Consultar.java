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

			System.out.println(Fachada.consultarUsuarioPorParteNome("lu"));
			System.out.println(Fachada.consultarPessoasNPedidos(3));
			System.out.println(Fachada.consultarPedidosPorId(8));
			System.out.println(Fachada.consultartotalDeUsuarios());
			System.out.println(Fachada.consultartotalDePedidos());

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
