package com.sunil.lms.lmsclient.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sunil.lms.lmsclient.model.User;

@Service
public class UserSignUpService {

	
	public boolean createUser(Integer userId, String userName, String password, String emailId) {
		
		boolean isUserCreated=false;
		
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		WebTarget webTarget = client.target("http://localhost:8080").path("saveUser");
		 
		User user=new User();
		user.setUserId(userId);
		user.setUsername(userName);
		user.setEmailId(emailId);
		user.setPassword(password);
		 
//		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON).header("Authorization", "Basic c3VuaWw6c2FudQ==");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		
		if(response.getStatus()==200) {
			isUserCreated=true;
		}
		
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
		return isUserCreated;
		
	}
	
}
