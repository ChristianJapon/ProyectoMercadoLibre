package ec.edu.ups.ppw.proyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw.proyectoFinal.dao.VentasDAO;
import ec.edu.ups.ppw.proyectoFinal.model.Venta;

@Stateless
public class GestionVentasON {

	@Inject
	private VentasDAO ventaDAO;
	
	public void guardarVenta(Venta venta) {
		venta.setCodigo(siguienteId());
		ventaDAO.insert(venta);
	}
	
	public int siguienteId() {
		
		List<Venta> lista = ventaDAO.getList();
		if(lista.isEmpty()) {
			return 0;
		}else {
		
			return lista.get(lista.size()-1).getCodigo()+1;	
		}
	}
	
	public List<Venta> listar(){
		
		return ventaDAO.getList();
	}
	
}
