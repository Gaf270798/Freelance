package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IclienteDao;
import pe.edu.upc.entity.Cliente;

public class ClienteDaoImpl implements IclienteDao, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "Freelance")
    private EntityManager em;

    @Transactional
    @Override
    public void insert(Cliente i) {
        try {
            em.persist(i);
        } catch (Exception e) {
            System.out.println("Error en DAO Iinsert ClienteImpl");
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Cliente> list() {
        List<Cliente> lista = new ArrayList<Cliente>();
        try {
            Query q = em.createQuery("SELECT i FROM Cliente i");
            lista = (List<Cliente>) q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en DAO Ilist ClienteImpl");
        }
        return lista;
    }    
}