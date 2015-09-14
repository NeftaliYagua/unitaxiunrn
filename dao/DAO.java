package dao;

import java.util.List;

public interface DAO<E> {
	public abstract boolean save(E object);
	public abstract void delete(E object);
	public abstract List<E> list();
	public abstract E get(E object);
	public abstract List<E> search(E object);
}
