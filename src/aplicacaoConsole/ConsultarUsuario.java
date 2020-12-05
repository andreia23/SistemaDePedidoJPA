package aplicacaoConsole;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada2;

public class ConsultarUsuario {

	public ConsultarUsuario() {
		Fachada2.inicializar();
		try {

			System.out.println(Fachada2.consultarUsuarioPorParteNome("lu"));
			System.out.println(Fachada2.consultarPessoasNPedidos(5));
			System.out.println(Fachada2.consultarPedidosPorId(2));
			System.out.println(Fachada2.consultartotalDeUsuarios());
			System.out.println(Fachada2.consultartotalDePedidos());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada2.finalizar();
		System.out.println("\nfim do programa");
	}

	// =================================================
	public static void main(String[] args) {
		new ConsultarUsuario();
	}
}
