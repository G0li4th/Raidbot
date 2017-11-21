package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import objects.RaidEventBo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.MysqlConnectUtil;

/**
 * 
 * @author GOLIATH
 *
 */
public class RaidEventsDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RaidEventsDao.class);

	public void create(final RaidEventBo raidEventBo) throws SQLException {
		Connection connection = MysqlConnectUtil.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("INSERT INTO `raidbot`.`raidbot_events` (`title`, `description`, `user_id`, `time_start`, `time_end`, `open`, `created`, `modified`) "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

			statement.setString(1, raidEventBo.getTitle());
			statement.setString(2, raidEventBo.getDescription());
			statement.setLong(3, raidEventBo.getUserId());
			statement.setDate(4, raidEventBo.getDateStart());
			statement.setDate(5, raidEventBo.getDateEnd());
			statement.setLong(6, raidEventBo.getOpen());

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
