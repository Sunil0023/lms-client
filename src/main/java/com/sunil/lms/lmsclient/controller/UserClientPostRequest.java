package com.sunil.lms.lmsclient.controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sunil.lms.lmsclient.model.User;

public class UserClientPostRequest {

  public static void main(String[] args) {

	try {
		
		//User user=new User(5, "Mahil", "mm", "rhl@gmail.com");

		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/saveUser");
		
		String userId="7";
		String userName="Avinash";
		String password="avi1234";
		String email="avi@gmail.com";

//		String input = "{\"userId\":4,\"username\":\"Amit\",\"password\":\"amit\",\"emailId\":\"amit@gmail.com\"}";

//		String input = "{\"userId\":userId,\"username\":userName,\"password\":password,\"emailId\":email}";
		
		MultivaluedMap formData = new MultivaluedMapImpl();
		  formData.add("userId", userId);
		  formData.add("username", userName);
		  formData.add("password", password);
		  formData.add("emailId", email);

//		ClientResponse response = webResource.type("application/json")
//		   .post(ClientResponse.class, formData);

			ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
		   .post(ClientResponse.class, formData);

		  
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);

	  } catch (Exception e) {

		e.printStackTrace();

	  }

	}
}
