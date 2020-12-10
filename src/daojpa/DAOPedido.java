/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Pedido;
import modelo.Usuario;

public class DAOPedido extends DAO<Pedido> {
	// numero � campo �nico
	public Pedido read(Object chave) {
		try {
			Integer codigoPedido = (Integer) chave;
			TypedQuery<Pedido> q = manager.createQuery("select p from Pedido p where p.codigoPedido = :n ",
					Pedido.class);
			q.setParameter("n", codigoPedido);

			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE TELEFONE
	 * 
	 **********************************************************/

	public List<Pedido> consultarPedidos(Integer CodigoPedido) {
		TypedQuery<Pedido> q = manager.createQuery("select t from Pedido t where t.codigoPedido=:n", Pedido.class);
		q.setParameter("n", CodigoPedido);
		return (List<Pedido>) q.getResultList();
	}

	public int consultarTotalPedidos() {
		TypedQuery<Pedido> q = manager.createQuery("select count(p) from Pedido p", Pedido.class);

		return q.getFirstResult();
	}

}
