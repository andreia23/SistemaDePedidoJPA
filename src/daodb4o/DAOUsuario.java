package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import modelo.Usuario;


;



public class DAOUsuario extends DAO<Usuario> {

	public Usuario readlogin (Object chave,Object chave1) {
		String email = (String) chave;//casting para o tipo da chave
		String senha = (String) chave1;
		
		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("email").constrain(email);
		q.descend("senha").constrain(senha);
		List<Usuario> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else 
			return null;
	}

	//cpf � campo unico
	public Usuario read (Object chave) {
		String cpf = (String) chave;	//casting para o tipo da chave
		
		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("cpf").constrain(cpf);
		List<Usuario> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	
	
	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE USUARIOS
	 * 
	 **********************************************************/
	public  List<Usuario> consultarUsuariosPorParteNome(String caracteres) {
		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("nomeUsuario").constrain(caracteres).like();
		List<Usuario> result = q.execute(); 
		return result;
	}

	public List<Usuario>  consultarPessoasNPedidos(int n) {
		Query q = manager.query();
		q.constrain(Usuario.class);
		q.constrain(new Filtro(n));
		List<Usuario> result = q.execute(); 
		return result;
	}
	
	public int consultarTotalUsuarios() {
		Query q = manager.query();
		q.constrain(Usuario.class);
		int total = q.execute().size(); 
		return total;
	}
	


	
}



	


	

