package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import conf.Conf;

/**
 * 
 * @author GOLIATH
 *
 */
public class MessageListener extends ListenerAdapter {

	private final static Logger LOG = LoggerFactory.getLogger(MessageListener.class);

	public MessageListener() {
		super();
	}

	public void onMessageReceived(MessageReceivedEvent event) {
		LOG.info(event.getChannel().getName() + " - " + event.getAuthor().getName() + " - " + event.getMessage().getContent());
		if ("!ping".equalsIgnoreCase(event.getMessage().getContent())) {
			event.getChannel().sendTyping();
			event.getChannel().sendMessage(event.getJDA().getRoleById(Conf.notificationRoleId).getAsMention() + " Teeeeeeeeeest ! Mon ping est de " + event.getAuthor().getJDA().getPing() + "ms !")
					.complete();
		}
	}
}
