package pe.edu.upc.daointerface;

import java.util.List;

import pe.edu.upc.entity.Cliente;

public interface IclienteDao {
    public void insert(Cliente i);
    public List<Cliente> list();
}