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
import javax.persistence.Table;

@Entity
@Table(name="Pedido20182370030")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoPedido;
	private Double valorPedido;

	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Endereco enderecoEntrega;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, // default � false
			fetch = FetchType.EAGER)
	private ArrayList<Produto> produtos = new ArrayList<Produto>();

	public Pedido() {

	}

	public Pedido(Double valorPedido) {
		super();
		this.valorPedido = valorPedido;
	}

	public Integer getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}

	public void adicionar(Produto p) {
		p.setPedido(this);
		this.produtos.add(p);
	}

	public void remover(Produto p) {
		p.setPedido(null);
		this.produtos.remove(p);
	}

	public Produto localizar(Integer num) {
		for (Produto p : produtos) {
			if (p.getIdProduto().equals(num))
				return p;
		}
		return null;
	}

	public ArrayList<Produto> getprodutos() {
		return produtos;
	}

	@Override
	public String toString() {
		String classe = getClass().getSimpleName() + ":";
		String texto = String.format("%5s", classe) + " CodigoPedido = " + codigoPedido + "  Usuario = "
				+ String.format("%5s", usuario.getCpf()) + "  " + enderecoEntrega;

		texto += ", Produtos:";
		for (Produto p : produtos)
			texto += p.getIdProduto()+ ", ";

		return texto;
	}

}
