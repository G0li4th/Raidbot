package listeners;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import objects.UsersBo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;

import dao.UsersDao;

/**
 * 
 * @author GOLIATH
 *
 */
public class UserCreateListener extends ListenerAdapter {

	private final static Logger LOG = LoggerFactory.getLogger(UserCreateListener.class);

	public UserCreateListener() {
		super();
	}

	public void onMessageReceived(MessageReceivedEvent event) {
		LOG.info(event.getChannel().getName() + " - " + event.getAuthor().getName() + " - " + event.getMessage().getContent());
		if (event.getMessage() != null && event.getMessage().getContent() != null && event.getMessage().getContent().startsWith("!cuser")) {
			List<String> listDetailsUser = Splitter.on(" ").omitEmptyStrings().trimResults().splitToList(event.getMessage().getContent());
			if (listDetailsUser == null || listDetailsUser.size() != 2) {
				event.getChannel().sendMessage("usage: !cuser mail").complete();
				return;
			}
			
			UsersBo usersBo = new UsersBo();
			usersBo.setDiscord_id(event.getAuthor().getIdLong());
			usersBo.setEmail(listDetailsUser.get(1));
			usersBo.setRole_id(3L);
			usersBo.setStatus(1L);
			
			final Date currentDate = new Date();
			usersBo.setCreated(currentDate);
			usersBo.setModified(currentDate);
			
			UsersDao usersDao = new UsersDao();
			
			try {
				usersDao.create(usersBo);
				event.getChannel().sendMessage(event.getAuthor().getAsMention() + ": You have been added to RaidBot database...").complete();
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
				event.getChannel().sendMessage("FAIL: error while saving user: " + e.getMessage()).complete();
			}
		}
	}
}
