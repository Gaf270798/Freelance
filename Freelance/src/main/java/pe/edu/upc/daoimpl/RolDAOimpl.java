package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.daointerface.IRolDAO;
import pe.edu.upc.entity.Rol;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.UsuarioRol;

@Named
public class RolDAOimpl implements IRolDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "FreelanceProject")
	private EntityManager em;
	
	@Override
	public Integer insert(Rol t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Rol t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Rol t) throws Exception {
		em.remove(t);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> list() throws Exception {
		List<Rol> roles = new ArrayList<Rol>();

		Query q = em.createQuery("SELECT r FROM Rol r");
		roles = (List<Rol>) q.getResultList();
		return roles;
	}

	//SPECIALDAOFUNCTIONS
	
	@SuppressWarnings("unchecked")
	@Override
	public Optional<Rol> findById(Rol t) throws Exception {

		Rol rol = new Rol();
		List<Rol> roles = new ArrayList<Rol>();
		Query query = em.createQuery("FROM Rol r where r.id = ?1");
		query.setParameter(1, t.getId());

		roles = (List<Rol>) query.getResultList();

		if (roles != null && !roles.isEmpty()) {
			rol = roles.get(0);
		}

		return Optional.of(rol);
	}

	@Override
	public Integer insertUserRole(List<UsuarioRol> userRoles) throws Exception {
		try {

			final int[] iarr = { 0 };
			userRoles.forEach(r -> {
				em.persist(r);
				if (iarr[0] % 100 == 0) {
					em.flush();
					em.clear();
				}
				iarr[0]++;
			});
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioRol> findUserRolesByUser(Usuario user) throws Exception {
		List<UsuarioRol> userRoles = new ArrayList<UsuarioRol>();

		try {
			Query query = em.createQuery("FROM UsuarioRol ur where ur.usuario.perfil.id =?1");
			query.setParameter(1, user.getPerfil().getId());

			userRoles = (List<UsuarioRol>) query.getResultList();

		} catch (Exception e) {
			throw e;
		}

		return userRoles;
	}

}
