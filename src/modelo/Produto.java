package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

import daojpa.DAOProduto;


@Entity
@EntityListeners( DAOProduto.class )  						//Exemplo de trigger
@NoSql(dataFormat=DataFormatType.MAPPED)     //obrigatorio mongodb
public class Produto {

	@Id
	@GeneratedValue
	@Column(name="_id")		//nome obrigatorio no mongodb
	private String idProduto;
	private int quantidadeProduto;
	private String nomeProduto;
	private Double valorProduto;
    @Version
	private int versao;

	@ManyToOne
	private Pedido pedido;

	public Produto() {

	}

	public Produto(Integer quantidadeProduto, String nomeProduto, Double valorProduto) {
		super();
		this.quantidadeProduto = quantidadeProduto;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public Produto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", quantidadeProduto=" + quantidadeProduto + ", nomeProduto="
				+ nomeProduto + ", valorProduto=" + valorProduto + ", versão=" + versao + ", pedido=" + pedido + "]";
	}

//	@Override
//	public String toString() {
//		String classe = getClass().getSimpleName() + ":";
//		String texto = String.format("%5s", classe) + "  NomeProduto = " + nomeProduto;
//
//		return texto;
//
//	}

}
