package ec.edu.ups.ppw.proyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


//import ec.edu.ups.ppw.demoppw59.model.Factura;

//import ec.edu.ups.ppw.demoppw59.model.Producto;
import ec.edu.ups.ppw.proyectoFinal.dao.PersonaDAO;
import ec.edu.ups.ppw.proyectoFinal.model.Persona;

@Stateless
public class GestionFacturasON {

	@Inject
	private PersonaDAO daoPersona;
	
	
	public void guardarPersona(Persona pe) {
		
		Persona p  = daoPersona.read(pe.getCedula());
		if(p==null) 
			daoPersona.insert(pe);
		else
			daoPersona.update(pe);
	}

	public List<Persona> getClientes() {
		return daoPersona.getList();
	}

	public List<Persona> getListPorNombre(String filtro) {
		filtro="%" + filtro + "%";
		return daoPersona.getListXNombre(filtro);
	}
	
	public Persona getCLiente(String cedula) {
		Persona p=daoPersona.read(cedula);
		return p;
		
	}
	/*
	//******PRODUCTO
	
	public void guardarProducto(Producto pro) {
		
		Producto p=daoProducto.read(pro.getCodigo());
		if(p==null) 
			daoProducto.insert(pro);
		else
			daoProducto.update(pro);
	}

	public List<Producto> getProducto() {
		return daoProducto.getList();
	}

	
	public Persona getProducto(String codigo) {
		Persona p=daoPersona.read(codigo);
		return p;
		
	}
	public List<Producto> getListPorCodigo(String filtro) {
		filtro="v%" + filtro + "%";
		return daoProducto.getListxCodigo(filtro);
	}
	
	
	*/
	

}
