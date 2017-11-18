package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

/**
 * 
 * @author GOLIATH
 *
 */
public class PropertiesUtil {

	private final static Logger LOG = LoggerFactory.getLogger(PropertiesUtil.class);

	public static Map<String, String> initProps(final String filename) {
		final Properties properties = new Properties();
		final InputStream configInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);

		synchronized (configInputStream) {
			try {
				if (configInputStream != null) {
					properties.load(configInputStream);
				}
				return Maps.fromProperties(properties);
			} catch (final IOException ioe) {
				LOG.error(ioe.getMessage());
			} finally {
				if (configInputStream != null) {
					try {
						configInputStream.close();
					} catch (Exception e) {
						;
					}
				}
			}
		}
		return null;
	}
}
