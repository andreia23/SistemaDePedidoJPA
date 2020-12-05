package daodb4o;

import modelo.Endereco;
import java.util.List;

import com.db4o.query.Query;


public class DAOEndereco extends DAO<Endereco>{
	
	@Override
	public Endereco read (Object chave) {
		Integer codEndereco = (Integer) chave;
		
		Query q = manager.query();
		q.constrain(Endereco.class);
		q.descend("codEndereco").constrain(codEndereco);
		List<Endereco> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	


}




