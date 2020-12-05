/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package daodb4o;


import java.util.List;

import com.db4o.query.Query;

import modelo.Pedido;






public class DAOPedido  extends DAO<Pedido>{
	//numero � campo �nico 
	public Pedido read (Object chave) {
		Integer codigoPedido = (Integer) chave;
		
		Query q = manager.query();
		q.constrain(Pedido.class);
		q.descend("codigoPedido").constrain(codigoPedido);
		List<Pedido> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	

	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE PEDIDO
	 * 
	 **********************************************************/
	public List<Pedido> consultarPedidoPorProduto(String n){
		Query q = manager.query();
		q.constrain(Pedido.class);
		q.descend("itens").descend("produto").descend("nomeProduto").constrain(n).like();
		List<Pedido> resultados = q.execute();
		if(resultados.size()==0)
			return null;
		else
			return resultados;

	}
	
	public int consultarTotalPedidos() {
		Query q = manager.query();
		q.constrain(Pedido.class);
		int total = q.execute().size(); 
		return total;
	}

	
	public List<Pedido> consultarPedidosPorNome(String nome) {
		Query q = manager.query();
		q.constrain(Pedido.class);
		q.descend("usuario").descend("nomeUsuario").constrain(nome).like();
		List<Pedido> result = q.execute(); 
		return result;
	}


}




