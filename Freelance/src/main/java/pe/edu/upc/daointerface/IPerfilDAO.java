package pe.edu.upc.daointerface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Perfil;
import pe.edu.upc.entity.PerfilCliente;
import pe.edu.upc.entity.PerfilFreelance;

public interface IPerfilDAO {
	Integer insert(Perfil perfil) throws Exception;

	Integer update(Perfil perfil) throws Exception;

	Integer delete(int perfil) throws Exception;

	List<Perfil> list() throws Exception;

	Optional<Perfil> findById(int perfil) throws Exception;

	List<Perfil> findByName(String perfil) throws Exception;

	Optional<Perfil> findByDni(String perfil) throws Exception;

	List<PerfilCliente> listCliente();

	List<PerfilFreelance> listFreelance();
}
