package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Produto;

public class DAOProduto extends DAO<Produto> {
	@Override
	public Produto read(Object chave) {
		try {
			String nome = (String) chave;
			TypedQuery<Produto> q = manager.createQuery("select p from Produto p where p.nomeProduto=:n",
					Produto.class);
			q.setParameter("n", nome);

			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Produto> readAll() {
		TypedQuery<Produto> q = manager.createQuery("select p from Produto p order by p.idProduto", Produto.class);
		return q.getResultList();
	}
}
