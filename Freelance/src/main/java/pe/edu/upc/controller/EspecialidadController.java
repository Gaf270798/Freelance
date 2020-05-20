package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.serviceinterface.IEspecialidadService;

@Named
@RequestScoped
public class EspecialidadController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEspecialidadService eS;
	
	private List<Especialidad> listaEspecialidad;
	
	@PostConstruct
	public void init() {
		System.out.println("tag init");
		this.setListaEspecialidad(new ArrayList<Especialidad>());
		this.list();
	}
	
	public void list() {
		try {
			setListaEspecialidad(eS.getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Especialidad> getListaEspecialidad() {
		return listaEspecialidad;
	}

	public void setListaEspecialidad(List<Especialidad> listaEspecialidad) {
		this.listaEspecialidad = listaEspecialidad;
	}

}
