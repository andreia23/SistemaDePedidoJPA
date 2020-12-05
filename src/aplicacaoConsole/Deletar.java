package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;


public class Deletar {

	public Deletar(){
		try {
			Fachada.inicializar();
			Fachada.excluirPessoa("jose");
			System.out.println("deletou jose e seus telefones");
			Fachada.excluirTelefonesFixosPessoa("maria");
			System.out.println("deletou o telefone fixo de maria:");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Fachada.finalizar();
		}

		System.out.println("fim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

