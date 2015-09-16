package dao;

import java.util.List;

import model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	private static DAO<Usuario> dao = new DAOImpl<Usuario>(Usuario.class);

	@Override
	public void crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		dao.guardar(usuario);
	}

	@Override
	public Usuario obtenerUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return dao.obtener(usuario);
	}

	@Override
	public List<Usuario> listarUsuarios(Usuario usuario) {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public void borrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		dao.borrar(usuario);
	}

}
