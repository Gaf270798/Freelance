package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import pe.edu.upc.daointerface.IUsuarioDAO;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.serviceinterface.IUsuarioService;

@Named
public class UsuarioServiceImpl implements IUsuarioService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUsuarioDAO uD;
	
	@Transactional
	@Override
	public Integer insert(Usuario user) throws Exception {
		return uD.insert(user);
	}

	@Transactional
	@Override
	public Integer update(Usuario user) throws Exception {
		return uD.update(user);
	}

	@Transactional
	@Override
	public Integer delete(Usuario user) throws Exception {
		return uD.delete(user);
	}

	@Override
	public List<Usuario> list() throws Exception {
		return uD.list();
	}

	//SpecialServiceFunctions
	
	@Override
	public Optional<Usuario> getOne(Usuario user) throws Exception {
		return uD.findById(user);
	}

	@Override
	public Optional<Usuario> authentication(Usuario us) throws Exception {
		String password = us.getPassword();

		System.out.println("1.1");
		String passwordHash = uD.getPassworHashedByUserName(us.getUsername());

		if (BCrypt.checkpw(password, passwordHash)) {
			us.setPassword(passwordHash);
			System.out.println("1.2.Exit");
			return uD.findUserByUsername(us);
		}
		
		System.out.println("1.2.Failed");
		Usuario failed = new Usuario();
		failed.setState("F");
		return Optional.of(failed);
	}

}
