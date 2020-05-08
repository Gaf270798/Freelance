package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.serviceinterface.IclienteService;

@Named
@RequestScoped
public class ClienteController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IclienteService iService;

    private Cliente i;
    
    List<Cliente> listaCliente;
    //inicializacion
    @PostConstruct
    public void init(){
        this.i = new Cliente();
        this.listaCliente = new ArrayList<Cliente>();
        this.list();
    }

    //metodos
    public String newCliente(){
        this.setI(new Cliente());
        return "cliente.xhtml";
    }

    public void insert(){
        iService.insert(i);
        this.cleanCliente();
        this.list();
    }

    public void list(){
        listaCliente = iService.list();
    }

    public void cleanCliente(){
        this.init();
    }


    //getters y setters
    public Cliente getI() {
        return i;
    }

    public void setI(Cliente i) {
        this.i = i;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    
}