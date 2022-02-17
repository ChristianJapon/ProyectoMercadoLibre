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
	
	//llamando a la clase DAO, nos permite 
	//utilizar los metodos que se encuentran ahui
	
	public void guardarPersona(Persona pe) {
		
		Persona p  = daoPersona.read(pe.getCedula());
		if(p==null) 
			daoPersona.insert(pe);
		}
	
	
	public Persona buscarUsuario(String cedula, String correo) {
	Persona p = daoPersona.read(cedula);
		//condicional para devolcer un objeto persona
		//siempre y cunedo los datos correspondan
	
		if(p != null & p.getCorreo().equals(correo)) {
			return p;	
		}
				
		return null;
	}

	//El siguiente metodo permite al administrador
	//realizar cambios en la persona creada
	//a su vez en un futuro esto podria ayudar a que el mismo usuario
	//pueda modificar sus datos
	public void guardarCambios(Persona pe) {
		
		Persona p  = daoPersona.read(pe.getCedula());
		if(p==null) 
			daoPersona.insert(pe);
		else
			daoPersona.update(pe);
	}

	public List<Persona> getClientes() {
		return daoPersona.getList();
	}

	public List<Persona> getListPorCedula(String filtro) {
		filtro="%" + filtro + "%";
		return daoPersona.getListxCedula(filtro);
	}
	
	public Persona getCLiente(String cedula) {
		Persona p=daoPersona.read(cedula);
		return p;
		
	}
	
		

}
