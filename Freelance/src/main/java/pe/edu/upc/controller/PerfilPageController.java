package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Perfil;
import pe.edu.upc.entity.PerfilCliente;
import pe.edu.upc.entity.PerfilFreelance;
import pe.edu.upc.serviceinterface.IPerfilService;

@Named
@RequestScoped
public class PerfilPageController implements Serializable {

	static final long serialVersionUID = 1L;

    @Inject
    private IPerfilService pS;
    
	private Perfil profile;
	private PerfilFreelance fprofile;
	private PerfilCliente cprofile;
	
	private Perfil nullprofile;
	
	@PostConstruct
	public void init() {
		System.out.println("perfil init");
		this.profile = new Perfil();
	}

	public String goToProfile(int profile_id) {
		System.out.println("Id del perfil: " + String.valueOf(profile_id));
		try {
			System.out.println("perfil consultado: " + String.valueOf(profile_id));
			this.profile = pS.getOne(profile_id).get();
			
			if (this.profile instanceof PerfilFreelance) {
				this.fprofile = (PerfilFreelance)this.profile;
				this.cprofile = new PerfilCliente();
			}else 	if (this.profile instanceof PerfilCliente) {
				this.fprofile = new PerfilFreelance();
				this.cprofile = (PerfilCliente)this.profile;
			}
			
		} catch (Exception e) {
		}
		return "perfil.xhtml";
	}

	public String Bottom() {
		System.out.println("profilecalled");
		if( profile instanceof PerfilFreelance){
			return "f";
		}else if( profile instanceof PerfilCliente){
			return "c";
		}else
			return "n";
	}
	
	public Perfil getProfile() {
		return profile;
	}

	public void setProfile(Perfil profile) {
		this.profile = profile;
	}

	
	public PerfilFreelance getFprofile() {
		return fprofile;
	}


	public PerfilCliente getCprofile() {
		return cprofile;
	}

	public Perfil getNullprofile() {
		return nullprofile;
	}
}
