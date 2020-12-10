package modelo;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Endereco20182370030")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codEndereco;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;

	@OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL, orphanRemoval = true, // default � false
			fetch = FetchType.EAGER)
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	@OneToMany(mappedBy = "enderecoEntrega", cascade = CascadeType.ALL, orphanRemoval = true, // default � false
			fetch = FetchType.EAGER)
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

	public Endereco() {
		super();
	}

	public Endereco(String cidade, String bairro, String rua, String numero) {
		super();
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
	}

	public Integer getCodEndereco() {
		return codEndereco;
	}

	public void setCodEndereco(Integer codEndereco) {
		this.codEndereco = codEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setCodEndereco(int codEndereco) {
		this.codEndereco = codEndereco;
	}
	
	public void adicionarPedido(Pedido pedido) {
		pedido.setEnderecoEntrega(this);
		this.pedidos.add(pedido);
	}
	
	public void adicionarUsuario(Usuario usuario) {
		usuario.setEndereco(this);
		this.usuarios.add(usuario);
	}

	@Override
	public String toString() {
		String classe = getClass().getSimpleName() + ":";
		String texto = String.format("%5s", classe) + ", Cidade = " + String.format("%5s", cidade) + ", Bairro = "
				+ String.format("%5s", bairro) + ", Rua = " + String.format("%5s", rua) + ", N� = "
				+ String.format("%2s", numero);
//		
//			texto += ", pedidos:";
//			for(Pedido p : pedidos)
//				texto+= p.getCodigoPedido() + ", ";

		return texto;
	}

}
