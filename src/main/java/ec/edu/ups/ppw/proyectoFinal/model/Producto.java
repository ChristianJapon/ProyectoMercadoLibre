package ec.edu.ups.ppw.proyectoFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_Producto")
public class Producto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//No solo las entidades de las tablas pueden tomar nombres diferentes
	//tambien se puede utilizar para dar nombre a sus atributos
	//@Column nos permite realizar dicha azaña
	
	@Id
	@Column(name="pro_codigo")
	private String codigo;
	
	@Column(name="pro_nombre")
	private String nombre;
	
	@Column(name="pro_precio")
	private String precio;
	
	@Column(name="pro_descripcion")
	private String descripcion;
	
	@Column(name="pro_cantidad")
	private String cantidad;
	
	@Column(name="pro_photo")
	private String photo;

	private String cedula;
	
	private boolean estado;
	
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
		
}
