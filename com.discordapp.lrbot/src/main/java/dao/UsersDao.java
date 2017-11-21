package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import objects.UsersBo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import builder.UsersBoBuilder;
import util.MysqlConnectUtil;

/**
 * 
 * @author GOLIATH
 *
 */
public class UsersDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsersDao.class);

	public void create(final UsersBo usersBo) throws SQLException {
		PreparedStatement statement = null;
		try {
			Connection connection = MysqlConnectUtil.openConnection();
			statement = connection.prepareStatement("INSERT INTO `raidbot_users` (`role_id`, `discord_id`, `email`, `status`, `created`, `modified`) "
					+ " VALUES (?, ?, ?, ?, ?, ?)");

			statement.setLong(1, usersBo.getRole_id());
			statement.setLong(2, usersBo.getDiscord_id());
			statement.setString(3, usersBo.getEmail());
			statement.setLong(4, usersBo.getStatus());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			statement.setString(5, sdf.format(usersBo.getCreated()));
			statement.setString(6, sdf.format(usersBo.getModified()));
			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}
	
	public void updateRole(final UsersBo usersBo) throws SQLException {
		PreparedStatement statement = null;
		try {
			Connection connection = MysqlConnectUtil.openConnection();
			statement = connection.prepareStatement("UPDATE `raidbot_users` SET `role_id` = ?, `modified` = ? where `discord_id` = ? ");

			statement.setLong(1, usersBo.getRole_id());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			statement.setString(2, sdf.format(usersBo.getModified()));
			statement.setLong(3, usersBo.getDiscord_id());
			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}
	
	public UsersBo getByDiscordId(final Long discordId) throws SQLException {
		UsersBo usersBo = new UsersBo();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			Connection connection = MysqlConnectUtil.openConnection();
			statement = connection.prepareStatement("SELECT id,role_id,discord_id,email,notifications_cancel,notifications_new,notifications_validate,status,modified,created from `raidbot_users` where `discord_id` = ? ");
			statement.setLong(1, discordId);
			rs = statement.executeQuery();

			if(rs.next()) {
				usersBo = UsersBoBuilder.buildByResultSet(rs);
	        }
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
		}
		return usersBo;
	}
}
