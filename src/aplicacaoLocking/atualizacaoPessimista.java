package aplicacaoLocking;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/


import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import modelo.Produto;


//OBS:
//Para lan�ar furar o bloquei com uma exce��o fa�a no PGAdimnIII :
//alterar a propriedade "lock timeout" dentro do arquivo postgresql.conf  no menu Tools/Server Configuration
//salvar e recarregar a configura��o
//--------------------------------------------------------------------------------------------------------

public class atualizacaoPessimista {
	protected static EntityManager manager;
	Scanner teclado = new Scanner(System.in);

	public atualizacaoPessimista(){
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("eclipselink");
		manager = factory.createEntityManager();

		Produto p=null;
		int id=1;

		try{
			manager.getTransaction().begin();	
			p = manager.find(Produto.class, id);
			System.out.println(p);	
			//=======================================================
			//lock pessimista (bloqueio do objeto)
			manager.lock(p,LockModeType.PESSIMISTIC_WRITE); 
			//=======================================================
			
			manager.getTransaction().commit();	
			System.out.println("venda realizada com sucesso: \n " + p);	

		}
		catch(Exception e){
			//exce��o so ocorre quando ativamos o lock timeout dentro dp postgres.conf
			//------------------------------------------------------------------------
			if(e.getMessage().contains("canceling statement due to lock timeout"))
				System.out.println("Sorry! \nproduto esta sendo vendido p outra pessoa \ntente mais tarde");
		}
		System.out.println("FIM");

		manager.close();
		factory.close();
	}




	//=================================================
	public static void main(String[] args) {
		new atualizacaoPessimista();
	}
	//=================================================

}
