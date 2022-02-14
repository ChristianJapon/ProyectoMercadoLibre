package ec.edu.ups.ppw.proyectoFinal.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional.TxType;

import ec.edu.ups.ppw.proyectoFinal.business.GestionFormularioON;
import ec.edu.ups.ppw.proyectoFinal.model.Formulario;





@Named
@RequestScoped
public class FormularioBeans {

	@Inject 
	private GestionFormularioON gfON;
	
	private String nombre;
	private String correo;
	private String texto;
	
	private List<Formulario> formularios = new ArrayList<Formulario>();
	
	private Formulario formulario;

	@PostConstruct
	public void init() {
		formularios = gfON.listar();
	}
	
	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Formulario> getFormularios() {
		return formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}
	
	public void guardar() {
		formulario = new Formulario();
		formulario.setCorreo(correo);
		formulario.setNombre(nombre);
		formulario.setTexto(texto);
		gfON.guardarFormulario(formulario);
		mensaje("Formulario", "Enviado Correctamente");
		System.out.println(nombre);
		System.out.println(correo);
		System.out.println(texto);
		this.init();
		correo="";
		texto="";
		nombre="";
		
		
	}
	
	public void mensaje(String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
	}
	
	
}
