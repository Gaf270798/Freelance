package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Cliente;

public interface IclienteService {
    public void insert(Cliente i);
    public List<Cliente> list();
}