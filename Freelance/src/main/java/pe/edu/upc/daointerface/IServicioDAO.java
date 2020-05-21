package pe.edu.upc.daointerface;

import java.util.List;

import pe.edu.upc.entity.Servicio;

public interface IServicioDAO {
	public void insertar(Servicio infectious );
	
	public List<Servicio> listar();
	
	public void delete(int id );
	
	public void modify(Servicio ser);
}
