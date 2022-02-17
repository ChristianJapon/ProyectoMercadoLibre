package ec.edu.ups.ppw.proyectoFinal.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.ppw.proyectoFinal.business.GestionProductosON;

import ec.edu.ups.ppw.proyectoFinal.model.Producto;

@Path("productosRest")
public class ProductosServiceRest {
	
	@Inject
	private GestionProductosON proON;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Respuesta crearProductoRest(Producto producto) {
		
		Respuesta res= new Respuesta();
		try {
			proON.guardarProducto(producto);
			res.setCodigo(1);
			res.setMensaje("Guardado Correctamente");			
			return res;
		}catch(Exception e){
		
			res.setCodigo(99);
			res.setMensaje("Error al guardar");	
			return res;
		}
		
	}
	
	//Asi como el @POST Y @GET, tambien tenemos el @DELETE que bien se supone nos permite 
	//el transalado de datos para su eliminacion
	//existe tambien el de actualizar
	
	@DELETE
	@Path("elimanar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Respuesta eliminarProductoRest(Producto producto) {
		
		Respuesta res= new Respuesta();
		try {
			proON.eliminarProducto(producto);
			res.setCodigo(1);
			res.setMensaje("elimando Correctamente");			
			return res;
		}catch(Exception e){
		
			res.setCodigo(99);
			res.setMensaje("Error al elimar");	
			return res;
		}
		
	}
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> getProductos(){
		List<Producto> productos = proON.getProductos();
		return productos;
	}

}
