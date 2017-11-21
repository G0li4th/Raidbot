package listeners;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import objects.RolesBo;
import objects.UsersBo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;

import dao.RolesDao;
import dao.UsersDao;

/**
 * 
 * @author GOLIATH
 *
 */
public class UserPromoteListener extends ListenerAdapter {

	private final static Logger LOG = LoggerFactory.getLogger(UserPromoteListener.class);

	public UserPromoteListener() {
		super();
	}

	public void onMessageReceived(MessageReceivedEvent event) {
		LOG.info(event.getChannel().getName() + " - " + event.getAuthor().getName() + " - " + event.getMessage().getContent());
		if (event.getMessage() != null && event.getMessage().getContent() != null && event.getMessage().getContent().startsWith("!promote")) {
			List<String> listDetailsUser = Splitter.on(" ").omitEmptyStrings().trimResults().splitToList(event.getMessage().getRawContent());
			if (listDetailsUser == null || listDetailsUser.size() != 3) {
				event.getChannel().sendMessage("usage: !promote @User role").complete();
				return;
			}
			if (event.getMessage().getMentionedUsers() == null || event.getMessage().getMentionedUsers().size() != 1) {
				event.getChannel().sendMessage("usage: !promote @User role").complete();
				return;
			}

			try {
				UsersDao usersDao = new UsersDao();
				RolesDao rolesDao = new RolesDao();

				// 0. Check command user
				UsersBo requestorUserBo = usersDao.getByDiscordId(event.getAuthor().getIdLong());
				if (requestorUserBo != null && requestorUserBo.getRole_id() != 1) {
					event.getChannel().sendMessage("You are not authorized to do that !").complete();
					return;
				}
				
				// 1. Retrieve User account
				UsersBo userBo = usersDao.getByDiscordId(event.getMessage().getMentionedUsers().get(0).getIdLong());

				// 2. Retrieve Role
				RolesBo roleBo = rolesDao.getByName(listDetailsUser.get(2));

				// 3. Edit User
				userBo.setRole_id(roleBo.getId());
				userBo.setModified(new Date());

				usersDao.updateRole(userBo);
				event.getChannel().sendMessage(event.getAuthor().getAsMention() + ": You have been promoted to rank " + listDetailsUser.get(2)).complete();
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
				event.getChannel().sendMessage("FAIL: error while saving user: " + e.getMessage()).complete();
			}
		}
	}
}
