package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IfreelanceDao;
import pe.edu.upc.entity.Freelance;

public class FreelanceDaoImpl implements IfreelanceDao, Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "FreelanceProject")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Freelance f) {
		try {
			em.persist(f);
		} catch (Exception e) {
			System.out.println("Error insert DAOImpl" );
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Freelance> listar() {
		List<Freelance> lista = new ArrayList<Freelance>();
		try {
			Query q = em.createQuery("select i from Freelance i");
			lista = (List<Freelance>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar DAOImpl");
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int f) {
		Freelance mot = new Freelance();
		try {
			mot = em.getReference(Freelance.class, f );
			em.remove(mot);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Transactional
	@Override
	public void modify(Freelance f) {
		em.merge(f);
	}

	
}

