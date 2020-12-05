package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Pessoa;


public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			
			System.out.println("cadastrando...");
			Pessoa p;
			p=Fachada.cadastrarPessoa("joao","988880000");
			p=Fachada.cadastrarPessoa("joao","988881111");	
			p=Fachada.cadastrarPessoa("maria","987882222");
			p=Fachada.cadastrarPessoa("maria","988883333");
			p=Fachada.cadastrarPessoa("maria","32471234");
			p=Fachada.cadastrarPessoa("jose","987884444");
			p=Fachada.cadastrarPessoa("paulo");
			p=Fachada.cadastrarPessoa("ana");
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


