package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import pe.edu.upc.entity.Perfil;
import pe.edu.upc.entity.Rol;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.serviceinterface.IPerfilService;
import pe.edu.upc.serviceinterface.IRolService;

@Named
@ViewScoped
public class RegisterController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private IPerfilService cS;

	@Inject
	private IRolService rS;

	private Perfil perfil;
	private Usuario usuario;

	@PostConstruct
	public void init() {
		System.out.println("register init");
		this.perfil = new Perfil();
		this.usuario = new Usuario();
	}

	public String registerUser() {
		String redirect = null;
		try {
			String password = this.usuario.getPassword();
			String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
			
			this.usuario.setPassword(passwordHash);
			this.usuario.setState("A");
			
			this.perfil.setUser(usuario);
			this.usuario.setPerfil(perfil);
			
			this.cS.insert(perfil);

			List<Rol> roles = new ArrayList<Rol>();
			int TIPO_USUARIO = 1;
			Rol r = new Rol();
			r.setId(TIPO_USUARIO);
			roles.add(r);
			
			rS.assignRolesToUser(usuario, roles);
			
			redirect = "login?faces-redirect=true";
		} catch (Exception e) {
			System.out.println("fallo al registrar");
		}

		return redirect;
	}

	public Perfil getCustomer() {
		return perfil;
	}

	public void setCustomer(Perfil customer) {
		this.perfil = customer;
	}

	public Usuario getUser() {
		return usuario;
	}

	public void setUser(Usuario user) {
	}
}