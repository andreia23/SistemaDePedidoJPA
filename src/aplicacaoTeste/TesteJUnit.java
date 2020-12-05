
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
import modelo.Pessoa;

public class TesteJUnit {
	@BeforeAll
	//antes de todos os testes
	public static void inicializarGeral() {
		Fachada.inicializar();
	}

	@Test
	//cadastrar uma pessoa sem telefone
	public void test1() throws Exception {
		Pessoa p = Fachada.cadastrarPessoa("manoel");
		assertEquals(p.getNome(), "manoel");
		assertEquals(p.getTelefones().size(), 0);
	}

	@Test
//	cadastrar uma pessoa com varios telefones
	public void test2() throws Exception {
		Pessoa p;
		p = Fachada.cadastrarPessoa("joel", "1111");
		p = Fachada.cadastrarPessoa("joel", "2222");
		assertEquals(p.getNome(), "joel");
		assertEquals(p.getTelefones().size(), 2);
		assertEquals(p.getTelefones().get(0).getNumero(), "1111");
		assertEquals(p.getTelefones().get(1).getNumero(), "2222");
	}

	@Test
	//verificar unicidade de objeto
	public void test3()  {
		assertThrows(Exception.class, () ->	{
			Fachada.cadastrarPessoa("julia");
			Fachada.cadastrarPessoa("julia");
		});
	}

	@AfterAll 		
	//depois de todos os testes
	public static void depois()  {
		limpeza();
		Fachada.finalizar();
	}

	
	public static void limpeza() {
		try {Fachada.excluirPessoa("manoel");}
		catch(Exception e) {e.printStackTrace();}
		try {Fachada.excluirPessoa("joel");}
		catch(Exception e) {e.printStackTrace();}
		try {Fachada.excluirPessoa("julia");}
		catch(Exception e) {e.printStackTrace();}
	}
}
