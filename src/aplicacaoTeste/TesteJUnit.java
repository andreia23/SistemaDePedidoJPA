
/*
 * IFPB - TSI - Persistencia de Objetos
 * Fausto Ayres
 * 
 * Teste da Fachada com JUnit 5
 * 
 */
package aplicacaoTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fachada.Fachada;
import fachada.Fachada;
import modelo.Usuario;

public class TesteJUnit {
	@BeforeAll
	//antes de todos os testes
	public static void inicializarGeral() {
		Fachada.inicializar();
	}

	@Test
	//cadastrar uma pessoa sem telefone
	public void test1() throws Exception {
		Usuario p = Fachada.cadastrarUsuario("Tom Sousa", "0909", "9999999", "tom@ifpb", "8888", "Jampa", "Centro", "Rua tal", "68");
		assertEquals(p.getCpf(), "0909");
	}

	@AfterAll 		
	//depois de todos os testes
	public static void depois()  {
		limpeza();
		Fachada.finalizar();
	}

	
	public static void limpeza() {
		try {Fachada.excluirUsuario("0909");}
		catch(Exception e) {e.printStackTrace();}
	}
}
