package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO {
	public void guardarUsuario(Usuario usuario);

	public Usuario getById(String id);

	public List<Usuario> listarUsuarios();

	public void borrarUsuario(Usuario usuario);

}
