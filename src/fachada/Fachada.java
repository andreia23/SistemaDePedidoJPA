package fachada;

import java.util.Iterator;
import java.util.List;

import daojpa.*;
//import daodb4o.*;

import modelo.Pessoa;
import modelo.Telefone;

public class Fachada {
	private static DAOPessoa daopessoa = new DAOPessoa();  
	private static DAOTelefone daotelefone = new DAOTelefone();  


	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}

	public static Pessoa cadastrarPessoa(String nome) throws  Exception{
		DAO.begin();	
		Pessoa p = daopessoa.read(nome);
		if(p != null) {
			DAO.rollback();
			throw new Exception("pessoa ja cadastrado:" + nome);
		}
		p = new Pessoa(nome);
		daopessoa.create(p);	
		DAO.commit();
		return p;
	}

	public static Pessoa cadastrarPessoa(String nome, String numero) throws  Exception{
		DAO.begin();	
		Pessoa p = daopessoa.read(nome);
		if(p == null) {
			p = new Pessoa(nome);
			daopessoa.create(p);
		}
		Telefone t = daotelefone.read(numero);
		if (t!=null){
			DAO.rollback();
			throw new Exception("numero ja cadastrado:" + numero);
		}
		p.adicionar(new Telefone(numero));
		daopessoa.update(p);
		DAO.commit();
		return p;
	}	

	public static Pessoa alterarPessoa(String nome, String novonome) throws Exception{
		DAO.begin();		
		Pessoa p = daopessoa.read(nome);	//usando  chave primaria
		if (p==null) {
			DAO.rollback();
			throw new Exception("nome inexistente:" + nome);
		}
		p.setNome(novonome); 			
		p=daopessoa.update(p);     	
		DAO.commit();
		return p;
	}

	public static Telefone alterarTelefone(String numero, String novonumero) throws Exception{
		DAO.begin();		
		Telefone t = daotelefone.read(numero);	
		if (t==null) {
			DAO.rollback();	
			throw new Exception("alterar telefone - numero inexistente:" + numero);
		}
		Telefone t2 = daotelefone.read(novonumero);	
		if (t2!=null) {
			DAO.rollback();	
			throw new Exception("alterar telefone - novo numero ja existe:" + novonumero);
		}
		t.setNumero(novonumero); 	//trocar		
		t=daotelefone.update(t);     	
		DAO.commit();	
		return t;
	}

	public static void excluirPessoa(String n) throws Exception {
		DAO.begin();
		Pessoa p = daopessoa.read(n);
		if (p==null) {
			DAO.rollback();	
			throw new Exception("nome inexistente:" + n);
		}
		daopessoa.delete(p);  //telefones removidos
		DAO.commit();
	}

	public static void excluirTelefone(String numero) throws Exception {
		DAO.begin();
		Telefone t = daotelefone.read(numero);
		if (t==null) {
			DAO.rollback();
			throw new Exception("numero inexistente:" + numero);
		}
		Pessoa p = t.getPessoa();
		p.remover(t);
		t.setPessoa(null);

		daopessoa.update(p);
		//daotelefone.delete(t);	//orphanRemoval=true
		DAO.commit();
	}

	public static void excluirTelefonesFixosPessoa(String nome) throws Exception {
		DAO.begin();
		Pessoa p = daopessoa.read(nome);
		if (p==null) {
			DAO.rollback();	
			throw new Exception("nome inexistente:" + nome);
		}

		Iterator<Telefone> iterator = p.getTelefones().iterator();
		while(iterator.hasNext()){
			Telefone t = (Telefone) iterator.next();
			if (! t.ehCelular()) {
				t.setPessoa(null);		//desliga o telefone
				iterator.remove();			
			}
		}
		daopessoa.update(p);
		DAO.commit();
	}

	public static List<Pessoa> listarPessoas(){
		return daopessoa.readAll();
	}
	
	public static List<Telefone> listarTelefones(){
		return daotelefone.readAll();
	}
	
//	public static String listarPessoas(){
//		List<Pessoa> pessoas = daopessoa.readAll();
//		
//		String texto="-----------listagem de Pessoas-----------\n";
//		for (Pessoa pe : pessoas) {
//			texto += pe +"\n";
//		}
//		return texto;
//	}

//	public static String listarTelefones() { 	
//		List<Telefone> aux = daotelefone.readAll();
//		String texto="-----------listagem de Telefones---------\n";
//		for(Telefone t: aux) {
//			texto += "\n" + t; 
//		}
//		return texto;
//	}


	/**********************************************************
	 * 
	 * CONSULTAS IMPLEMENTADAS NOS DAO
	 * 
	 **********************************************************/

	public static List<Pessoa> consultarPessoas(String caracteres) {
		return daopessoa.consultarPessoas(caracteres);
	}
	
	public static List<Telefone> consultarTelefones(String digitos) {
		return daotelefone.consultarTelefones(digitos);
	}

	public static List<Pessoa> consultarPessoasNTelefones(int n) {
		return daopessoa.consultarPessoasNTelefones(n);
	}
	
	public static boolean temTelefoneFixo(String nome) {
		return daopessoa.temTelefoneFixo(nome);
	}

	public static boolean temTelefoneCelular(String nome) {
		return daopessoa.temTelefoneCelular(nome);
	}
	
	

}
