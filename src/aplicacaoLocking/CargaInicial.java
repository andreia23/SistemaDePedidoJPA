package aplicacaoLocking;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Produto;

public class CargaInicial {
	protected static EntityManager manager;

	public CargaInicial(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("eclipselink");
		manager = factory.createEntityManager();

		cadastrar();
		//reporEstoque(1); 	//repor 10 unidades
		listar();
		
		manager.close();
		factory.close();
	}
	
	public void cadastrar() {
		Produto p;
		manager.getTransaction().begin();
		p = new Produto(2, "pizza", 30.7);
		manager.persist(p);  
		manager.getTransaction().commit();

		manager.getTransaction().begin();
		p = new Produto(3, "suco",10.60 );
		manager.persist(p);
		manager.getTransaction().commit();

		manager.getTransaction().begin();
		p = new Produto(5, "brigadeiro", 3.5);
		manager.persist(p);  
		manager.getTransaction().commit();	

		System.out.println("cadastro concluido");
	}

	@SuppressWarnings("unchecked")
	public void listar(){
		System.out.println("-----------listagem de Produtos-----------");
		Query query = manager.createQuery("select p from Produto p");
		List<Produto> produtos = (List<Produto>) query.getResultList();
		for (Produto p : produtos) {
			System.out.println(p);
		}
	}

	public void reporEstoqueProduto(int id) {
		Produto p;
		manager.getTransaction().begin();
		Query q= manager.createQuery("update Produto p set p.estoque=10 where p.id="+id);
		int i = q.executeUpdate() ; 
		manager.getTransaction().commit();
	}
	
	//=================================================
	public static void main(String[] args) {
		new CargaInicial();
	}
	//=================================================

}
