package dao;

import model.Usuario;

public interface UsuarioDAO {
	public void save(Usuario usuario);
	public Usuario get(long id);
	public void delete(Usuario usuario);

}
