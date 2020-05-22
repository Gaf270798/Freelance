package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Servicio;

public interface IServicioService {
	public void insertar(Servicio service);
	
	public List<Servicio> listar();

	public void delete(int id);

	public void modify(Servicio iA);
}
