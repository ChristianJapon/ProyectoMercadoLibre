package ec.edu.ups.ppw.proyectoFinal.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw.proyectoFinal.business.GestionFacturasON;
import ec.edu.ups.ppw.proyectoFinal.business.GestionProductosON;
import ec.edu.ups.ppw.proyectoFinal.business.GestionVentasON;
import ec.edu.ups.ppw.proyectoFinal.model.Persona;
import ec.edu.ups.ppw.proyectoFinal.model.Producto;
import ec.edu.ups.ppw.proyectoFinal.model.Venta;

@Named
@RequestScoped
public class ventasBean {

	@Inject
	private GestionVentasON venON;
	
	@Inject 
	private GestionProductosON proON;
	
	@Inject
	private GestionFacturasON facON;
	
	private List<Venta> lista = new ArrayList<Venta>();
	
	private String filtro;
	
	@PostConstruct
	public void init() {
		lista = venON.listar();
	}

	public List<Venta> getLista() {
		return lista;
	}

	public void setLista(List<Venta> lista) {
		this.lista = lista;
	}
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String buscarNombreProducto(String codigo) {
		Producto p = proON.getProducto(codigo);
		return p.getNombre();
	}
	
	public String buscarPrecioProducto(String codigo) {
		Producto p = proON.getProducto(codigo);
		return p.getPrecio();
	}
	
	public String buscarNombrePersona(String codigo) {
		Persona per = facON.getCLiente(codigo);
		return per.getNombre();
	}
	
	public void buscarPorVendedor() {
		if(!filtro.equals("")) {
			lista = venON.listarPorCedulaVendedor(this.filtro);
		}else {
			lista = venON.listar();
		}	
	}
	
	public void buscarPorComprador() {
		lista = venON.listarPorCedulaComprador(this.filtro);
		
	}
	
	public double ingresos(String cedula) {
		double ingresos=0;
		
		for (Venta venta : lista) {
			if(venta.getVendedor().equals(cedula)) {
				ingresos=ingresos+Double.parseDouble(venta.getTotal());
				System.out.println(cedula + " "+ingresos);
			}
		}
		
		return ingresos;
	}
	
	public double egresos(String cedula) {
		double egresos=0;
		
		for (Venta venta : lista) {
			if(venta.getComprador().equals(cedula)) {
				egresos=egresos+Double.parseDouble(venta.getTotal());
			}
		}
		
		return egresos;
	}
}
