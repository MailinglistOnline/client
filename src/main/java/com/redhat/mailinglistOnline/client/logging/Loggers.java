package com.redhat.mailinglistOnline.client.logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Properties;
import java.util.logging.FileHandler;

import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.redhat.mailinglistOnline.client.DbClient;



@Singleton
public class Loggers {
	
	FileHandler fh;
	
	public Loggers() throws SecurityException, IOException {
		//fh = new FileHandler("mailinglistOnline-client.log",8096, 1, true); 
	}
	
	@Produces
	public Logger getLogger(InjectionPoint ip) throws IOException {
		Properties props = new Properties();
		//props.load(new FileInputStream("log4j.properties")); islo by?
		props.load(Loggers.class.getClassLoader().getResourceAsStream(("log4j.properties")));
		PropertyConfigurator.configure(props);
		Member member = ip.getMember();
		Class<?> declaredInClass=member.getDeclaringClass();
		Logger logger=Logger.getLogger(declaredInClass.getSimpleName());
		
		return logger;
	}
}
