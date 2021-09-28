package com.revature.controllers;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;
import com.revature.utils.JwtUtil;

import io.javalin.http.Handler;

public class LoginController {

	LoginService ls = new LoginService();
	
	public Handler loginHandler = (ctx) -> {
	
		String body = ctx.body(); //turn the data of the POST request into a Java string
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); //turn that JSON string into a LoginDTO object
		
		//control flow to determine what happens in the event of a successful/unsuccessful login
		
		
		//invoke the login() method of LoginService using the username and password of the newly created DTO
		if(ls.login(LDTO.getUsername(), LDTO.getPassword())) {
			//grant the user some privileges
			//generate a JSON web token to uniquely identify the user
			String jwt = JwtUtil.generate(LDTO.getUsername(), LDTO.getPassword());
			
			//create a user session
			HttpSession session = ctx.req.getSession();//req is a "Request Object", we establish sessions through it
			session.setAttribute("username",LDTO.getUsername());
			//successful status code
			ctx.status(200);
			ctx.result("Login Success, JWT is: "+ jwt);
			
		} else {
			
			ctx.status(401); //unauthorized status code
			ctx.result("Login Failed! :(");
		}
		
		//making a LoginDTO will get back to you...
};

}