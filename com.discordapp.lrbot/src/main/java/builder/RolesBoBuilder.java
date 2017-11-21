package builder;

import java.sql.ResultSet;
import java.sql.SQLException;

import objects.RolesBo;

public class RolesBoBuilder {

	public static RolesBo buildByResultSet(final ResultSet rs) throws SQLException {
		RolesBo rolesBo = new RolesBo();
		rolesBo.setCreated(rs.getDate("created"));
		rolesBo.setModified(rs.getDate("modified"));
		rolesBo.setDescription(rs.getString("description"));
		rolesBo.setTitle(rs.getString("title"));
		rolesBo.setId(rs.getLong("id"));
    	return rolesBo;
	}
}
