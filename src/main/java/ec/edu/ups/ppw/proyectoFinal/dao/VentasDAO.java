package ec.edu.ups.ppw.proyectoFinal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw.proyectoFinal.model.Venta;



@Stateless
public class VentasDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Venta venta) {
		em.persist(venta);
	}
	
	public void update(Venta venta) {
		em.merge(venta);
	}
	
	public Venta read(int codigo) {
		Venta p = em.find(Venta.class, codigo);
		return p;
	}
	
	public void delite(int venta) {
		Venta p = em.find(Venta.class, venta);
		em.remove(p);
	}
	
	public List<Venta> getList(){
		String jpql = "SELECT p FROM Venta p";
		
		Query q = em.createQuery(jpql, Venta.class);
		
		return q.getResultList();
	}
	
}
