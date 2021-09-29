package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.FinancialManagerController;
import com.revature.controllers.LoginController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		EmployeeController ec = new EmployeeController();
		LoginController lc = new LoginController();
		FinancialManagerController fmc = new FinancialManagerController();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("Conenction successful");
			System.out.println("Schema:"+conn.getSchema());
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		Javalin app = Javalin.create(config->{
			config.enableCorsForAllOrigins();}).start(8090);
		
		app.get("/tickets/",ec.viewAllTicketsHandler);
		
		app.post("/login/",lc.loginHandler);
		
		app.post("/addticket/",ec.addReimbursementRequestHandler);
		
		app.get("/managertickets/",fmc.viewAllReimbursementsHandler);
		
		app.put("/ticketsa/:id", fmc.approveReimbursementHandler);
		
		app.put("/ticketsd/:id", fmc.denyReimbursementHandler);
		
		app.get("tickets/:status", fmc.ticketsByStatusHandler);
	}
	
	
	
	
	
}
