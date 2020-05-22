package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IServicioDAO;
import pe.edu.upc.entity.Servicio;

public class ServicioDAOimpl implements Serializable, IServicioDAO {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName= "FreelanceProject" )
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Servicio service) {
		try {
			System.out.println("insert: " + service.toString());
			em.persist(service);
		} catch (Exception e) {
			System.out.println("insert service fail");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> listar() {
		List<Servicio> lista = new ArrayList<Servicio>();
		try {
			Query q = em.createQuery("select i from Servicio i");
			lista = (List<Servicio>)(q.getResultList());
		}catch( Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int id) {
		Servicio ia = new Servicio();
		try {
			ia = em.getReference(Servicio.class, id);
			em.remove(ia);
		} catch (Exception e) {
			System.out.println("delete service fail");
		}
	}
	
	@Transactional
	@Override
	public void modify(Servicio ser) {
		try {
			em.merge(ser);
		} catch (Exception e) {
			System.out.println("update service fail");
		}
	}

}
