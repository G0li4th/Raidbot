package listeners;

import java.util.List;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;

import conf.Conf;
import dao.RaidEventsDao;

/**
 * 
 * @author GOLIATH
 *
 */
public class RaidCreateListener extends ListenerAdapter {

	private final static Logger LOG = LoggerFactory.getLogger(RaidCreateListener.class);

	public RaidCreateListener() {
		super();
	}

	public void onMessageReceived(MessageReceivedEvent event) {
		LOG.info(event.getChannel().getName() + " - " + event.getAuthor().getName() + " - " + event.getMessage().getContent());
		if ("!cevent".equalsIgnoreCase(event.getMessage().getContent())) {
			List<String> listDetailsRaid = Splitter.on(" ").omitEmptyStrings().trimResults().splitToList(event.getMessage().getContent());
			
			RaidEventsDao raidEventsDao = new RaidEventsDao();
			raidEventsDao.create();
			
			event.getChannel().sendTyping();
			event.getChannel().sendMessage(event.getJDA().getRoleById(Conf.notificationRoleId).getAsMention() + " Nouvel event créé")
					.complete();
		}
	}
}
