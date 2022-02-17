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
	
	//Metodo el cual permite que elo sistema de ventas tenga su propio registro
	//el cual tambien sera guardado, y permitira ver un historial del mismo
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
	
	public List<Venta> listarPorCedulaVendedor(String filtro){
		String f = "%"+filtro+"%";
		return ventaDAO.getListVendedor(f);
	}
	
	public List<Venta> listarPorCedulaComprador(String filtro){
		String f = "%"+filtro+"%";
		return ventaDAO.getListComprador(f);
	}
	
	
}
