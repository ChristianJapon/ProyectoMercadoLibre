package ec.edu.ups.ppw.proyectoFinal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw.proyectoFinal.model.Persona;
import ec.edu.ups.ppw.proyectoFinal.model.Producto;

@Stateless
public class ProductoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Producto pr) {
		em.persist(pr);

	}

	public void update(Producto pr) {
		em.merge(pr);
	}

	public Producto read(String codigo) {
		Producto pr=em.find(Producto.class,codigo);
		return pr;

	}

	/*public void delete(String codigo) {
		Producto pr=em.find(Producto.class,codigo);
		em.remove(pr);

	}*/
	public void delete(Producto pr) {
		em.remove(pr);
	}
	
	public List<Producto>getList(){
		String jpql="SELECT pr FROM Producto pr";
		
		Query q =em.createQuery(jpql, Producto.class);
		
		return q.getResultList();
	}
	
	
	public List<Producto>getListXNombre(String filtro){
		String jpql="SELECT pr FROM Producto pr "
				+"WHERE nombre LIKE ?1";
		
		Query q =em.createQuery(jpql, Producto.class);
		q.setParameter(1, filtro );
		return q.getResultList();
	}
	public List<Persona>getListxCedula(String filtro){
		String jpql="SELECT p FROM Persona p "
				+"WHERE cedula LIKE ?1";
		
		Query q =em.createQuery(jpql, Persona.class);
		q.setParameter(1, filtro );
		return q.getResultList();
	}

}
