package aplicacaoLocking;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import modelo.Produto;



public class atualizacaoOtimistaLoop {
	private static EntityManager manager;

	
	//=======================================================
	//obs: descomentar @version na classe Produto 
	//(habilita o controle de concorrencia de produto)
	//=======================================================
	
	public atualizacaoOtimistaLoop(){
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("eclipselink");
		manager = factory.createEntityManager();

		Produto p=null;
		int id=1;	
		boolean sair=false;
		while (sair==false)	{
			try{
				manager.getTransaction().begin();	
				p = manager.find(Produto.class, id);
				System.out.println(p);
				manager.getTransaction().commit();		
				System.out.println("venda realizada com sucesso: \n " + p);	
				sair=true;
			}
			catch(RollbackException e){
				System.out.println("transa��o cancelada devido a uma outra transacao commitada ");
				System.out.println("tentar outra vez ");
				sair=false;
			}
			catch(Exception e){
				System.out.println("problema no commit "+e.getMessage());
				sair=true;
			}
		}//while
		System.out.println("FIM");
		
		manager.close();
		factory.close();
	}


	//=================================================
	public static void main(String[] args) {
		new atualizacaoOtimistaLoop();
	}
	//=================================================

}
