package builder;

import java.sql.ResultSet;
import java.sql.SQLException;

import objects.UsersBo;

public class UsersBoBuilder {

	public static UsersBo buildByResultSet(final ResultSet rs) throws SQLException {
		UsersBo usersBo = new UsersBo();
    	usersBo.setCreated(rs.getDate("created"));
    	usersBo.setModified(rs.getDate("modified"));
    	usersBo.setStatus(rs.getLong("status"));
    	usersBo.setNotifications_validate(rs.getLong("notifications_validate"));
    	usersBo.setNotifications_new(rs.getLong("notifications_new"));
    	usersBo.setNotifications_cancel(rs.getLong("notifications_cancel"));
    	usersBo.setEmail(rs.getString("email"));
    	usersBo.setDiscord_id(rs.getLong("discord_id"));
    	usersBo.setRole_id(rs.getLong("role_id"));
    	usersBo.setId(rs.getLong("id"));
		
    	return usersBo;
	}
}
