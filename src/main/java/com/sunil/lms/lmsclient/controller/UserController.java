package com.sunil.lms.lmsclient.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunil.lms.lmsclient.model.User;
import com.sunil.lms.lmsclient.model.Users;
import com.sunil.lms.lmsclient.service.UserSignUpService;
import com.sunil.lms.lmsclient.service.UsersFetchService;

@Controller
public class UserController {

	private static Logger logger = LogManager.getLogger();

	@Autowired
	private UserSignUpService userSignUpService;

	@Autowired
	private UsersFetchService usersFetchService;

	@RequestMapping(value="/userSignUp",method=RequestMethod.GET)
	public String userSignUp(ModelMap model) {
		return "userSignUp";
	}

	@RequestMapping(value="/userSignUp",method=RequestMethod.POST)
	public String creatUser(ModelMap model,@RequestParam Integer UserId,@RequestParam String UserName,@RequestParam String password,@RequestParam String EmailId) {

		boolean isUserCreated=userSignUpService.createUser(UserId,UserName,password,EmailId);
		System.out.println("Inside userSignup");
		logger.info("isUserCreated:"+isUserCreated);
		logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
		

		if(!isUserCreated)
		{
			model.put("errorMessage", "Invalid Credential");
			return "userSignUp";
		}

		model.put("User", UserName);

		return "userCreated";
	}

	@RequestMapping(value="/usersList",method=RequestMethod.GET)
	public String getAllUsers(ModelMap model){

		List<User> userList=new ArrayList<User>();
		List<User> users=usersFetchService.getUserList();
		
		logger.info("users:"+users);
		
		logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");

		User user=new User();

		for(User usr:users) {
			System.out.println(usr.getUserId()+" "+usr.getUsername()+" "+usr.getEmailId());
			logger.info(usr.getUserId()+" "+usr.getUsername()+" "+usr.getEmailId());
			//userList.add(usr);
			user.setUserId(usr.getUserId());
			user.setUsername(usr.getUsername());
			user.setEmailId(usr.getEmailId());
			userList.add(user);

			model.put("userId", usr.getUserId());
			model.put("userName", usr.getUsername());
			model.put("userEmail", usr.getEmailId());
		}

		model.put("users", users);

		return "usersList";
	}

	@RequestMapping(value="/downloadUsers",method=RequestMethod.GET)
	public String downloadUsersFile(ModelMap model) throws IOException
	{
		String downloadLocation=usersFetchService.getDownloadedFile();

		System.out.println("File is downloaded at location: "+downloadLocation);

		model.put("downloadlocation", downloadLocation);

		return "usersList";
	}


	@RequestMapping(value="/searchUser",method=RequestMethod.GET)
	public String userSearch(ModelMap model) {
		return "searchUser";
	}

	@RequestMapping(value="/searchUser",method=RequestMethod.POST)
	public String searchUser(ModelMap model,@RequestParam String userName) {
		System.out.println("userName: "+userName);
		User user=usersFetchService.getUser(userName);

		if(user!=null)
		{
			model.put("user", user);
		}else {
			model.put("noData", "Data not found for this User Name");
		}
		return "searchUser";
	}

	//		@RequestMapping(value="/source",method=RequestMethod.GET)
	@GetMapping("/source")
	public String sourcePath(ModelMap model) {
		return "source";
	}
}
