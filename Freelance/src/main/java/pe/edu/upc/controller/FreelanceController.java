package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Freelance;
import pe.edu.upc.serviceinterface.IfreelanceService;

@Named
@RequestScoped
public class FreelanceController implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Inject
	private IfreelanceService iservice;
	
	private Freelance f;

	List<Freelance>listaFreelance;

	@PostConstruct
	public void init() {
		this.listaFreelance = new ArrayList<Freelance>();
		this.f = new Freelance();
		this.listFreelance();
	}
	public String newFreelance() {
		this.setF(new Freelance());
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
	public IfreelanceService getIservice() {
		return iservice;
	}
	public void setIservice(IfreelanceService iservice) {
		this.iservice = iservice;
	}
	public Freelance getF() {
		return f;
	}
	public void setF(Freelance f) {
		this.f = f;
	}
	public List<Freelance> getListaFreelance() {
		return listaFreelance;
	}
	public void setListaFreelance(List<Freelance> listaFreelance) {
		this.listaFreelance = listaFreelance;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
