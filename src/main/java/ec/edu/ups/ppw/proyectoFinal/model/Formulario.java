package ec.edu.ups.ppw.proyectoFinal.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Formulario {

	@Id
	private int id;
	private String nombre;
	private String correo;
	private String texto;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Formulario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", texto=" + texto + "]";
	}
	
	
}
