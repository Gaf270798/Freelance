package pe.edu.upc.daointerface;

import java.util.List;

import pe.edu.upc.entity.Freelance;

public interface IfreelanceDao {
	public void insertar(Freelance f);
	
	public List<Freelance> listar();
	
	public void delete(int f);
	
	public void modify(Freelance f);
}
