package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Throwables;

import conf.Conf;

/**
 * 
 * @author GOLIATH
 *
 */
public class MysqlConnectUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(MysqlConnectUtil.class);
    private static final String DRIVER = "com.mysql.jdbc.Driver";

	public static Connection openConnection() {
		Properties connectionProps = new Properties();
		connectionProps.put("user", Conf.databaseLogin);
		connectionProps.put("password", Conf.databasePassword);
		
		try {
			Class.forName(DRIVER).newInstance();
			return DriverManager.getConnection("jdbc:mysql://" + Conf.databaseServer + ":" + Conf.databasePort + "/" + Conf.databaseScheme, connectionProps);
		} catch (SQLException e) {
			LOGGER.error("Could not open DB connection: " + e.getMessage(), e);
			Throwables.propagate(e);
		} catch (InstantiationException e) {
			LOGGER.error("Could not open DB connection: " + e.getMessage(), e);
			Throwables.propagate(e);
		} catch (IllegalAccessException e) {
			LOGGER.error("Could not open DB connection: " + e.getMessage(), e);
			Throwables.propagate(e);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Could not open DB connection: " + e.getMessage(), e);
			Throwables.propagate(e);
		}
		return null;
	}

	public static final void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			LOGGER.error("Could not close DB connection:", e);
		}
	}

}
