package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Ticket;
import com.revature.services.EmployeeServiceImpl;

import io.javalin.http.Handler;

public class EmployeeController {

	
	EmployeeServiceImpl es = new EmployeeServiceImpl();
	public Handler viewAllTicketsHandler = 
			(ctx) ->  {
				
				if(ctx.req.getSession(false)!=null) {
					String userName = ctx.attribute("userName");
					List<Ticket> ticketList = es.viewPastTicketsByEmployee(userName);
					if(ticketList.isEmpty()) {
						ctx.result("No tickets found!");
						ctx.status(404);
					}
					else {
						Gson gson = new Gson();
						String JSONTickets = gson.toJson(ticketList);
						ctx.result(JSONTickets);
						ctx.status(200);
						
					}
					
					
				}
				else {
					ctx.status(403);
				}
			
};
}
