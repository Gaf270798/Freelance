package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Perfil;

public interface IPerfilService {
	Integer insert(Perfil customer) throws Exception;

	Integer update(Perfil customer) throws Exception;

	Integer delete(Perfil customer) throws Exception;

	List<Perfil> list() throws Exception;

	Optional<Perfil> getOne(Perfil customer) throws Exception;

	List<Perfil> findCustomerByName(String name) throws Exception;

	Optional<Perfil> findCustomerByDni(String dni) throws Exception;

}
