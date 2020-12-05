package modelo;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity 
public class Pessoa {

	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;

	// relacionamento 1:* Bidirecional
	@OneToMany(	mappedBy="pessoa",
			cascade=CascadeType.ALL, 	
			orphanRemoval=true,			//default é false
			fetch=FetchType.EAGER) 		//default é LAZY
	private List<Telefone> telefones = new ArrayList<>();

	//construtor vazio
	public Pessoa (){}

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void adicionar(Telefone t){
		telefones.add(t);
		t.setPessoa(this);
	}
	public void remover(Telefone t){
		telefones.remove(t);
		t.setPessoa(null);
	}
	public Telefone localizarTelefone(String numero){
		for(Telefone t : telefones)
			if(t.getNumero().equals(numero)) 
				return t;

		return null;			
	}

	public String toString() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String texto ;
		texto = id + ", nome=" + String.format("%10s", nome);  
		texto += ", telefones: ";
		for(Telefone t : telefones)
			texto+= t.getNumero() + ",";

		return texto;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefones == null) ? 0 : telefones.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)	
				return false;
		} 
		else 
			if (!nome.equals(other.nome))	
				return false;

		
		return true;
	}


}
