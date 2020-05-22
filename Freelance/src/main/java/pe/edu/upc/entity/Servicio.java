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

import com.google.gson.Gson;

@Entity
@Table(name="f_services")
public class Servicio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idservicio;
	
	@ManyToOne
	@JoinColumn(name="id", nullable = false)
	private PerfilFreelance owner;
	
	@Column(name="name", length = 80, nullable = false)
	private String name;
	
	@Column(name="sdesc", length = 200, nullable = false)
	private String desc;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

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
		
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
