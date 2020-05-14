package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.PerfilFreelance;

public interface IfreelanceService {
	public void insert(PerfilFreelance f);

	public List<PerfilFreelance> list();
	
	public void delete(int f) throws Exception;
	
	public void modify(PerfilFreelance f);
}
