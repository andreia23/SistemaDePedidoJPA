package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Pessoa;
import modelo.Telefone;


public class Alterar {

	public Alterar(){
		try {
			Fachada.inicializar();
			
			Pessoa p;
			Telefone t;
			p = Fachada.alterarPessoa("paulo", "paula");
			System.out.println("\npessoa alterada -->"+p);
			
			t = Fachada.alterarTelefone("988880000", "999999999");
			System.out.println("\ntelefone removido -->"+t);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new Alterar();
	}
}

