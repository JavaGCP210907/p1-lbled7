package com.revature.services;

import java.util.List;

import com.revature.models.Ticket;

public interface FinancialManagerService {
	List<Ticket> viewAllReimbursements();
	boolean approveReimbursement(int id);
	boolean denyReimbursement(int id);
	List<Ticket> viewRequestByStatus(String status);
}
