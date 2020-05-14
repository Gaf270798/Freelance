package pe.edu.upc.daoimpl;

import java.io.Serializable;

import pe.edu.upc.daointerface.IfreelanceDao;

public class FreelanceDaoImpl implements IfreelanceDao, Serializable {

	private static final long serialVersionUID = 1L;
/*	@PersistenceContext(unitName = "FreelanceProject")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(PerfilFreelance f) {
		try {
			em.persist(f);
		} catch (Exception e) {
			System.out.println("Error insert DAOImpl");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PerfilFreelance> listar() {
		List<PerfilFreelance> lista = new ArrayList<PerfilFreelance>();
		try {
			Query q = em.createQuery("select i from Perfil i where ptype = 'F'");
			lista = (List<PerfilFreelance>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar DAOImpl");
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int f) {
		PerfilFreelance mot = new PerfilFreelance();
		try {
			mot = em.getReference(PerfilFreelance.class, f);
			em.remove(mot);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Transactional
	@Override
	public void modify(PerfilFreelance f) {
		try {
			System.out.println("trying update query with: " + String.valueOf(f.getId()));// + f.toString());
			Query query = em
					.createQuery("Update Perfil set address = ?1,  dni = ?2, email = ?3, lname = ?4, name = ?5 " + "Where id = ?6");
			query.setParameter(1, f.getAddress());
			query.setParameter(2, f.getDni());
			query.setParameter(3, f.getEmail());
			query.setParameter(4, f.getLname());
			query.setParameter(5, f.getName());
			query.setParameter(6, f.getId());
			
			query.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
*/
}
