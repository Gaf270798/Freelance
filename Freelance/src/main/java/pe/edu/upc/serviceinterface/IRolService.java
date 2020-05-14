package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Rol;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.UsuarioRol;

public interface IRolService {
	Integer insert(Rol rol) throws Exception;

	Integer update(Rol rol) throws Exception;

	Integer delete(Rol rol) throws Exception;

	List<Rol> getAll() throws Exception;

	Optional<Rol> getOne(Rol rol) throws Exception;

	Integer assignRolesToUser(Usuario user, List<Rol> roles) throws Exception;

	Integer deassignRolesToUser(int user) throws Exception;
	
	List<UsuarioRol> findUserRolesByUser(Usuario user) throws Exception;

}
