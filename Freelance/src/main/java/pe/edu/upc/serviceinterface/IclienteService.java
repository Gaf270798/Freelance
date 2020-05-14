package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.PerfilCliente;

public interface IclienteService {
    public void insert(PerfilCliente i);
    public List<PerfilCliente> list();
}