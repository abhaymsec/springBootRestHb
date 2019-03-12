package com.candidjava.client;

import java.io.File;
import java.net.URI;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.candidjava.spring.bean.User;
import com.candidjava.util.ResourceNotFoundException;

public class UserClient {
public final static String REST_URL = "";

/*Get all users: */
public List<User> listallUser(){
	RestTemplate rest = new RestTemplate();
	List<User> listUser = rest.getForObject(REST_URL+"/users", List.class);
	if(listUser !=null){
		for (User user : listUser) {
			System.out.println("ID:"+user.getId() +" Country: "+user.getCountry()+" Name: "+user.getCountry());
		}
		return listUser;
	}
	else{
		System.out.println("No user exist");
		throw new ResourceNotFoundException("Users Not exit.");
	}
}

/*Get user*/
public User getuser(String userId){
	RestTemplate rest =new RestTemplate();
	User user = rest.getForObject(REST_URL+"/user/"+userId, User.class);
	if(user !=null){
		return user;
	}
	else {
		throw new ResourceNotFoundException("User Not exit.");
	}
	
}

/*Create User*/
public void createUser(User user){
	RestTemplate rest = new RestTemplate();
	URI uri = rest.postForLocation(REST_URL+"/create", user,User.class);
	System.out.println("Uri for creates user is : "+uri.toASCIIString());
}
public static void main(String[] args) {
	String absltPath = new File(System.getProperty("user.dir")).getAbsolutePath();
	String relatvPath = System.getProperty("file.separator")+"src"+System.getProperty("file.separator")+"main"+System.getProperty("file.separator")+"java";
	System.out.println("System: "+ absltPath);
	System.out.println("complete path: "+absltPath+relatvPath);
}
}
