package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Freelance;

public interface IfreelanceService {
	public void insert(Freelance f);

	public List<Freelance> list();
}