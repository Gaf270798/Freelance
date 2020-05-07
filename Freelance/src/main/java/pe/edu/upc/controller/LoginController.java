package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.serviceimpl.UsuarioServiceImpl;

@Named
@ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioServiceImpl uS;

	private Usuario user;

	@PostConstruct
	public void init() {
		System.out.println("login init");
		this.user = new Usuario();
	}

	public String authentication() {
		String redirect = null;

		try {
			Optional<Usuario> userFound = this.uS.authentication(user);

			if (userFound.isPresent() && userFound.get().getState().equalsIgnoreCase("A")) {
				// Almacenar en la sesión de JSF
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userFound.get());
				redirect = "/panel?faces-redirect=true";
			} else {
				System.out.println("usuario no existente o credenciales erroneas");
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
			}
		} catch (Exception e) {
			System.out.println("failed to login");
			//e.printStackTrace();
		}

		return redirect;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}
