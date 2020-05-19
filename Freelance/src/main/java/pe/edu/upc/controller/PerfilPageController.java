package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.gson.Gson;

import pe.edu.upc.entity.Perfil;
import pe.edu.upc.entity.PerfilCliente;
import pe.edu.upc.entity.PerfilFreelance;
import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.serviceinterface.IEspecialidadService;
import pe.edu.upc.serviceinterface.IPerfilService;

@Named
@RequestScoped
public class PerfilPageController implements Serializable {

	static final long serialVersionUID = 1L;

    @Inject
    private IPerfilService pS;
    @Inject
    private IEspecialidadService eS;
    
	private Perfil profile;
	/*private PerfilFreelance fprofile;
	private PerfilCliente cprofile;*/
	
	
	private char renderKey;
	private List<Especialidad> listaTag;
	
	@PostConstruct
	public void init() {
		System.out.println("perfil init");
		this.profile = new Perfil();
		this.listaTag = new ArrayList<Especialidad>();
		this.renderKey = 'n';
	}

	public String goToProfile(int profile_id) {
		System.out.println("Id del perfil: " + String.valueOf(profile_id));
		try {
			System.out.println("perfil consultado: " + String.valueOf(profile_id));
			this.profile = pS.getOne(profile_id).get();
			
			if (this.profile instanceof PerfilFreelance) {
				//this.fprofile = (PerfilFreelance)this.profile;
				//this.cprofile = new PerfilCliente();
				this.renderKey = 'f';
				eS.findEspByFreelance((PerfilFreelance)profile).forEach(r ->{ this.listaTag.add(r.getTopic());});
			}else 	if (this.profile instanceof PerfilCliente) {
				//this.fprofile = new PerfilFreelance();
				//this.cprofile = (PerfilCliente)this.profile;
				this.renderKey = 'c';
			}
			
		} catch (Exception e) {
		}
		return "perfil.xhtml";
	}

	public Perfil getProfile() {
		return profile;
	}

	public void setProfile(Perfil profile) {
		this.profile = profile;
	}
	public List<Especialidad> getListaTag() {
		return listaTag;
	}

	public void setListaTag(List<Especialidad> listaTag) {
		this.listaTag = listaTag;
	}

	public char getRenderKey() {
		return renderKey;
	}

	public String tagsJSON() {
		return new Gson().toJson(listaTag);
	}
}
