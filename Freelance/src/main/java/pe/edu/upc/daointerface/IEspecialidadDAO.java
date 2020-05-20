package pe.edu.upc.daointerface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.entity.PerfilFreelance;
import pe.edu.upc.entity.EspFreelance;

public interface IEspecialidadDAO {
	Integer insert(Especialidad rol) throws Exception;

	Integer delete(Especialidad rol) throws Exception;

	List<Especialidad> list() throws Exception;

	Integer insertEspPerfil(List<EspFreelance> userRoles) throws Exception;
	
	Integer removeEspPerfil(int user) throws Exception;
	
	List<EspFreelance> findEspPerfil(PerfilFreelance user) throws Exception;

	Optional<Especialidad> findById(Especialidad t) throws Exception;

	Integer deassignEsp(PerfilFreelance f, Especialidad e);
}
