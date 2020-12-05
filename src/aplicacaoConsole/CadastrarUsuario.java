package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import modelo.Usuario;
import fachada.Fachada2;



public class CadastrarUsuario {

	public CadastrarUsuario(){
		try {
			Fachada2.inicializar();
			Usuario u;
			
			System.out.println("cadastrando...");
//			u =Fachada2.cadastrarUsuario("Tom Sousa","0909","12/09/2001","tom@ifpb","8888");
//			System.out.println(u);
			
//			//TESTAR LOGIN
//			u = Fachada2.login("mael@IFPB", "2222");
//			System.out.println("pessoa logada =>" + Fachada2.getLogado());
//			
//			//TESTAR ALTERAR DADOS DO USUARIO
//			System.out.println("alterando...");
//			Fachada2.alterarDadosLogado("Mael","mael@IFPB","2222");
//			
//			//TESTAR REALIZAR PEDIDO
//			Fachada2.realizarPedido("PB","Lucena","Vale","Josefa","23");
//			System.out.println("pedido feito com sucesso=>" + Fachada2.getLogado().getPedidos());
//			
//			//TESTAR LOGOFF
//			Fachada2.logoff();
//			System.out.println("Logoff feito com sucesso");
			
			//TESTAR LISTAR PEDIDO POR USUARIO
//			System.out.println(Fachada2.listarMeusPedidos());
//			
//			
		
		
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		
	
		
		
		
		finally {
			Fachada2.finalizar();
		}

		System.out.println("fim do programa");
	}


	public void cadastrar(){

	}	


	//=================================================
	public static void main(String[] args) {
		new CadastrarUsuario();
	}
}


