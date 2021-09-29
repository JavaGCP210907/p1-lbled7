package com.revature.services;

import java.util.List;

import com.revature.daos.FinancialManagerDaoImpl;
import com.revature.models.Ticket;

public class FinancialManagerServiceImpl implements FinancialManagerService {

	FinancialManagerDaoImpl fDao = new FinancialManagerDaoImpl();
	
	@Override
	public List<Ticket> viewAllReimbursements() {
		return fDao.viewAllReimbursements();
		
	}

	@Override
	public boolean approveReimbursement(int id) {
		
		return fDao.approveReimbursement(id);
	}

	@Override
	public boolean denyReimbursement(int id) {
		
		return fDao.denyReimbursement(id);
	}

	@Override
	public List<Ticket> viewRequestByStatus(String status) {
		
		return fDao.viewRequestByStatus(status);
	}

}
