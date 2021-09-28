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
	
		String body = ctx.body(); 
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); 
		
		
		
		
		if(ls.login(LDTO.getUsername(), LDTO.getPassword())) {
			
			String jwt = JwtUtil.generate(LDTO.getUsername(), LDTO.getPassword());
			
			HttpSession session = ctx.req.getSession();
			session.setAttribute("username",LDTO.getUsername());
			//successful status code
			ctx.status(200);
			ctx.result("Login Success, JWT is: "+ jwt);
			
		} else {
			
			ctx.status(401); //unauthorized status code
			ctx.result("Login Failed!");
		}
		
};

}