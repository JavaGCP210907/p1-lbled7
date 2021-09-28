package com.revature.services;

import java.util.List;

import com.revature.models.Ticket;

public interface EmployeeService {

	public List<Ticket> viewPastTicketsByEmployee(String userName);
	public boolean addReimbursementRequest(Ticket ticket);
}
