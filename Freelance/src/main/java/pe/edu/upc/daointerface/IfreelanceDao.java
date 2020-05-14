package pe.edu.upc.daointerface;

import java.util.List;

import pe.edu.upc.entity.PerfilFreelance;

public interface IfreelanceDao {
	public void insertar(PerfilFreelance f);
	
	public List<PerfilFreelance> listar();
	
	public void delete(int f);
	
	public void modify(PerfilFreelance f);
}
