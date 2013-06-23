package com.redhat.mailinglistOnline.client;



import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import com.redhat.mailinglistOnline.client.entities.User;


@Stateful(name="userSession")
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
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.xhtml?faces-redirect=true";
	}
	
}
	


