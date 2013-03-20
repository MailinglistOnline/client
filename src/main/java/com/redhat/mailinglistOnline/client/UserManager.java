package com.redhat.mailinglistOnline.client;



import javax.inject.Inject;
import com.redhat.mailinglistOnline.client.entities.User;

public class UserManager {
	
	@Inject
	private DbClient dbClient;
	
	
	public UserManager() {
	}
		
	public boolean createUser(User user) {
		if(dbClient.getUserByName(user.getName()) != null) {
			dbClient.saveUser(user);
			return true;
		} else {
			return false;
		}
	}
	
	public User getUserByName(String name) {
		return dbClient.getUserByName(name);
	}
	
}
	


