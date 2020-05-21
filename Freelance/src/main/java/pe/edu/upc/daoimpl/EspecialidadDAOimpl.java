package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IEspecialidadDAO;
import pe.edu.upc.entity.EspFreelance;
import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.entity.PerfilFreelance;

@Named
public class EspecialidadDAOimpl implements IEspecialidadDAO, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "FreelanceProject")
	private EntityManager em;

	@Transactional
	@Override
	public Integer insert(Especialidad rol) throws Exception {
		em.persist(rol);
		return rol.getId();
	}

	@Transactional
	@Override
	public Integer delete(Especialidad rol) throws Exception {
		em.remove(rol);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidad> list() throws Exception {
		List<Especialidad> roles = new ArrayList<Especialidad>();

		Query q = em.createQuery("SELECT r FROM Especialidad r");
		roles = (List<Especialidad>) q.getResultList();
		return roles;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Especialidad> findById(Especialidad t) throws Exception {

		Especialidad rol = new Especialidad();
		List<Especialidad> roles = new ArrayList<Especialidad>();
		
		Query query = em.createQuery("FROM Especialidad r where r.id = ?1");
		query.setParameter(1, t.getId());

		roles = (List<Especialidad>) query.getResultList();

		if (roles != null && !roles.isEmpty()) {
			rol = roles.get(0);
		}

		return Optional.of(rol);
	}

	@Transactional
	@Override
	public Integer insertEspPerfil(List<EspFreelance> espinprofile) throws Exception {
		try {

			final int[] iarr = { 0 };
			espinprofile.forEach(r -> {
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

	@Transactional
	@Override
	public Integer removeEspPerfil(int user) throws Exception {
		int deletedCount = 0;
		try {
			System.out.println("query tries remove: " + String.valueOf(user));
			Query query = em.createQuery(
			      "DELETE FROM EspFreelance c WHERE c.freelance.id = ?1");
			 deletedCount = query.setParameter(1, user).executeUpdate();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return deletedCount;
	}

	@Transactional
	@Override
	public Integer deassignEsp(PerfilFreelance f, Especialidad e) {
		int deletedCount = 0;
		try {
			Query query = em.createQuery(
			      "DELETE FROM EspFreelance c WHERE c.freelance.id = ?1 and c.topic.id = ?2");
			query.setParameter(1, f.getId());
			query.setParameter(2, e.getId());
			
			 deletedCount = query.executeUpdate();
		}
		catch(Exception e1){
			System.out.println(e1.getMessage());
		}
		return deletedCount;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EspFreelance> findEspPerfil(PerfilFreelance user) throws Exception {
		List<EspFreelance> espPerfil = new ArrayList<EspFreelance>();

		try {
			Query query = em.createQuery("FROM EspFreelance ur where ur.freelance.id =?1");
			query.setParameter(1, user.getId());

			espPerfil = (List<EspFreelance>) query.getResultList();

		} catch (Exception e) {
			throw e;
		}

		return espPerfil;
	}

}
