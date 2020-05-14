package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.PerfilCliente;
import pe.edu.upc.serviceinterface.IclienteService;

@Named
@RequestScoped
public class ClienteServiceImpl implements IclienteService, Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private IclienteService iD;

    @Override
    public void insert(PerfilCliente i) {
        iD.insert(i);

    }

    @Override
    public List<PerfilCliente> list() {
        return iD.list();
    }
    
}