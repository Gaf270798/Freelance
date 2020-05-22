package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.PerfilFreelance;
import pe.edu.upc.entity.Servicio;
import pe.edu.upc.serviceinterface.IServicioService;
import pe.edu.upc.serviceinterface.IfreelanceService;

@Named
@RequestScoped
public class ServicioController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IServicioService sS;;
	@Inject
	private IfreelanceService fS;

	private List<Servicio> listaServicio;
	private Servicio s;
	
	private List<PerfilFreelance> listaFreelance;
	
	@PostConstruct
	public void init() {
		this.listaServicio = new ArrayList<Servicio>();
		this.s = new Servicio();
		this.listaFreelance = new ArrayList<PerfilFreelance>();
		
		this.list();
		this.listFreelance();
	}
	
	public void list() {
		listaServicio = sS.listar();
	}
	public void listFreelance() {
		listaFreelance = fS.list();
	}

	public void remove(int sid) {
		sS.delete(sid);
		list();
	}
	
	public List<Servicio> getListaServicio() {
		return listaServicio;
	}

	public void setListaServicio(List<Servicio> listaServicio) {
		this.listaServicio = listaServicio;
	}

	public Servicio getS() {
		return s;
	}

	public void setS(Servicio s) {
		this.s = s;
	}

	public List<PerfilFreelance> getListaFreelance() {
		return listaFreelance;
	}

	public void setListaFreelance(List<PerfilFreelance> listaFreelance) {
		this.listaFreelance = listaFreelance;
	}
	
	
}
