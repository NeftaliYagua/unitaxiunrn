package dao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;

import model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	ObjectContainer db;

	public UsuarioDAOImpl(ObjectContainer session) {
		db = session;
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		db.store(usuario);
	}

	@Override
	public Usuario getById(String id) {
		// TODO Auto-generated method stub
		List<Usuario> result = db.query(new Predicate<Usuario>() {
			@Override
			public boolean match(Usuario usuario) {
				return usuario.getId().equals(id);
			}
		});
		return result.get(0);
	}

	@Override
	public void borrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		db.delete(usuario);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> result = db.query(Usuario.class);
		return result;
	}

}
