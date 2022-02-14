package ec.edu.ups.ppw.proyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw.proyectoFinal.dao.ProductoDAO;
import ec.edu.ups.ppw.proyectoFinal.model.Producto;

@Stateless
public class GestionProductosON {

	@Inject
	private ProductoDAO daoProducto;
	
	public void guardarProducto(Producto pr) {
		
		Producto pro=daoProducto.read(pr.getCodigo());
		if(pro==null) 
			daoProducto.insert(pr);
		else
			daoProducto.update(pr);		
	}
	
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
	
}
