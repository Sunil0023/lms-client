package com.sunil.lms.lmsclient.controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sunil.lms.lmsclient.model.User;

public class PostUserClient {

	
	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		WebTarget webTarget = client.target("http://localhost:8080").path("saveUser");
		 
		User user=new User();
		user.setUserId(7);
		user.setUsername("Avinash");
		user.setEmailId("avi@gmail.com");
		user.setPassword("avi111");
		 
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		 
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
}
