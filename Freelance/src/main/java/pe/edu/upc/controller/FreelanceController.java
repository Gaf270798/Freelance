package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.PerfilFreelance;
import pe.edu.upc.serviceinterface.IPerfilService;
import pe.edu.upc.serviceinterface.IRolService;
import pe.edu.upc.serviceinterface.IfreelanceService;

@Named
@RequestScoped
public class FreelanceController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IfreelanceService iservice;
	@Inject
	private IPerfilService pservice;
	@Inject
	private IRolService rservice;
	
	private PerfilFreelance f;

	List<PerfilFreelance>listaFreelance;

	@PostConstruct
	public void init() {
		this.listaFreelance = new ArrayList<PerfilFreelance>();
		this.f = new PerfilFreelance();
		this.listFreelance();
	}
	
	public String newFreelance() {
		this.setF(new PerfilFreelance());
		return "freelance.xhtml";
	}
	
	public void insert() {
		try {
			iservice.insert(f);
			cleanFreelance();
			this.listFreelance();
		} catch (Exception e) {
			e.getMessage();
		}
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
	
	public void delete(int df) {
		System.out.println("intentar eliminar roles");
		try {
			rservice.deassignRolesToUser(df);
			System.out.println("roles eliminados");
		} catch (Exception e) {
			System.out.println("no es posible quitar roles");
			e.getMessage();
		}

		System.out.println("eliminar Freelance");
		iservice.delete(df);
		this.listFreelance();
	}
	
	public String modFreelance(PerfilFreelance fa) {
		
		System.out.println("update try");
		System.out.println(fa.toString());
		this.setF(fa);
		
		return "freelanceUpdate.xhtml";
	}
	
	public void modify() {
		try {
			iservice.modify(f);
			cleanFreelance();
			listFreelance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
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
	public void setListaFreelance(List<PerfilFreelance> listaFreelance) {
		this.listaFreelance = listaFreelance;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
