package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name="f_services")
public class Servicio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idservicio;
	
	@ManyToOne
	@JoinColumn(name="freelance_id", nullable = false)
	private PerfilFreelance owner;
	
	@Column(name="is_active")
	private boolean active;

	public Servicio() {
		super();
	}

	public Servicio(int idservicio, PerfilFreelance owner, boolean active) {
		super();
		this.idservicio = idservicio;
		this.owner = owner;
		this.active = active;
	}

	public int getIdservicio() {
		return idservicio;
	}

	public void setIdservicio(int idservicio) {
		this.idservicio = idservicio;
	}

	public PerfilFreelance getOwner() {
		return owner;
	}

	public void setOwner(PerfilFreelance owner) {
		this.owner = owner;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
		
}
