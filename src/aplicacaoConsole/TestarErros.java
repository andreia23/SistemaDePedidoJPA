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


public class TestarErros {

	public TestarErros(){
		Fachada.inicializar();
		
		Pessoa p;
		Telefone t;
		
		try {p = Fachada.cadastrarPessoa("joao");   
		}catch (Exception e) {System.out.println(e.getMessage());}
		
		try {p = Fachada.cadastrarPessoa("joao", "988880000");
		}catch (Exception e) {System.out.println(e.getMessage());}
		
		try {p = Fachada.alterarPessoa("joao", "joao");
		}catch (Exception e) {System.out.println(e.getMessage());}

		try {t = Fachada.alterarTelefone("00000000", "988889999");
		}catch (Exception e) {System.out.println(e.getMessage());}

		try {Fachada.excluirPessoa("xxxxxxx");
		}catch (Exception e) {System.out.println(e.getMessage());}
		
		try {Fachada.excluirTelefone("00000000");
		}catch (Exception e) {System.out.println(e.getMessage());}

		Fachada.finalizar();
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new TestarErros();
	}
}

