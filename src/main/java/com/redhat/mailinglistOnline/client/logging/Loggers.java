package com.redhat.mailinglistOnline.client.logging;


import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Properties;


import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


@Stateless
public class Loggers {
	
	@Produces
	public Logger getLogger(InjectionPoint ip) throws IOException {
		Member member = ip.getMember();
		Class<?> declaredInClass=member.getDeclaringClass();
		Logger logger=Logger.getLogger(declaredInClass.getSimpleName());
		Properties props = new Properties();
		props.load(Loggers.class.getClassLoader().getResourceAsStream(("log4j.properties")));
		PropertyConfigurator.configure(props);
		logger.info("should be in the file but is not");
		return logger;
	}
}
