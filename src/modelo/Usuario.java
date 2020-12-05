package modelo;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoUsuario;
	private String nomeUsuario;
	private String cpf;
	private String fone;
	private String email;
	private String senha;
	
	@ManyToOne
	private Endereco endereco;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, // default � false
			fetch = FetchType.EAGER)
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

	public Usuario() {

	}

	public Usuario(String nomeUsuario, String cpf, String fone, String email, String senha) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.cpf = cpf;
		this.fone = fone;
		this.email = email;
		this.senha = senha;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void adicionar(Pedido p) {
		p.setUsuario(this);
		this.pedidos.add(p);
	}

	public void remover(Pedido p) {
		p.setUsuario(null);
		this.pedidos.remove(p);
	}

	public Pedido localizar(Integer num) {
		for (Pedido p : pedidos) {
			if (p.getCodigoPedido().equals(num))
				return p;
		}
		return null;
	}

	@Override
	public String toString() {
		String classe = getClass().getSimpleName() + ":";
		String texto = String.format("%5s", classe) + " nome = " + String.format("%5s", nomeUsuario) + ", cpf = "
				+ String.format("%5s", cpf) + ", email = " + String.format("%5s", email) + ", senha = "
				+ String.format("%5s", senha);

		texto += ", pedidos:";
		for (Pedido p : pedidos)
			texto += p.getCodigoPedido() + ", ";

		return texto;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoUsuario;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
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
		Usuario other = (Usuario) obj;
		if (codigoUsuario != other.codigoUsuario)
			return false;
		if (cpf == null) {
			if (other.cpf != null)	
				return false;
		} 
		else 
			if (!cpf.equals(other.cpf))	
				return false;

		
		return true;
	}

}
