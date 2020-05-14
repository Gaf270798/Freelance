package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerface.IPerfilDAO;
import pe.edu.upc.entity.Perfil;
import pe.edu.upc.entity.PerfilCliente;
import pe.edu.upc.serviceinterface.IclienteService;

@Named
@RequestScoped
public class ClienteServiceImpl implements IclienteService, Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private IPerfilDAO iD;

    @Override
    public void insert(PerfilCliente i) {
        //iD.insert(i);

    }

    @Override
    public List<PerfilCliente> list() {
        return iD.listCliente();
    }

    @Override
	public Integer update(Perfil t) throws Exception {
		return iD.update(t);
	}
	
	@Override
	public Integer delete(int t) throws Exception {
		return iD.delete(t);
	}

}