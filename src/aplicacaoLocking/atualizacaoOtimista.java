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

import modelo.Produto;


public class atualizacaoOtimista {
	private static EntityManager manager;

	public atualizacaoOtimista(){
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("eclipselink");
		manager = factory.createEntityManager();

		Produto p=null;
		int idproduto=1;	

		try{
			manager.getTransaction().begin();	
			p = manager.find(Produto.class, idproduto);
			System.out.println(p);
			manager.getTransaction().commit();		
			System.out.println("venda realizada com sucesso: \n " + p);	
		}

		catch(Exception e){
			System.out.println("problema no commit "+e.getMessage());
		}
		System.out.println("FIM");

		manager.close();
		factory.close();
	}


	//=================================================
	public static void main(String[] args) {
		new atualizacaoOtimista();
	}
	//=================================================

}
