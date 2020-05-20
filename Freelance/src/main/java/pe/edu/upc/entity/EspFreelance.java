package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;

@Entity
@Table(
		name = "topic_freelance",
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"freelance_id", "topic_id"})
	)
public class EspFreelance implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "freelance_id", nullable = false)
	private PerfilFreelance freelance;

	@ManyToOne
	@JoinColumn(name = "topic_id", nullable = false)
	private Especialidad topic;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PerfilFreelance getFreelance() {
		return freelance;
	}

	public void setFreelance(PerfilFreelance freelance) {
		this.freelance = freelance;
	}

	public Especialidad getTopic() {
		return topic;
	}

	public void setTopic(Especialidad topic) {
		this.topic = topic;
	}
	
	
}
