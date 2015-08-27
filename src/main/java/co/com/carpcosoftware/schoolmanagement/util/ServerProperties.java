/**
 * 
 */
package co.com.carpcosoftware.schoolmanagement.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Carlos Andres Rodriguez
 * @version 1.0
 * @since 09/03/2015
 */
public class ServerProperties extends Properties {
	
	/**
	 * Logger instance
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerProperties.class);

	/**
	 * Auto generated serial version
	 */
	private static final long serialVersionUID = 2238009377057310242L;
	
	/**
	 * Property file name
	 */
	private static final String PROPERTY_FILE = "/server.properties";
	
	/**
	 * Server port
	 */
	private static final String PORT = "port";
	
	/**
	 * Package key
	 */
	private static final String PACKAGE_KEY = "package_key";
	
	/**
	 * Package key default value
	 */
	private static final String PACKAGE_KEY_DEFAULT = "com.sun.jersey.config.property.packages";
	
	/**
	 * Package value
	 */
	private static final String PACKAGE_VALUE = "package_value";
	
	/**
	 * Package value default value
	 */
	private static final String PACKAGE_VALUE_DEFAULT = "co.com.carpcosoftware.schoolmanagement.request";
	
	/**
	 * Instance from {@link ServerProperties}
	 */
	private static ServerProperties instance;
	
	/**
	 * Server properties constructor
	 */
	private ServerProperties() {
		super();
		
		try (InputStream input = ServerProperties.class.getResourceAsStream(PROPERTY_FILE)) {
			if (input != null) {
				LOGGER.info("Loading properties from {} file", PROPERTY_FILE);
				this.load(input);
			}
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage());
		}
	}
	
	/**
	 * Gets {@link ServerProperties} instance
	 * @return
	 */
	public static ServerProperties getInstance() {
		if (instance == null) {
			LOGGER.info("Creating a new instance of ServerProperties class");
			
			instance = new ServerProperties();
		}
		return instance;
	}
	
	/**
	 * Gets server port number
	 * @return Port number
	 */
	public int getPort() {
		int port = 1517;
		if (this.containsKey(PORT)) {
			port = Integer.parseInt(this.getProperty(PORT));
			
			LOGGER.info("Server port {} successfully loaded from {} file", port, PROPERTY_FILE);
		}
		return port;
	}
	
	/**
	 * Gets package key
	 * @return Package key
	 */
	public String getPackageKey() {
		String packageKey = this.getProperty(PACKAGE_KEY, PACKAGE_KEY_DEFAULT);
		
		LOGGER.info("Property {} loaded with value {}", PACKAGE_KEY, packageKey);
		
		return packageKey;
	}
	
	/**
	 * Gets package value
	 * @return Package value
	 */
	public String getPackageValue() {
		String packageValue = this.getProperty(PACKAGE_VALUE, PACKAGE_VALUE_DEFAULT); 
		
		LOGGER.info("Property {} loaded with value {}", PACKAGE_VALUE, packageValue);
		
		return packageValue;
	}
}