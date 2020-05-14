package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.PerfilCliente;
import pe.edu.upc.serviceinterface.IclienteService;
import pe.edu.upc.serviceinterface.IRolService;

@Named
@RequestScoped
public class ClienteController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IclienteService iService;
    @Inject
    private IRolService rS;
    
    private boolean readonly;
    private PerfilCliente i;
    
    List<PerfilCliente> listaCliente;

    @PostConstruct
    public void init(){
    	this.listaCliente = new ArrayList<PerfilCliente>();
        this.i = new PerfilCliente();
        this.list();
        this.readonly = false;
    }

    public void list(){
        listaCliente = iService.list();
    }

    public void cleanCliente(){
        this.init();
    }

    public String modCliente(PerfilCliente f) {
		System.out.println(f.toString());
		this.setI(f);
		readonly = true;
		
		return "clienteUpdate.xhtml";
    }
    
    public void modify() {
		try {
			readonly = false;
			iService.update(i);
			cleanCliente();
			list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
    
    public void delete(int df) {
		System.out.println("intentar eliminar roles");
		try {
			rS.deassignRolesToUser(df);
			System.out.println("roles eliminados");
		} catch (Exception e) {
			System.out.println("no es posible quitar roles");
			e.getMessage();
		}

		System.out.println("eliminar Cliente");
		try {
			iService.delete(df);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.list();
    }
    
    //getters y setters
    public PerfilCliente getI() {
        return i;
    }
    public void setI(PerfilCliente i) {
        this.i = i;
    }
    public List<PerfilCliente> getListaCliente() {
        return listaCliente;
    }

	public boolean isReadonly() {
		return readonly;
	}

  
}