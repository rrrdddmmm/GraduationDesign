package edu.xust.db;

import edu.xust.common.JWarnConfig;

public final class DbConfig  extends JWarnConfig{
	private static DbConfig instance;

	public static DbConfig getInstance() {
		if (instance != null) {
			return instance;
		} else {
			makeInstance();
			return instance;
		}
	}

	public static synchronized void makeInstance() {
		if (instance == null) {
			instance = new DbConfig();
		}

	}

	private DbConfig() {
		loadPropertyFile("db.properties");
	}

}
