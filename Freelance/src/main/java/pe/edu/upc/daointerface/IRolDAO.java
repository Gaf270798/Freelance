package pe.edu.upc.daointerface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Rol;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.UsuarioRol;


public interface IRolDAO {
	Integer insert(Rol rol) throws Exception;

	Integer update(Rol rol) throws Exception;

	Integer delete(Rol rol) throws Exception;

	List<Rol> list() throws Exception;

	Optional<Rol> findById(Rol rol) throws Exception;

	Integer insertUserRole(List<UsuarioRol> userRoles) throws Exception;

	List<UsuarioRol> findUserRolesByUser(Usuario user) throws Exception;
}
