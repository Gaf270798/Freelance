package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IclienteDao;
import pe.edu.upc.entity.PerfilCliente;

public class ClienteDaoImpl implements IclienteDao, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "FreelanceProject")
    private EntityManager em;

    @Transactional
    @Override
    public void insert(PerfilCliente i) {
        try {
            em.persist(i);
        } catch (Exception e) {
            System.out.println("Error en DAO Iinsert ClienteImpl");
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PerfilCliente> list() {
        List<PerfilCliente> lista = new ArrayList<PerfilCliente>();
        try {
            Query q = em.createQuery("SELECT i FROM PerfilCliente i");
            lista = (List<PerfilCliente>) q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en DAO Ilist ClienteImpl");
        }
        return lista;
    }    
}