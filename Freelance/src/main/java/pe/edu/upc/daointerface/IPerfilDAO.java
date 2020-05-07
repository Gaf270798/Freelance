package pe.edu.upc.daointerface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Perfil;

public interface IPerfilDAO {
	Integer insert(Perfil perfil) throws Exception;

	Integer update(Perfil perfil) throws Exception;

	Integer delete(Perfil perfil) throws Exception;

	List<Perfil> list() throws Exception;

	Optional<Perfil> findById(Perfil perfil) throws Exception;

	List<Perfil> findByName(String perfil) throws Exception;

	Optional<Perfil> findByDni(String perfil) throws Exception;
}
