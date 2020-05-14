package pe.edu.upc.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("C")
@Table(name = "profiles_cliente")
public class PerfilCliente extends Perfil {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Cliente:{" + super.toString() + "}";	
	}
}
