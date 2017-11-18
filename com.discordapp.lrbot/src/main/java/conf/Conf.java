package conf;

import java.util.Map;

import util.PropertiesUtil;

/**
 * 
 * @author GOLIATH
 *
 */
public class Conf {

	public final static String discordToken;
	public final static String databaseServer;
	public final static String databasePort;
	public final static String databaseLogin;
	public final static String databasePassword;
	public final static String databaseScheme;
	
	public final static Long notificationRoleId;
	
	static {
		Map<String, String> botProperties = PropertiesUtil.initProps("config.properties");
		discordToken = botProperties.get("discord.token");
		databaseServer = botProperties.get("database.server");
		databasePort = botProperties.get("database.port");
		databaseLogin = botProperties.get("database.login");
		databasePassword = botProperties.get("database.password");
		databaseScheme = botProperties.get("database.schema");
		
		notificationRoleId = Long.valueOf(botProperties.get("discord.notification.role.id"));
	}
}
