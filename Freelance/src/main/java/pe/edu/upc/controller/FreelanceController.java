package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.PerfilFreelance;
import pe.edu.upc.serviceinterface.IRolService;
import pe.edu.upc.serviceinterface.IfreelanceService;

@Named
@RequestScoped
public class FreelanceController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IfreelanceService iservice;
	@Inject
	private IRolService rservice;
	
	private boolean readonly;
	private PerfilFreelance f;

	List<PerfilFreelance>listaFreelance;

	@PostConstruct
	public void init() {
		System.out.println("freelance init");
		this.listaFreelance = new ArrayList<PerfilFreelance>();
		this.f = new PerfilFreelance();
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
		readonly = true;
		
		return "freelanceUpdate.xhtml";
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
	
	
}
