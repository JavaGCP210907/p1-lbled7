package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Ticket;
import com.revature.services.FinancialManagerServiceImpl;

import io.javalin.http.Handler;

public class FinancialManagerController {

	private FinancialManagerServiceImpl fmService = new FinancialManagerServiceImpl();
	
	public Handler viewAllReimbursementsHandler = (ctx) -> {
		
		if(ctx.req.getSession(false)!=null && (boolean)ctx.req.getSession().getAttribute("manager")) {
			
			List<Ticket> ticketList = fmService.viewAllReimbursements();
			
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
		
	public Handler approveReimbursementHandler = (ctx) -> {
		
		if(ctx.req.getSession(false)!= null && (boolean)ctx.req.getSession().getAttribute("manager")) {
			int id = Integer.parseInt(ctx.pathParam("id"));
			fmService.approveReimbursement(id);
			ctx.result("Reimbursement "+id+" approved successfully");
			ctx.status(200);
		}
		else {
			ctx.status(403);
		}
	};
public Handler denyReimbursementHandler = (ctx) -> {
		
		if(ctx.req.getSession(false)!= null && (boolean)ctx.req.getSession().getAttribute("manager")) {
			int id = Integer.parseInt(ctx.pathParam("id"));
			fmService.denyReimbursement(id);
			ctx.result("Reimbursement"+id+"denied successfully");
			ctx.status(200);
			
		}
		else {
			ctx.status(403);
			
		}
	};

public Handler ticketsByStatusHandler = (ctx) -> {
	
	if(ctx.req.getSession(false)!= null && (boolean)ctx.req.getSession().getAttribute("manager")) {
		String statusTemp = (ctx.pathParam("status").toString());
		String status = statusTemp.substring(0,1).toUpperCase()+statusTemp.substring(1);
		List<Ticket> ticketListByStatus = fmService.viewRequestByStatus(status);
		System.out.println(status);
		if(ticketListByStatus.isEmpty()) {
			ctx.result("No tickets found!");
			ctx.status(404);
		}
		else {
			Gson gson = new Gson();
			String JSONTickets = gson.toJson(ticketListByStatus);
			ctx.result(JSONTickets);
			ctx.status(200);
		}
	}
	else {
		ctx.status(403);
	}
};
		
		
		
	}

