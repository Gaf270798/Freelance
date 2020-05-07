package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pe.edu.upc.daointerface.IPerfilDAO;
import pe.edu.upc.entity.Perfil;

@Named
public class PerfilDAOimpl implements IPerfilDAO, Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "Freelance")
	private EntityManager em;

	@Override
	public Integer insert(Perfil t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Perfil t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Perfil t) throws Exception {
		em.remove(t);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> list() throws Exception {
		List<Perfil> profiles = new ArrayList<Perfil>();

		Query q = em.createQuery("SELECT c FROM Customer c");
		profiles = (List<Perfil>) q.getResultList();
		return profiles;
	}

	//SPECIALDAOFUNCTIONS
	
	@SuppressWarnings("unchecked")
	@Override
	public Optional<Perfil> findById(Perfil t) throws Exception {

		Perfil customerFound = new Perfil();

		List<Perfil> customers = new ArrayList<Perfil>();
		Query q = em.createQuery("FROM Perfil c where c.id = ?1");
		q.setParameter(1, t.getId());

		customers = (List<Perfil>) q.getResultList();

		if (customers != null && !customers.isEmpty()) {
			customerFound = customers.get(0);
		}

		return Optional.of(customerFound);
	}

	@Override
	public List<Perfil> findByName(String name) throws Exception {
		return em.createQuery("from Customer where name like :name", Perfil.class)
				.setParameter("name", "%" + name + "%").getResultList();
	}

	@Override
	public Optional<Perfil> findByDni(String dni) throws Exception {
		Perfil customer;
		TypedQuery<Perfil> customerExist = em.createQuery("Select c from Customer c  where c.dni =:dni",
				Perfil.class);
		customerExist.setParameter("dni", dni);
		customer = customerExist.getSingleResult();

		return Optional.of(customer);
	}

}
