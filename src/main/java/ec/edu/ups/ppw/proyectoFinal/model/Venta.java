package ec.edu.ups.ppw.proyectoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Venta {

	@Id
	@Column(name="ven_codigo")
	private int codigo;
	
	@Column(name="ven_codigoProducto")
	private String codigoProducto;
	
	@Column(name="ven_cantidad")
	private String cantidad;
	
	@Column(name="ven_total")
	private String total;
	
	@Column(name="ven_vendedor")
	private String vendedor;
	
	@Column(name="ven_comprador")
	private String comprador;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getComprador() {
		return comprador;
	}
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Venta [codigo=" + codigo + ", codigoProducto=" + codigoProducto + ", vendedor=" + vendedor
				+ ", comprador=" + comprador + ", cantidad=" + cantidad + ", total=" + total + "]";
	}
	
	
}
