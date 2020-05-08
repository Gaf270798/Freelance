package pe.edu.upc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Freelancers")
public class Freelance implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	private int cumplimiento;
	@Column(name = "correo", nullable = false, length = 50)
	private String correo;
	@Column(name = "dsc", nullable = false, length = 50)
	private String dsc;
	
	public Freelance() {
		super();
		
	}
//comentario
	public Freelance(int id, String nombre, int cumplimiento, String correo, String dsc) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cumplimiento = cumplimiento;
		this.correo = correo;
		this.dsc = dsc;
	}

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

	public int getCumplimiento() {
		return cumplimiento;
	}

	public void setCumplimiento(int cumplimiento) {
		this.cumplimiento = cumplimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
