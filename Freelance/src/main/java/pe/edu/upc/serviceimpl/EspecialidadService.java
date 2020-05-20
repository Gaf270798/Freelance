package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import pe.edu.upc.daointerface.IEspecialidadDAO;
import pe.edu.upc.entity.EspFreelance;
import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.entity.PerfilFreelance;
import pe.edu.upc.serviceinterface.IEspecialidadService;

public class EspecialidadService implements IEspecialidadService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEspecialidadDAO eD;
	
	@Override
	public Integer insert(Especialidad rol) throws Exception {
		return eD.insert(rol);
	}

	@Override
	public Integer delete(Especialidad rol) throws Exception {
		return eD.delete(rol);
	}

	@Override
	public List<Especialidad> getAll() throws Exception {
		return eD.list();
	}

	@Override
	public Integer assignEspToFreelance(PerfilFreelance user, List<Especialidad> roles) throws Exception {
		List<EspFreelance> userRoles = new ArrayList<>();

		roles.forEach(rol -> {
			EspFreelance userRol = new EspFreelance();
			userRol.setFreelance(user);
			userRol.setTopic(rol);
			userRoles.add(userRol);
		});

		eD.insertEspPerfil(userRoles);

		return 1;
	}

	@Override
	public Integer cleanEspToFreelance(int user) throws Exception {
		return eD.removeEspPerfil(user);
	}
	
	@Override
	public Integer deassignEsp(PerfilFreelance f, Especialidad e) {
		return eD.deassignEsp(f,e);
	}

	@Override
	public List<EspFreelance> findEspByFreelance(PerfilFreelance user) throws Exception {
		return eD.findEspPerfil(user);
	}
	@Override
	public Optional<Especialidad> getOne(Especialidad t) throws Exception {
		return eD.findById(t);
	}

}
