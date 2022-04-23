package com.sunil.lms.lmsclient.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.client.ClientConfig;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sunil.lms.lmsclient.model.User;
import com.sunil.lms.lmsclient.model.Users;

@Service
public class UsersFetchService {

	public List<User> getUserList(){

		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		WebTarget webTarget = client.target("http://localhost:8080").path("getUsers");

		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON).header("Authorization", "Basic c3VuaWw6c2FudQ==");
		Response response = invocationBuilder.get();

		Users users = response.readEntity(Users.class);
		List<User> listOfusers = users.getUsersList();

		System.out.println(response.getStatus());
		System.out.println(Arrays.toString( listOfusers.toArray(new User[listOfusers.size()]) ));

		return listOfusers;
	}


	public String getDownloadedFile() throws IOException{

		ClientConfig clientConfig = new ClientConfig();

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client.target("http://localhost:8080").path("downloadUsersFile");

		Invocation.Builder invocationBuilder =
				webTarget.request(MediaType.TEXT_PLAIN_TYPE);
		invocationBuilder.header("Authorization", "Basic c3VuaWw6c2FudQ==");

		File srcfile = invocationBuilder.get(File.class);

		//	HttpHeaders header=new HttpHeaders();
		//	String head =header.getRequestHeader("user-agent").get(0);

		System.out.println(srcfile);
		System.out.println(srcfile.getName());
		System.out.println(srcfile.getAbsoluteFile());

		//	String destination="F:\\Office Projects\\AMM New CR\\destDir\\"+srcfile.getName()+".csv";
		String destination="C:\\Sunil Data\\Personal\\Reading\\lmsclient_data\\destination\\UsersDestFile.csv";

		File desFile = new File(destination);

		checkExists(srcfile);
		checkExists(desFile);

		System.out.println("\nCopying " + srcfile.getName() + " to " + desFile.getName() + "\n");

		FileUtils.copyFile(srcfile, desFile);

		checkExists(srcfile);
		checkExists(desFile);
		return destination;
	}

	public static void checkExists(File file) {
		System.out.println(file.getName() + " exists: " + file.exists());
	}

	public User getUser(String userName) {
		System.out.println("in getUser(userName) method to search the user of UsersFetchService Class userName: "+userName);
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );

		WebTarget webTarget = client.target("http://localhost:8080").path("/getUser/{userName}")
				.resolveTemplate("userName", userName);//to set user variable and its value

		System.out.println("webTarget: "+webTarget); 

		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON).header("Authorization", "Basic c3VuaWw6c2FudQ==");
		Response response = invocationBuilder.get();
		System.out.println("Response: "+response);

		User user = response.readEntity(User.class);
		//List<User listOfusers = users.getUsersList();

		System.out.println(response.getStatus());
		System.out.println(user);

		return user;
	}
}