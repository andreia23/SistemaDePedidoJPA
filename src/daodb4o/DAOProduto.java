package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import modelo.Produto;

public class DAOProduto extends DAO<Produto>{
	@Override
	public Produto read (Object chave) {
		Integer codEndereco = (Integer) chave;
		
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("codEndereco").constrain(codEndereco);
		List<Produto> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
}
