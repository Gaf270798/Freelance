package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.io.Serializable;
import pe.edu.upc.daointerface.IUsuarioDAO;
import pe.edu.upc.entity.Usuario;

@Named
public class UsuarioDAOimpl implements IUsuarioDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Freelance")
	private EntityManager em;
	
	@Override
	public Integer insert(Usuario user) throws Exception {
		em.persist(user);
		return user.getPerfil().getId();
	}

	@Override
	public Integer update(Usuario user) throws Exception {
		em.merge(user);
		return user.getPerfil().getId();
	}

	@Override
	public Integer delete(Usuario user) throws Exception {
		em.remove(user);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> list() throws Exception {
		List<Usuario> users = new ArrayList<>();

		Query query = em.createQuery("SELECT c FROM Usuario c");
		users = (List<Usuario>) query.getResultList();

		return users;
	}

	//SpecialDAOFunctions
	
	@Override
	public Optional<Usuario> findById(Usuario u) throws Exception {
		Usuario user;
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.id = ?1", Usuario.class);
		query.setParameter(1, u.getId());

		user = query.getSingleResult();

		return Optional.of(user);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getPassworHashedByUserName(String username) throws Exception {
		Usuario user = new Usuario();

		try {
			//POSIBLE ERROR
			Query query = em.createQuery("FROM Usuario u WHERE u.username = ?1");
			query.setParameter(1, username);
						
			List<Usuario> lista = query.getResultList();
			if (!lista.isEmpty()) {
				user = lista.get(0);
			}
		} catch (Exception e) {
			System.out.println("error al obtener contraseña de usuario por username");
			throw e;
		}

		return user != null ? user.getPassword() : "";
	}

	@Override
	public Optional<Usuario> findUserByUsername(Usuario user) throws Exception {
		//POSIBLE ERROR
		Usuario userFound;
		TypedQuery<Usuario> query = em.createQuery("FROM Usuario u WHERE u.username = ?1 and u.password = ?2", Usuario.class);
		query.setParameter(1, user.getUsername());
		query.setParameter(2, user.getPassword());

		userFound = query.getSingleResult();

		return Optional.of(userFound);
	}

}
