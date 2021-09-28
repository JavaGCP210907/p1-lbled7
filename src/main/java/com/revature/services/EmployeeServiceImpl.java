package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.models.Ticket;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao eDao = new EmployeeDao();
	
	@Override
	public List<Ticket> viewPastTicketsByEmployee(String userName){
		return eDao.viewPastTicketsByEmployee(userName);
		
	}

	@Override
	public boolean addReimbursementRequest(Ticket ticket) {
		
		return eDao.addReimbursementRequest(ticket);
	}
}
