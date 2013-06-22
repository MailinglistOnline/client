package com.redhat.mailinglistOnline.jsf;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;



import com.redhat.mailinglistOnline.client.DbClient;
import com.redhat.mailinglistOnline.client.entities.User;




@ManagedBean(name="reg")
@ViewScoped
public class RegisterUser {

private String username;
private String password;
private String passwordAgain;

@Inject DbClient dbClient;

public String register() {
if(password.equals(passwordAgain)) {
if(dbClient.getUserByName(username) != null) {
User user = new User();
user.setName(username);
MessageDigest md = null;
try {
md = MessageDigest.getInstance("SHA-256");
md.update(password.getBytes("UTF-8"));
} catch (NoSuchAlgorithmException e) {
e.printStackTrace();
} catch (UnsupportedEncodingException e) {
e.printStackTrace();
}
String hashedPassword = new String(md.digest());
user.setPassword(hashedPassword);
List<String> roles = new ArrayList<String>();
roles.add("user");
user.setRoles(roles);
dbClient.saveUser(user);
}
}
return "home";
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public String getPasswordAgain() {
return passwordAgain;
}

public void setPasswordAgain(String passwordAgain) {
this.passwordAgain = passwordAgain;
}
}