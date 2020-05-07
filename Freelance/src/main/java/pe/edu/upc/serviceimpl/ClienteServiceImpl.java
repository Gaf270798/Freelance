package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.serviceinterface.IclienteService;

public class ClienteServiceImpl implements IclienteService, Serializable {

    private static final long serialVersionUID = 1L;
    @Inject

    private IclienteService iD;

    @Override
    public void insert(Cliente i) {
        iD.insert(i);

    }

    @Override
    public List<Cliente> list() {
        return iD.list();
    }
    
}