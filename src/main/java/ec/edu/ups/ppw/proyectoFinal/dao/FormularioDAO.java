package ec.edu.ups.ppw.proyectoFinal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw.proyectoFinal.model.Formulario;



@Stateless
public class FormularioDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Formulario formulario) {
		em.persist(formulario);
	}
	
	public void update(Formulario formulario) {
		em.merge(formulario);
	}
	
	public Formulario read(String cedula) {
		Formulario p = em.find(Formulario.class, cedula);
		return p;
	}
	
	public void delite(String formulario) {
		Formulario p = em.find(Formulario.class, formulario);
		em.remove(p);
	}
	
	public List<Formulario> getList(){
		String jpql = "SELECT p FROM Formulario p";
		
		Query q = em.createQuery(jpql, Formulario.class);
		
		return q.getResultList();
	}
}

