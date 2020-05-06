package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerface.IfreelanceDao;
import pe.edu.upc.entity.Freelance;
import pe.edu.upc.serviceinterface.IfreelanceService;

@Named
@RequestScoped
public class FreelanceServiceImpl implements IfreelanceService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IfreelanceDao iD;
	@Override
	public void insert(Freelance f) {
		try {
			iD.insertar(f);
		} catch (Exception e) {
			System.out.println("Error en el service al insertar un freelance");
		}
		
		
	}

	@Override
	public List<Freelance> list() {

		return iD.listar();
	}

}
