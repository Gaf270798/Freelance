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
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IPerfilDAO;
import pe.edu.upc.entity.Perfil;
import pe.edu.upc.entity.PerfilCliente;
import pe.edu.upc.entity.PerfilFreelance;

@Named
public class PerfilDAOimpl implements IPerfilDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "FreelanceProject")
	private EntityManager em;

	@Transactional
	@Override
	public Integer insert(Perfil t) throws Exception {
		em.persist(t);
		System.out.println("entidad generada con ID: " + String.valueOf(t.getId()));
		return t.getId();
	}

	@Transactional
	@Override
	public Integer update(Perfil t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Transactional
	@Override
	public Integer delete(int t) throws Exception {
		Perfil mot = new Perfil();
		try {
			mot = em.getReference(Perfil.class, t);
			em.remove(mot);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> list() throws Exception {
		List<Perfil> profiles = new ArrayList<Perfil>();

		Query q = em.createQuery("SELECT c FROM Perfil c");
		profiles = (List<Perfil>) q.getResultList();
		return profiles;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PerfilCliente> listCliente(){
		List<PerfilCliente> profiles = new ArrayList<PerfilCliente>();
		
		try {
			Query q = em.createQuery("SELECT c FROM Perfil c where ptype = 'C'");
			profiles = (List<PerfilCliente>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return profiles;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PerfilFreelance> listFreelance(){
		List<PerfilFreelance> profiles = new ArrayList<PerfilFreelance>();
		
		try {
			Query q = em.createQuery("SELECT c FROM Perfil c where ptype = 'F'");
			profiles = (List<PerfilFreelance>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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
