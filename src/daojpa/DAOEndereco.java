package daojpa;

import modelo.Endereco;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class DAOEndereco extends DAO<Endereco> {

	@Override
	public Endereco read(Object chave) {
		try {
			String rua = (String) chave;
			TypedQuery<Endereco> q = manager.createQuery("select p from Endereco p where p.rua=:n", Endereco.class);
			q.setParameter("n", rua);

			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Endereco> readAll() {
		TypedQuery<Endereco> q = manager.createQuery("select p from Endereco p order by p.codEndereco", Endereco.class);
		return q.getResultList();
	}

}
