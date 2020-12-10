package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import fachada.Fachada;
import modelo.Pedido;
import modelo.Usuario;


public class TestarErros {

	public TestarErros(){
		Fachada.inicializar();
		
		Usuario p;
		Pedido t;
		
		try {p = Fachada.cadastrarUsuario("Tom Sousa", "0909", "9999999", "tom@ifpb", "8888", "Jampa", "Centro", "Rua tal", "68");
		}catch (Exception e) {System.out.println(e.getMessage());}
		
		try {Fachada.alterarPedido(3, "Vale", "Inacio", "09");
		}catch (Exception e) {System.out.println(e.getMessage());}

		try {Fachada.alterarDadosNaoLogado("0909", "Andreia", "andreia@ifpb", "9999");
		}catch (Exception e) {System.out.println(e.getMessage());}

		try {Fachada.excluirUsuario("6687");
		}catch (Exception e) {System.out.println(e.getMessage());}
		
		try {Fachada.excluirPedidoPessoa(2);
		}catch (Exception e) {System.out.println(e.getMessage());}

		Fachada.finalizar();
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new TestarErros();
	}
}

