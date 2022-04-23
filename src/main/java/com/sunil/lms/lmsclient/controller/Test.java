package com.sunil.lms.lmsclient.controller;

import java.io.IOException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.apache.http.client.ClientProtocolException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class Test {
 public static void main(String[] args) throws ClientProtocolException, IOException {
  ClientConfig config = new DefaultClientConfig();
  Client client = Client.create(config);
  WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/saveUser").build());
  
  	String userId="7";
	String userName="Avinash";
	String password="avi1234";
	String email="avi@gmail.com";
	
	
  Form formData = new Form();
  
  formData.add("userId", userId);
  formData.add("username", userName);
  formData.add("password", password);
  formData.add("emailId", email);
  
  ClientResponse response = service.path("http://localhost:8080").path("saveUser").
  type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, formData);
  
  if (response.getStatus() != 200) {
		throw new RuntimeException("Failed : HTTP error code : "
		     + response.getStatus());
	}
  System.out.println("Response " + response.getEntity(String.class));
 
 }
}