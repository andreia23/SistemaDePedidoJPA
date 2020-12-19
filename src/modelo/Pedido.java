package modelo;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)	//Obrigatorio para mongodb (heran�a)
@NoSql(dataFormat=DataFormatType.MAPPED)     //obrigatorio mongodb
public class Pedido {

	@Id
	@GeneratedValue
	@Column(name="_id")		//nome obrigatorio no mongodb
	private String codigoPedido;
	private Double valorPedido;

	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Endereco enderecoEntrega;

	@OneToMany(	mappedBy="pedido", 
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, 
			orphanRemoval=true,    //mongodb nao utiliza este parametro
			fetch=FetchType.LAZY)
	private ArrayList<Produto> produtos = new ArrayList<Produto>();

	public Pedido() {

	}

	public Pedido(Double valorPedido) {
		super();
		this.valorPedido = valorPedido;
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(String codigoPedido) {
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
