package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import objects.RolesBo;
import objects.UsersBo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.MysqlConnectUtil;
import builder.RolesBoBuilder;

/**
 * 
 * @author GOLIATH
 *
 */
public class RolesDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RolesDao.class);

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
	
	public RolesBo getById(final Long id) throws SQLException {
		RolesBo rolesBo = new RolesBo();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			Connection connection = MysqlConnectUtil.openConnection();
			statement = connection.prepareStatement("SELECT id,title,description,created,modified from `raidbot_roles` where `id` = ? ");
			statement.setLong(1, id);
			rs = statement.executeQuery();

			if(rs.next()) {
				rolesBo = RolesBoBuilder.buildByResultSet(rs);
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
		return rolesBo;
	}
	
	public RolesBo getByName(final String title) throws SQLException {
		RolesBo rolesBo = new RolesBo();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			Connection connection = MysqlConnectUtil.openConnection();
			statement = connection.prepareStatement("SELECT id, title, description, created, modified from `raidbot_roles` where `title` = ? ");
			statement.setString(1, title);
			rs = statement.executeQuery();

			if(rs.next()) {
				rolesBo = RolesBoBuilder.buildByResultSet(rs);
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
		return rolesBo;
	}
}
