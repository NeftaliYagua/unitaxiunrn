package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO {
	public void crearUsuario(Usuario usuario);
	public Usuario obtenerUsuario(Usuario usuario);
	public List<Usuario> listarUsuarios(Usuario usuario);
	public void borrarUsuario(Usuario usuario);

}
