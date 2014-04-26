package com.redhat.mailinglistOnline.client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.redhat.mailinglistOnline.client.entities.User;


@Stateless(name="dbClient")
public class DbClient {

	  private static String DATABASE_PROPERTIES_FILE_NAME = "userDatabase.properties";
	    
	    DBCollection coll;
	    MongoClient mongoClient;

	    public DbClient() throws UnknownHostException, IOException {
	        Properties prop = new Properties();
	        prop.load(DbClient.class.getClassLoader().getResourceAsStream((DATABASE_PROPERTIES_FILE_NAME)));
	        Integer defaultPort = Integer.valueOf(prop.getProperty("defaultMongoPort"));
	        String databaseUrl = prop.getProperty("defaultMongoUrl");
	        String defaultDatabaseName = prop.getProperty("defaultDatabaseName");
	        String defaultCollectionName = prop.getProperty("defaultCollection");
	        String user = prop.getProperty("user");
	        String password = prop.getProperty("password");
	        connect(databaseUrl, defaultDatabaseName, defaultPort, defaultCollectionName,user,password);

	    }
	    
	    
	    private void connect(String mongoUrl, String databaseName, int mongoPort, String collectionName, String user, String password) throws UnknownHostException {
	        mongoClient = new MongoClient(mongoUrl, mongoPort);
	        DB db = mongoClient.getDB(databaseName);
	        if(user != null && password != null) {
	        	db.authenticate(user, password.toCharArray());
	        }
	        mongoClient.setWriteConcern(WriteConcern.SAFE);
	        coll = db.getCollection(collectionName);
	        coll.setObjectClass(User.class);
	    }
	    
	    public void closeConnection() {
	        mongoClient.close();
	    }
	    
	    public User getUserByName(String name) {
	        BasicDBObject nameObj = new BasicDBObject(User.ROOT_NAME_TAG, name);
	        User user = (User)coll.findOne(nameObj);
	        return user;
	    }
	    

		public boolean saveUser(User user) {
	        coll.insert(user);
	        return true;
		}
	
}
