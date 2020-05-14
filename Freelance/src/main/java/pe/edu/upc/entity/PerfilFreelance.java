package pe.edu.upc.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("F")
@Table(name = "profiles_freelance")
public class PerfilFreelance extends Perfil {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "cumpl", nullable = false)
	private int cumplimiento;

	@Override
	public String toString() {
		return "Freelance:{" + super.toString() + "}";
	}

	public int getCumplimiento() {
		return cumplimiento;
	}

	public void setCumplimiento(int cumplimiento) {
		this.cumplimiento = cumplimiento;
	}
}
