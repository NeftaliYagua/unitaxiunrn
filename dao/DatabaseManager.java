package dao;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ext.ExtObjectContainer;

public class DatabaseManager {
	public static final String DATABASE = "unitaxi.db";
	private static ExtObjectContainer db;

	public static ExtObjectContainer getConnection() {
		return open();
	}

	public static ExtObjectContainer open() {
		if (db != null) {
			db.close();
		}
		ObjectContainer objectContainer = Db4o.openFile(DATABASE);
		db = objectContainer.ext();
		return db;
	}

	public static void close() {
		if (!db.isClosed()) {
			db.close();
		}
	}

}
