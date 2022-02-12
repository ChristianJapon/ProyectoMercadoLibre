package ec.edu.ups.ppw.proyectoFinal.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw.proyectoFinal.business.GestionFacturasON;
import ec.edu.ups.ppw.proyectoFinal.model.Persona;


@Named
@RequestScoped
public class ClientesBean {
	
	@Inject
	private GestionFacturasON facOn;
	
	private String cedula;
	private String nombre;
	private String celular;
	private String correo;
	
	private Persona newCliente= new Persona();
	
	private String filtro;
	
	private List<Persona>clientes;
	
	@PostConstruct
	public void init() {
		clientes=facOn.getClientes();
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		System.out.println("set2 "+ cedula );
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		System.out.println("set2 "+nombre);
		this.nombre = nombre;
	}
		
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Persona getNewCliente() {
		return newCliente;
	}

	public void setNewCliente(Persona newCliente) {
		this.newCliente = newCliente;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Persona> getClientes() {
		return clientes;
	}

	public void setClientes(List<Persona> clientes) {
		this.clientes = clientes;
	}

	public String guardar() {
		
		System.out.println(this.cedula+"  "+this.nombre+" "+this.correo);
		
		Persona p= new Persona();
		
		p.setCedula(this.cedula);
		p.setNombre(this.nombre);
		p.setCelular(this.celular);
		p.setCorreo(this.correo);
				
		facOn.guardarPersona(p);
		
		this.init();
		return null;// "listado-clientes";
	}
		
	public String buscarCedula() {
		clientes=facOn.getListPorCedula(this.filtro);
		return null;
	}
	
	public String guardarCambios() {
	Persona p= new Persona();
		
		p.setCedula(this.cedula);
		p.setNombre(this.nombre);
		p.setCelular(this.celular);
		p.setCorreo(this.correo);
				
		facOn.guardarCambios(p);;
		
		this.init();
		
		
		return null;
		
	}
	
	
	
	public String editarCliente(String cedula) {
		return "editar-persona-admin?faces-redirect=true&id="+cedula;
	}
	public void loadDatos() {
		
		if(cedula==null)
			return;
		
		if(cedula!=null)
			return;
		
		/*Persona p = facOn.getCLiente(cedula);
		cedula=p.getCedula();
		nombre=p.getNombre();
		direccion=p.getDireccion(); 
		
		newCliente=p*/
		
				}
	
	

}
