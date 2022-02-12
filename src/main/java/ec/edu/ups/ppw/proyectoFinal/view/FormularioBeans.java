package ec.edu.ups.ppw.proyectoFinal.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw.proyectoFinal.business.GestionFormularioON;
import ec.edu.ups.ppw.proyectoFinal.model.Formulario;



@Named
@RequestScoped
public class FormularioBeans {

	@Inject 
	private GestionFormularioON gfON;
	
	private Formulario formulario = new Formulario();

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}
	
	public void guardar() {
		
		gfON.guardarFormulario(formulario);
		formulario = new Formulario();
		
	}
	
	
}
