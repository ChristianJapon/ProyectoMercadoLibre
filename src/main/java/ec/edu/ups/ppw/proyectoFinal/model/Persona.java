package ec.edu.ups.ppw.proyectoFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Propiedad entity, permite dar una entidad a la clase
//caso de que no se use el @Table(name""), la entidad tomara el valor de lc clase

@Entity
@Table(name="TBL_PERSONA")
public class Persona  implements Serializable{
   	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="per_cedula")
	private String cedula;
	
	@Column(name="per_nombre")
	private String nombre;

	@Column(name="per_celular")
	private String celular;
	
	@Column(name="per_correo")
	private String correo;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
		

}
