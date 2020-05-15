package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IPerfilDAO;
import pe.edu.upc.entity.Perfil;
import pe.edu.upc.serviceinterface.IPerfilService;

@Named
public class PerfilServiceImpl implements IPerfilService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPerfilDAO cD;
	
	@Transactional
	@Override
	public Integer insert(Perfil t) throws Exception {
		return cD.insert(t);
	}

	@Transactional
	@Override
	public Integer update(Perfil t) throws Exception {
		return cD.update(t);
	}

	@Transactional
	@Override
	public Integer delete(int t) throws Exception {
		return cD.delete(t);
	}

	@Override
	public List<Perfil> list() throws Exception {
		return cD.list();
	}
	//SPECIALDATOSHIT
	@Override
	public Optional<Perfil> getOne(int t) throws Exception {
		return cD.findById(t);
	}

	@Override
	public List<Perfil> findCustomerByName(String name) throws Exception {
		return cD.findByName(name);
	}

	@Override
	public Optional<Perfil> findCustomerByDni(String dni) throws Exception {
		return cD.findByDni(dni);
	}

}
