package ec.edu.ups.ppw.proyectoFinal.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw.proyectoFinal.business.GestionProductosON;
import ec.edu.ups.ppw.proyectoFinal.model.Producto;

@Named
@RequestScoped
public class ProductosBean {

	@Inject
	private GestionProductosON prodOn;

	private String codigo;
	private String nombre;
	private String precio;
	private String descripcion;
	private String cantidad;
	private String photo;

	private Producto newProducto = new Producto();

	private String filtro;

	private List<Producto> productos;

	@PostConstruct
	public void init() {
		productos = prodOn.getProductos();
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

	public Producto getNewProducto() {
		return newProducto;
	}

	public void setNewProducto(Producto newProducto) {
		this.newProducto = newProducto;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public String guardar() {
		System.out.println(this.codigo+"  "+this.nombre+" "+this.precio);
		Producto pr = new Producto();
		pr.setCodigo(this.codigo);
		pr.setNombre(this.nombre);
		pr.setPrecio(this.precio);
		pr.setDescripcion(this.descripcion);
		pr.setCantidad(this.cantidad);
		//pr.setImagenPro(this.imagenProducto);
		
		prodOn.guardarProducto(pr);
	
		this.init();
		
		return   null;// "listado-productos"; 
	}

}
