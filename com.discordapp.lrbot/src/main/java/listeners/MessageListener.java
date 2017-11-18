package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
			event.getChannel().sendMessage("pong").complete();
		}
	}
}
