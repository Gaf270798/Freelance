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
	private String ErrorAsociado;
	
	@PostConstruct
	public void init() {
		System.out.println("login init");
		this.user = new Usuario();
		this.ErrorAsociado = "";
	}

	public String authentication() {
		String redirect = null;

		try {
			System.out.println("1");
			Optional<Usuario> userFound = this.uS.authentication(user);
			System.out.println("2");
			
			if (userFound.isPresent() && userFound.get().getState().equalsIgnoreCase("A")) {
				ErrorAsociado = "";
				// Almacenar en la sesión de JSF
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userFound.get());
				redirect = "/panel?faces-redirect=true";
			} else {
				ErrorAsociado = "Contraseña incorrecta";
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
			}
		} catch (Exception e) {
			ErrorAsociado = "Usuario no existente";
			System.out.println("failed to login");
		}

		return redirect;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public String getErrorAsociado() {
		return ErrorAsociado;
	}

	public void setErrorAsociado(String errorAsociado) {
		ErrorAsociado = errorAsociado;
	}
}
