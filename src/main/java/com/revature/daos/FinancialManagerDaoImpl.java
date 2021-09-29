package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Ticket;
import com.revature.utils.ConnectionUtil;

public class FinancialManagerDaoImpl implements FinancialManagerDao {

	@Override
	public List<Ticket> viewAllReimbursements() {
		try(Connection conn = ConnectionUtil.getConnection())
		{String sql = "select * FROM ers_reimbursement as reimb"
				+ " JOIN ers_reimbursement_type AS reimb_type"
				+ " ON reimb.reimb_type_id = reimb_type.reimb_type_id"
				+ " JOIN ers_reimbursement_status AS status"
				+ "	ON reimb.reimb_status_id = status.reimb_status_id order by reimb.reimb_id";
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		List<Ticket> ticketList = new ArrayList<>();
		while(rs.next()) {
			Ticket ticket = new Ticket();
			ticket.setId(rs.getInt(1));
			ticket.setReimb_amount(rs.getDouble(2));
			ticket.setReimb_submitted(rs.getString(3));
			ticket.setReimb_resolved(rs.getString(4));
			ticket.setReimb_description(rs.getString(5));
			ticket.setReimb_receipt(rs.getString(6));
			ticket.setReimb_type(rs.getString(12));
			ticket.setReimb_status(rs.getString(14));
			ticketList.add(ticket);
		}
		return ticketList;
		
		
		
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean approveReimbursement(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "update ers_reimbursement set reimb_status_id = 2 "
					+ "where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean denyReimbursement(int id) {
try(Connection conn = ConnectionUtil.getConnection()){
	String sql = "update ers_reimbursement set reimb_status_id = 3 "
			+ "where reimb_id = ?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1, id);
	ps.executeUpdate();
	return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Ticket> viewRequestByStatus(String status) {
try(Connection conn = ConnectionUtil.getConnection()){
	String sql  = "select * from ers_reimbursement as reimb"
			+ " JOIN ers_reimbursement_type AS reimb_type"
			+ " ON reimb.reimb_type_id = reimb_type.reimb_type_id"
			+ " JOIN ers_reimbursement_status AS status"
			+ "	ON reimb.reimb_status_id = status.reimb_status_id"
			+ " where reimb_status=?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, status);
	ResultSet rs = ps.executeQuery();
	List<Ticket> ticketList = new ArrayList<>();
	while(rs.next()) {
		Ticket ticket = new Ticket();
		ticket.setId(rs.getInt(1));
		ticket.setReimb_amount(rs.getDouble(2));
		ticket.setReimb_submitted(rs.getString(3));
		ticket.setReimb_resolved(rs.getString(4));
		ticket.setReimb_description(rs.getString(5));
		ticket.setReimb_receipt(rs.getString(6));
		ticket.setReimb_type(rs.getString(12));
		ticket.setReimb_status(rs.getString(14));
		ticketList.add(ticket); 
	}
	return ticketList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
