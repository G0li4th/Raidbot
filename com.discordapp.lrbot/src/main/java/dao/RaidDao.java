package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.MysqlConnectUtil;

/**
 * 
 * @author GOLIATH
 *
 */
public class RaidDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RaidDao.class);

	public void create(String guildID, String name, String answer) throws SQLException {
		Connection connection = MysqlConnectUtil.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("INSERT INTO commands(`guild`, `name`, `answer`) VALUES (?, ?, ?)");

			statement.setString(1, guildID);
			statement.setString(2, name);
			statement.setString(3, answer);

			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}
}
