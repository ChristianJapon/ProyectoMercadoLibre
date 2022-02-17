package ec.edu.ups.ppw.proyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw.proyectoFinal.dao.PersonaDAO;
import ec.edu.ups.ppw.proyectoFinal.dao.ProductoDAO;
import ec.edu.ups.ppw.proyectoFinal.model.Persona;
import ec.edu.ups.ppw.proyectoFinal.model.Producto;

@Stateless
public class GestionProductosON {

	@Inject
	private ProductoDAO daoProducto;
	private PersonaDAO daoPersona;
	
	//Metodo que permite guardar y editar el producto
	//el cual tiene la facilidad el vendedor
	public void guardarProducto(Producto pr) {
		
		Producto pro=daoProducto.read(pr.getCodigo());
		if(pro==null) 
			daoProducto.insert(pr);
		else
			daoProducto.update(pr);		
	}
	
	//asi como puede editar el producto, tambien puede dar de baja
	//a los productos que ya no tengan o que desee ya no vender mas
	public void eliminarProducto(Producto pr) {
		Producto pro=daoProducto.read(pr.getCodigo());
		if(pro==null)
			daoProducto.insert(pr);
		else
			daoProducto.delete(pr);
			
	}
	
	
	public List<Producto> getProductos() {
		return daoProducto.getList();
	}

	public List<Producto> getListPorNombre(String filtro) {
		filtro="%" + filtro + "%";
		return daoProducto.getListXNombre(filtro);
	}
	
	public Producto getProducto(String codigo) {
		Producto pr=daoProducto.read(codigo);
		return pr;
		
	}
	public List<Persona> getListPorCedula(String filtro) {
		filtro="%" + filtro + "%";
		return daoPersona.getListxCedula(filtro);
	}
	
}
