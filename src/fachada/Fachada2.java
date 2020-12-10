package fachada;

import java.util.List;

import daojpa.DAO;
import daojpa.DAOEndereco;
import daojpa.DAOPedido;
import daojpa.DAOProduto;
import daojpa.DAOUsuario;
import modelo.Endereco;
import modelo.Pedido;
import modelo.Produto;
import modelo.Usuario;

public class Fachada2 {
	private static DAOUsuario daousuario = new DAOUsuario();
	private static DAOPedido daopedido = new DAOPedido();
	private static DAOEndereco daoendereco = new DAOEndereco();
	private static DAOProduto daoproduto = new DAOProduto();
	private static Usuario logado;

	public static void inicializar() {
		DAO.open();
	}

	public static void finalizar() {
		DAO.close();
	}

	/**********************************************************
	 * USUARIO
	 **********************************************************/

	/// localiza a pessoa no repositorio, a torna pessoa logada e retorna esta
	/// pessoa
	public static Usuario login(String email, String senha) throws Exception {

		if (logado != null) {
			throw new Exception("ja existe um usuario logado:" + logado.getEmail());
		}

		Usuario usu = daousuario.readlogin(email, senha);
		if (usu == null) {
			throw new Exception("email ou senha invalida:");
		}

//		List<Pedido> pedidos = daopedido.readAll();
//		for (Pedido p : pedidos) {
//			if(usu.getCpf() == p.getUsuario().getCpf()) {
//				codigoPedido = p.getCodigoPedido();
//			}
//		}
		logado = usu;
		return usu;

	}

	// descarta a pessoa logada
	public static void logoff() throws Exception {

		if (logado == null) {
			throw new Exception("nao existe um usuario logado:");
		}

		logado = null;
	}

	// retorna a pessoa logada
	public static Usuario getLogado() {
		return logado;
	}

	// CADASTRANDO USUARIO
	public static Usuario cadastrarUsuario(String nome, 
			String cpf, String fone, String email, String senha,
			String cidade, String bairro, String rua, String numero) throws Exception {
		DAO.begin();
		Usuario usuario = daousuario.read(cpf);

		if (usuario != null) {
			DAO.rollback();
			throw new Exception("cadastrar pessoa - pessoa com cpf j� cadastrado:" + nome);
		}

		usuario = new Usuario(nome, cpf, fone, email, senha);
		Endereco endereco = new Endereco(cidade, bairro, rua, numero);
		endereco.adicionarUsuario(usuario);
		daousuario.create(usuario);
		daoendereco.create(endereco);
		DAO.commit();
		return usuario;
	}

	// LISTANDO USUARIOS
	public static List<Usuario> listarUsuarios() {
		return daousuario.readAll();
	}

	// EXCLUINDO USUARIO
	public static void excluirUsuario(String cpf) throws Exception {
		DAO.begin();
		Usuario u = daousuario.read(cpf);

		if (u == null) {
			DAO.rollback();
			throw new Exception("excluir pessoa - cpf inexistente:" + cpf);
		}

		System.out.println("deletando o usuario:" + u.getNomeUsuario());
		daousuario.delete(u); // cascata
		DAO.commit();
	}

	// ALTERANDO DADOS USUARIO N�O LOGADO
	public static void alterarDadosNaoLogado(String cpf, String novonome, String novoemail, String novasenha)
			throws Exception {
		DAO.begin();
		Usuario us = daousuario.read(cpf);

		if (us == null) {
			DAO.rollback();
			throw new Exception("alterar dados - cpf inexistente:" + cpf);
		}

		us.setNomeUsuario(novonome);
		us.setEmail(novoemail);
		us.setSenha(novasenha);
		us = daousuario.update(us);
		DAO.commit();
	}

	// ALTERANDO DADOS USUARIO LOGADO
	public static void alterarDadosLogado(String novonome, String novoemail, String novasenha) throws Exception {
		DAO.begin();

		if (logado == null) {
			throw new Exception("Precisa fazer login");
		}
		;

		logado.setNomeUsuario(novonome);
		logado.setEmail(novoemail);
		logado.setSenha(novasenha);
		logado = daousuario.update(logado);
		DAO.commit();
	}

	/**********************************************************
	 * PEDIDO
	 **********************************************************/

	// REALIZANDO PEDIDO
	public static Pedido realizarPedidoEnderecoUsuario(Endereco endereco,int quantidadeProduto,
			String nomeProduto, Double valorProduto, Double valorTotalPedido) throws Exception {

		DAO.begin();
		if (logado == null) {
			throw new Exception("Precisa fazer login");
		}
		;

		Produto produto = new Produto(quantidadeProduto, nomeProduto, valorProduto);
		Pedido pedido = new Pedido(valorTotalPedido);
		pedido.adicionar(produto);
		endereco.adicionarPedido(pedido);
		logado.adicionar(pedido);
		daousuario.update(logado);
		daoproduto.create(produto);
		daopedido.create(pedido);
		DAO.commit();
		return pedido;
	}
	
	public static Pedido realizarPedido(String cidade, String bairro, String rua, String numero, int quantidadeProduto,
			String nomeProduto, Double valorProduto, Double valorTotalPedido) throws Exception {

		DAO.begin();
		if (logado == null) {
			throw new Exception("Precisa fazer login");
		}
		;

		Endereco endereco = new Endereco(cidade, bairro, rua, numero);
		Produto produto = new Produto(quantidadeProduto, nomeProduto, valorProduto);
		Pedido pedido = new Pedido(valorTotalPedido);
		pedido.adicionar(produto);
		endereco.adicionarPedido(pedido);
		logado.adicionar(pedido);
		daousuario.update(logado);
		daoendereco.create(endereco);
		daoproduto.create(produto);
		daopedido.create(pedido);
		DAO.commit();
		return pedido;
	}

	// LISTAR PEDIDOS
	public static List<Pedido> listarPedidos() {
		return daopedido.readAll();
	}

	// LISTA OS PEDIDOS POR USUARIO
	public static String listarMeusPedidos() throws Exception {

		if (logado == null) {
			throw new Exception("Precisa fazer login");
		}
		;

		Usuario us = daousuario.read(logado.getCpf());
		if (us.getPedidos().isEmpty()) {
			throw new Exception("Nenhum pedido realizado");
		}

		String texto = "PEDIDOS:" + "\n";
		for (Pedido p : us.getPedidos())
			texto += p + "\n";

		return texto;
	}

	// EXCLUIR PEDIDO
	public static Pedido excluirPedidoPessoa(Integer codigo) throws Exception {
		DAO.begin();

		if (logado == null) {
			DAO.rollback();
			throw new Exception("Precisa fazer login");
		}
		;

		Pedido t = daopedido.read(codigo);
		if (t == null) {
			DAO.rollback();
			throw new Exception("excluir Pedido - Pedido n�o cadastrado");
		}

		t = logado.localizar(codigo); // localiza dentro do objeto
		if (t == null) {
			DAO.rollback();
			throw new Exception("excluir pedido - pessoa nao possui este pedido:" + logado.getPedidos());
		}

		logado.remover(t);
		daousuario.update(logado);
		daopedido.delete(t); // excluir telefone orfao
		DAO.commit();
		return t;
	}

	// ALTERAR DADOS DO PEDIDO
	public static void alterarPedido(Integer codigo, String novobairro, String novarua, String novonumero)
			throws Exception {
		DAO.begin();

		if (logado == null) {
			DAO.rollback();
			throw new Exception("Precisa fazer login");
		}
		;

		Pedido t = daopedido.read(codigo);
		if (t == null) {
			DAO.rollback();
			throw new Exception("alterar pedido - pedido inexistente:" + codigo);
		}

		Endereco novoend = new Endereco(t.getEnderecoEntrega().getCidade(), novobairro, novarua, novonumero);
		t.setEnderecoEntrega(novoend);
		t = daopedido.update(t);
		DAO.commit();
	}

	/**********************************************************
	 * 
	 * CONSULTAS
	 * 
	 **********************************************************/

	public static String consultarUsuarioPorParteNome(String caracteres) {
		List<Usuario> result = daousuario.consultarUsuarios(caracteres);

		String texto = "\nCONSULTAR USUARIOS POR PARTE DO NOME:" + caracteres.toUpperCase();
		if (result.isEmpty())
			texto += "consulta vazia";
		else
			for (Usuario p : result)
				texto += "\n" + p;
		return texto;
	}

	public static String consultarPessoasNPedidos(int n) {
		List<Usuario> result = daousuario.consultarPessoasNPedidos(n);

		String texto = "\nCONSULTAR USUARIOS COM " + n + " PEDIDOS:";
		if (result.isEmpty())
			texto += "consulta vazia";
		else
			for (Usuario p : result)
				texto += "\n" + p;
		return texto;
	}

	public static String consultarPedidosPorId(Integer n) {
		List<Pedido> result = daopedido.consultarPedidos(n);
		String texto = "\nCONSULTAR PEDIDOS ";
		if (result.isEmpty())
			texto += "consulta vazia";
		else
			for (Pedido t : result)
				texto += "\n" + t;
		return texto;
	}

	public static String consultartotalDeUsuarios() {
		int usuarios = daousuario.consultarTotalUsuarios();
		return "\nTOTAL DE USUARIOS: " + usuarios;

	}

	public static String consultartotalDePedidos() {
		int pedidos = daopedido.consultarTotalPedidos();
		return "TOTAL DE PEDIDOS: " + pedidos;

	}

}
