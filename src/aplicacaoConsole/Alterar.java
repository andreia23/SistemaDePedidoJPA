package aplicacaoConsole;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import modelo.Usuario;
import fachada.Fachada;

public class Alterar {

	public Alterar() {
		Fachada.inicializar();
		Usuario u;
		try {

			// TESTAR ALTERAR DADOS DO PEDIDO
//			Fachada.alterarPedido(3, "Vale", "Inacio", "09");

			//ALTERAR DADOS DE USUÁRIO NÃO LOGADO
			Fachada.alterarDadosNaoLogado("1111", "Andreia", "andreia@ifpb", "9999");
			
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("fim do programa");
	}

	// =================================================
	public static void main(String[] args) {
		new Alterar();
	}
}
