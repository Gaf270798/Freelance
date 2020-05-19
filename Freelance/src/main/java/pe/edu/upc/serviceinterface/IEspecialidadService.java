package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.entity.PerfilFreelance;
import pe.edu.upc.entity.EspFreelance;

public interface IEspecialidadService {
	Integer insert(Especialidad rol) throws Exception;

	Integer delete(Especialidad rol) throws Exception;

	List<Especialidad> getAll() throws Exception;

	Optional<Especialidad> getOne(Especialidad t) throws Exception;
	
	Integer assignEspToFreelance(PerfilFreelance user, List<Especialidad> roles) throws Exception;

	Integer deassignEspToFreelance(int user) throws Exception;
	
	List<EspFreelance> findEspByFreelance(PerfilFreelance user) throws Exception;

}
