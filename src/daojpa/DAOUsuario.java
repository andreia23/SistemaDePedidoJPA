package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Usuario;

;

public class DAOUsuario extends DAO<Usuario> {

	public Usuario readlogin(Object chave, Object chave1) {
		try {
			String email = (String) chave;
			String senha = (String) chave1;
			TypedQuery<Usuario> q = manager.createQuery("select u from Usuario u where u.email=:n and u.senha=:s",
					Usuario.class);
			q.setParameter("n", email);
			q.setParameter("s", senha);

			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	// cpf � campo unico
	public Usuario read(Object chave) {
		try {
			String cpf = (String) chave;
			TypedQuery<Usuario> q = manager.createQuery("select u from Usuario u where u.cpf=:n", Usuario.class);
			q.setParameter("n", cpf);

			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	public List<Usuario> readAll() {
		TypedQuery<Usuario> q = manager.createQuery("select p from Usuario p order by p.id", Usuario.class);
		return q.getResultList();
	}

	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE USUARIOS
	 * 
	 **********************************************************/
	public List<Usuario> consultarUsuarios(String caracteres) {
		TypedQuery<Usuario> q = manager.createQuery(
				"select p from Usuario p where p.nomeUsuario like '%" + caracteres + "%' order by p.nome",
				Usuario.class);
		return q.getResultList();
	}

	public List<Usuario> consultarPessoasNPedidos(int n) {
		TypedQuery<Usuario> q = manager.createQuery("select p from Usuario p where SIZE(p.pedidos) = :x",
				Usuario.class);
		q.setParameter("x", n);
		return q.getResultList();
	}

	public int consultarTotalUsuarios() {
		TypedQuery<Usuario> q = manager.createQuery("select count(*) from Usuario", Usuario.class);

		return q.getFirstResult();
	}

}
