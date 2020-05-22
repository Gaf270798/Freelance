package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.daointerface.IServicioDAO;
import pe.edu.upc.entity.Servicio;
import pe.edu.upc.serviceinterface.IServicioService;

public class ServicioServiceImpl implements Serializable, IServicioService {

	private static final long serialVersionUID = 1L;

	@Inject
	private IServicioDAO sD;
	
	@Override
	public void insertar(Servicio service) {
		sD.insertar(service);
	}

	@Override
	public List<Servicio> listar() {
		return sD.listar();
	}

	@Override
	public void delete(int id) {
		sD.delete(id);
	}

	@Override
	public void modify(Servicio iA) {
		sD.modify(iA);
	}

}
