package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerface.IPerfilDAO;
import pe.edu.upc.daointerface.IfreelanceDao;
import pe.edu.upc.entity.PerfilFreelance;
import pe.edu.upc.serviceinterface.IfreelanceService;

@Named
@RequestScoped
public class FreelanceServiceImpl implements IfreelanceService, Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IfreelanceDao iD;

	@Override
	public void insert(PerfilFreelance f) {
		try {
			iD.insertar(f);
		} catch (Exception e) {
			System.out.println("Error en el service al insertar un freelance");
		}	
	}

	@Override
	public List<PerfilFreelance> list() {
		return iD.listar();
	}

	@Override
	public void delete(int f) {
		iD.delete(f);
		
	}

	@Override
	public void modify(PerfilFreelance f) {
		try {
			iD.modify(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
