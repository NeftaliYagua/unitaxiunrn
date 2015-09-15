package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO {
	public void crearUsuario(Usuario usuario);
	public Usuario actualizarUsuario(Usuario usuario);
	public Usuario buscarUsuario(Usuario usuario);
	public List<Usuario> listarUsuarios(Usuario usuario);
	public void borrarUsuario(Usuario usuario);

}
