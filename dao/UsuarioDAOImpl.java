package dao;

import java.util.List;

import model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	private static DAO<Usuario> dao = new DAOImpl<Usuario>(Usuario.class);

	@Override
	public void crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		dao.save(usuario);
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
				
		return null;
	}

	@Override
	public Usuario buscarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return dao.search(usuario);
	}

	@Override
	public List<Usuario> listarUsuarios(Usuario usuario) {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public void borrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		dao.delete(usuario);
	}

}
