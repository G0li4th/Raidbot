import listeners.MessageListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import conf.Conf;

/**
 * 
 * @author GOLIATH
 *
 */
public class Main {
	
	private final static Logger LOG = LoggerFactory.getLogger(Main.class);

	public Long notifRoleId = 0L;
	
	public static void main(String[] args) {
		LOG.info("=======================================================");
		LOG.info("                     Le Refuge Bot                     ");
		LOG.info("=======================================================");

		try {
			JDA jda = new JDABuilder(AccountType.BOT).setToken(Conf.discordToken).addEventListener(new MessageListener()).setStatus(OnlineStatus.ONLINE).setGame(Game.of("Test...")).buildBlocking();
			
			LOG.info("Connecte avec: " + jda.getSelfUser().getName());
			LOG.info("Le bot est autorisé sur " + jda.getGuilds().size() + " serveur(s) : " + jda.getGuilds().toString());
		} catch(Exception e) {
			LOG.error("error: " + e.getMessage(), e);
			System.exit(-1);
		}
	}
}
