package com.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class ConfigurationProperties {

	private static final Log logger = LogFactory.getLog(ConfigurationProperties.class);

	private static Environment prop;
	
	public static String getConfigValue(String key) throws IOException {
		String value = null;
		if (prop == null) {
			prop = Application.ctx.getBean(Environment.class);
		}
		if (prop.getProperty(key) != null) {
			value = prop.getProperty(key).trim();
		}
		if (value == null && System.getenv(key) != null) {
			value = System.getenv(key).trim();
		}
		return value;
	}

	public static Map<String, Object> getAllKnownProperties() {
		Gson gson = new Gson();
		if (prop == null) {
			prop = Application.ctx.getBean(Environment.class);
		}
		Map<String, Object> rtn = new HashMap<>();
		if (prop instanceof ConfigurableEnvironment) {
			for (PropertySource<?> propertySource : ((ConfigurableEnvironment) prop).getPropertySources()) {
				if (propertySource instanceof EnumerablePropertySource) {
					for (String key : ((EnumerablePropertySource) propertySource).getPropertyNames()) {
						rtn.put(key, propertySource.getProperty(key));
					}
				}
			}
		}

		logger.error("Logger from ConfigurableEnvironment:" + gson.toJson(rtn));
		if(!rtn.containsKey("ENDPOINT_DASHBOARD")) {
			Map<String, String> env = System.getenv();
			for (String envName : env.keySet()) {
				if(envName.startsWith("ENDPOINT")) {
					rtn.put(envName.trim(), env.get(envName).trim());
				}
			}
		}
		logger.error("Logger from System.getenv():" + gson.toJson(rtn));
		logger.error("Exit from getAllKnownProperties and return values are:" + gson.toJson(rtn));
		return rtn;
	}
}