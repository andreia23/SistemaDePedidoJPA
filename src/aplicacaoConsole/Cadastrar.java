package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import modelo.Usuario;
import fachada.Fachada;



public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			Usuario u;
			
//			System.out.println("cadastrando...");
//			u =Fachada.cadastrarUsuario("Tom Sousa", "0909", "9999999", "tom@ifpb", "8888", "Jampa", "Centro", "Rua tal", "68");
//			System.out.println(u);
//			
			//TESTAR LOGIN
			u = Fachada.login("tom@ifpb", "8888");
			System.out.println("pessoa logada =>" + Fachada.getLogado());
			
			//TESTAR REALIZAR PEDIDO COM ENDERECO CADASTRADO DO USUARIO
			Fachada.realizarPedidoEnderecoUsuario(u.getEndereco(), 8, "Carne", 100.50,120.90);
			System.out.println("pedido feito com sucesso=>" + Fachada.getLogado().getPedidos());
			
//			//TESTAR REALIZAR PEDIDO
			Fachada.realizarPedido("Patos", "Centro", "Rua tal", "68", 10, "Peixe", 20.80, 25.90);
			System.out.println("pedido feito com sucesso=>" + Fachada.getLogado().getPedidos());
//			


//			//TESTAR ALTERAR DADOS DO USUARIO
//			System.out.println("alterando...");
//			Fachada2.alterarDadosLogado("Mael","mael@IFPB","2222");
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
			Fachada.finalizar();
		}

		System.out.println("fim do programa");
	}


	public void cadastrar(){

	}	


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


