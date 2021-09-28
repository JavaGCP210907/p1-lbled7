package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.EmployeeController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		EmployeeController ec = new EmployeeController();
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("Conenction successful");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		Javalin app = Javalin.create(config->{
			config.enableCorsForAllOrigins();}).start(8090);
		
		app.get("/tickets/",ec.viewAllTicketsHandler);
	}
	
	
	
	
	
}
