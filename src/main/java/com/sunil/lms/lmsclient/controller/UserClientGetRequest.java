package com.sunil.lms.lmsclient.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sunil.lms.lmsclient.model.User;


public class UserClientGetRequest {
	
	public static void main(String[] args) {
	
	try {
		
		
		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/getUsers");

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);

		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}catch (Exception e) {

		e.printStackTrace();

	}
}
}
