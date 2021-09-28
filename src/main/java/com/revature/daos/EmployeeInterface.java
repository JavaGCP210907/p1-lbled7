package com.revature.daos;

import java.util.List;

import com.revature.models.Ticket;

public interface EmployeeInterface {
	
	public List<Ticket> viewPastTicketsByEmployee(String userName);
	public boolean addReimbursementRequest(Ticket ticket);
}
