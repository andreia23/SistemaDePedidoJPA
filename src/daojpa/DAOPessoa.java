/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Pessoa;

public class DAOPessoa extends DAO<Pessoa>{

	public Pessoa read (Object chave){
		try{
			String nome = (String) chave;
			TypedQuery<Pessoa> q = manager.createQuery("select p from Pessoa p where p.nome=:n", Pessoa.class);
			q.setParameter("n", nome);

			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	//  //pode-se sobrescrever o metodo readAll da classe DAO para ordenar o resultado 
	public List<Pessoa> readAll(){
		TypedQuery<Pessoa> q = manager.createQuery("select p from Pessoa p order by p.id", Pessoa.class);
		return  q.getResultList();
	}

	//--------------------------------------------
	//  consultas
	//--------------------------------------------
	public  List<Pessoa> consultarPessoas(String caracteres) {
		TypedQuery<Pessoa> q = manager.createQuery
				("select p from Pessoa p where p.nome like '%"+caracteres+"%' order by p.nome",Pessoa.class);
		return q.getResultList();
	}

	public  List<Pessoa>  consultarPessoasNTelefones(int n) {
		TypedQuery<Pessoa> q = manager.createQuery
				("select p from Pessoa p where SIZE(p.telefones) = :x",Pessoa.class);
		q.setParameter("x", n);
		return q.getResultList(); 
	}

	public  boolean  temTelefoneCelular(String nome) {
		try{
			TypedQuery<Pessoa> q = manager.createQuery
					("select p from Pessoa p join p.telefones t where p.nome = :x and t.numero like :y",Pessoa.class);
			q.setParameter("x", nome);
			q.setParameter("y", "9%"); //prefixo 9
			Pessoa p = q.getSingleResult();
			if (p==null)	return false;
			else			return true;

		}catch(NoResultException e){
			return false;
		}
	}

	public  boolean  temTelefoneFixo(String nome) {
		try{
			TypedQuery<Pessoa> q = manager.createQuery
					("select p from Pessoa p join p.telefones t where p.nome = :x and t.numero like :y",Pessoa.class);
			q.setParameter("x", nome);
			q.setParameter("y", "3%"); //prefixo 9
			Pessoa p = q.getSingleResult();
			if (p==null)	return false;
			else			return true;
		}catch(NoResultException e){
			return false;
		}
	}


}

