package dao;

import java.util.List;

public interface DAO<E> {
	public abstract boolean guardar(E object);
	public abstract void borrar(E object);
	public abstract List<E> listar();
	public abstract E obtener(E object);
	public abstract E buscar(E object);
}
