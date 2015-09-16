package dao;

import java.util.ArrayList;
import java.util.List;

import com.db4o.ObjectSet;
import com.db4o.ext.ExtObjectContainer;

public class DAOImpl<E> implements DAO<E> {
	private static ExtObjectContainer db = DatabaseManager.getConnection();
	private Class<E> clase;
	
	public DAOImpl(Class<E> clase) {
		// TODO Auto-generated constructor stub
		this.clase = clase;
	}

	@Override
	public boolean guardar(E object) {
		// TODO Auto-generated method stub
		db.store(object);
		db.commit(); // ¿El commit no deberia ir aca?
		return true;
	}

	@Override
	public void borrar(E object) {
		// TODO Auto-generated method stub
		db.delete(object);
		db.commit();
	}

	@Override
	public List<E> listar() {
		// TODO Auto-generated method stub
		List<E> objects = new ArrayList<E>();
		ObjectSet<E> result = db.queryByExample(clase);
		while(result.hasNext()){
			objects.add((E)result.next());
		}
		return objects;
	}

	@Override
	public E obtener(E object) {
		// TODO Auto-generated method stub
		return null;
	}


}
