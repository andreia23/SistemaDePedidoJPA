package aplicacaoConsole;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import modelo.Usuario;
import fachada.Fachada2;

public class AlterarUsuario {

	public AlterarUsuario() {
		Fachada2.inicializar();
		Usuario u;
		try {

			// TESTAR ALTERAR DADOS DO PEDIDO
			Fachada2.alterarPedido(10, "Jaguaribe", " Carmem", "56");

			//ALTERAR DADOS DE USUÁRIO NÃO LOGADO
//			Fachada2.alterarDadosNaoLogado(cpf, novonome, novoemail, novasenha);
			
			// TESTAR LISTAR PEDIDO POR USUARIO
			System.out.println(Fachada2.listarMeusPedidos());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada2.finalizar();
		System.out.println("fim do programa");
	}

	// =================================================
	public static void main(String[] args) {
		new AlterarUsuario();
	}
}
