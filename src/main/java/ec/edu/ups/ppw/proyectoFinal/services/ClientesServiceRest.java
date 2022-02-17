package ec.edu.ups.ppw.proyectoFinal.services;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import ec.edu.ups.ppw.proyectoFinal.business.GestionFacturasON;
import ec.edu.ups.ppw.proyectoFinal.business.GestionFormularioON;
import ec.edu.ups.ppw.proyectoFinal.business.GestionVentasON;
import ec.edu.ups.ppw.proyectoFinal.model.Formulario;
import ec.edu.ups.ppw.proyectoFinal.model.Persona;
import ec.edu.ups.ppw.proyectoFinal.model.Venta;




@Path("clientes")
public class ClientesServiceRest {
	
	@Inject
	private GestionFacturasON facON;
	
	@Inject
	private GestionFormularioON forON;
	
	@Inject
	private GestionVentasON venON;
	
	
	//El método POST introduce los parámetros en la solicitud para el servidor.
	//Por ello, no quedan visibles para el usuario. Además, la capacidad del método POST es ilimitada.
	
	//El formato JSON se utiliza para estructurar datos en forma de texto y
	//permite el intercambio de información entre aplicaciones de manera sencilla, liviana y rápida.
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Respuesta crearCliente(Persona persona) {
		//Instrucciones de la funcionalidad
		Respuesta res= new Respuesta();
		try {
			facON.guardarPersona(persona);
			res.setCodigo(1);
			res.setMensaje("Guardado Correctamente");
			return res;
		}catch(Exception e) {
			res.setCodigo(99);
			res.setMensaje("Error al guardar");
			return res;
		}
	
	}
	
	//NOs permite como funcion principal el poder obtener los datos guardados posteriromente
	//Es decir, funciona como un listar
	
	@GET
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Persona login(@QueryParam("correo")String correo,@QueryParam("cedula")String cedula) {
		//Instrucciones de la funcionalidad
		Persona p1 = new Persona();
		Respuesta res= new Respuesta();
		
		try {
			p1 =facON.buscarUsuario(cedula, correo);
			res.setCodigo(1);
			res.setMensaje("Guardado Correctamente");
			return p1;
		}catch(Exception e) {
			res.setCodigo(99);
			res.setMensaje("Error al guardar");
			return null;
		}
	
	}
	
	
	@POST
	@Path("venta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Respuesta crearVenta(Venta venta) {
		//Instrucciones de la funcionalidad
		Respuesta res= new Respuesta();
		try {
			venON.guardarVenta(venta);
			res.setCodigo(3);
			res.setMensaje("Guardado Correctamente");
			return res;
		}catch(Exception e) {
			res.setCodigo(103);
			res.setMensaje("Error al guardar");
			return res;
		}
	
	}
	
	@GET
	@Path("ventaL")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Venta> getVenta(){
		
		List<Venta> ventas = venON.listar();
		return ventas;
		
	}
	
	
	
	@POST
	@Path("autorizar")
	public String autorizar(String xmlFactura) {
		//Instrucciones de autorizacion
		return null;
	}
	
	/*@POST
	@Path("transferir")
	public String transferir(String numCuentaOrigen, String cedulaOrigen,
			double monto, String numCuenta, String cedulaDestino, String bancoDestino) {
		
		//Instrucciones de transferencia entre cuentas
		return null;
	}
	*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> getClientes(){
		List<Persona> clientes = facON.getClientes();
		return clientes;
	}
	
	@GET
	@Path("formularioL")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Formulario> getFormularios(){
		
		List<Formulario> formularios = forON.listar();
		return formularios;
		
	}

	@POST
	@Path("formulario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Respuesta crearFormulario(Formulario formulario) {
		
		Respuesta res = new Respuesta();
		
		try{
			forON.guardarFormulario(formulario);
			res.setCodigo(1);
			res.setMensaje("Bien");
		}catch (Exception e) {
			res.setCodigo(99);
			res.setMensaje("Error al guardar");
		}
		return null;
	}
	
	
}
