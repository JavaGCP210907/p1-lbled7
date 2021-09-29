package com.revature.daos;

import java.util.List;

import com.revature.models.Ticket;

public interface FinancialManagerDao {
		
	List<Ticket> viewAllReimbursements();
	boolean approveReimbursement(int id);
	boolean denyReimbursement(int id);
	List<Ticket> viewRequestByStatus(String status);
}
