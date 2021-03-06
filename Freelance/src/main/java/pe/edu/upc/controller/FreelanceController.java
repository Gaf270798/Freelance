package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.entity.PerfilFreelance;
import pe.edu.upc.serviceinterface.IEspecialidadService;
import pe.edu.upc.serviceinterface.IRolService;
import pe.edu.upc.serviceinterface.IfreelanceService;

@Named
@SessionScoped
public class FreelanceController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IfreelanceService iservice;
	@Inject
	private IRolService rservice;
	@Inject
	private IEspecialidadService eservice;
	
	private boolean readonly;
	private PerfilFreelance f;

	private List<PerfilFreelance>listaFreelance;
	private List<Especialidad> listaTag;
	
	@PostConstruct
	public void init() {
		System.out.println("freelance init");
		
		this.listaFreelance = new ArrayList<PerfilFreelance>();
		this.f = new PerfilFreelance();
		listTags(f);
		this.listFreelance();
		this.readonly = false;
		//System.out.println(f.toString());
	}

	public void listFreelance() {
		try {
			listaFreelance = iservice.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void cleanFreelance() {
		this.init();
	}
	
	public String modFreelance(PerfilFreelance fa) {
		System.out.println(fa.toString());
		this.setF(fa);
		this.listaTag = new ArrayList<Especialidad>();
		listTags(fa);


		readonly = true;
		
		return "freelanceUpdate.xhtml";
	}

	private void listTags(PerfilFreelance fa) {
		this.listaTag = new ArrayList<Especialidad>();
		try {
			eservice.findEspByFreelance(fa).forEach(r ->{ this.listaTag.add(r.getTopic());});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void modify() {
		try {
			readonly = false;
			iservice.modify(f);
			cleanFreelance();
			listFreelance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int df) {
		System.out.println("intentar eliminar roles");
		try {
			rservice.deassignRolesToUser(df);
			System.out.println("roles eliminados");
		} catch (Exception e) {
			System.out.println("no es posible quitar roles");
			e.getMessage();
		}
		try {
			System.out.println("eliminar Freelance");
			iservice.delete(df);
		} catch (Exception e) {
			System.out.println("no es posible eliminar");
			e.getMessage();
		}
		
		this.listFreelance();
	}
	
	public void assignEsp(Especialidad esp) {
		System.out.println("called insert esp");
		List<Especialidad>templist = new ArrayList<Especialidad>();
		try {
			templist.add(esp);
			eservice.assignEspToFreelance(f, templist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		listTags(f);
	}
	public void deassignEsp(Especialidad esp) {
		System.out.println("called remove esp");
		eservice.deassignEsp(f, esp);
		listTags(f);
	}
	public void checkEsp() {
		
	}
	
	//getters y setters
 	public PerfilFreelance getF() {
		return f;
	}
	public void setF(PerfilFreelance f) {
		System.out.print(f.toString());
		this.f = f;
	}
	public List<PerfilFreelance> getListaFreelance() {
		return listaFreelance;
	}
	public boolean isReadonly() {
		return readonly;
	}
	public List<Especialidad> getListaTag() {
		return listaTag;
	}
	public void setListaTag(List<Especialidad> listaTag) {
		this.listaTag = listaTag;
	}
	
}
