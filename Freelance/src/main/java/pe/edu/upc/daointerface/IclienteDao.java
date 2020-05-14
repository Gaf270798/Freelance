package pe.edu.upc.daointerface;

import java.util.List;

import pe.edu.upc.entity.PerfilCliente;

public interface IclienteDao {
    public void insert(PerfilCliente i);
    public List<PerfilCliente> list();
}