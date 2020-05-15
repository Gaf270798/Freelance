package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.UsuarioRol;
import pe.edu.upc.serviceinterface.IRolService;

@Named
@ViewScoped
public class MasterController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private IRolService rS;
	
	public void verificarSesion() {
		try {
			System.out.println("verificando sesión");
			
			FacesContext context = FacesContext.getCurrentInstance();
			Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("user");
			
			if(us == null) {

				System.out.println("sesión no iniciada");
				context.getExternalContext().redirect("login.xhtml");
			}else {
				//verificacion de roles
				System.out.println("verficiando permisos");
				String viewId = context.getViewRoot().getViewId();
				boolean rpta = this.verificarMenu(viewId);
				
				if(!rpta) {
					System.out.println("permisos no validos");
					context.getExternalContext().redirect("./403.xhtml");
				}
			}			
		} catch (Exception e) {

		}
	}
	
	public boolean verificarMenu(String viewId) throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("user");

		List<UsuarioRol> roles = rS.findUserRolesByUser(us);

		String rol = "";
		switch (viewId) {
		case "/panel.xhtml":
			rol = "ADMIN,USER";
			break;
		default:
			rol = "ADMIN,USER";
			break;
		}

		String arreglo[] = rol.split(",");

		int[] iarr = { 0 };
		roles.forEach(r -> {
			for (String x : arreglo) {
				if (r.getRol().getName().equals(x)) {
					iarr[0]++;
				}
			}
		});

		// System.out.println(iarr[0]);
		if (iarr[0] == 0) {
			return false;
		}
		return true;
	}
	
	public String cerrarSesion() {
		System.out.println("sesión cerrada");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return "login.xhtml";
	}
	public int getProfile() {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("user");
		
		return us.getId();
	}
	
}
