package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Ticket;
import com.revature.utils.ConnectionUtil;

public class EmployeeDao implements EmployeeInterface {

	@Override
	public List<Ticket> viewPastTicketsByEmployee(String userName){
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_reimbursement as reimb join users as" 
					+ " users on reimb.reimb_author = users.ers_users_id"
					 + " JOIN ers_reimbursement_type AS reimb_type"
					 + " ON reimb.reimb_type_id = reimb_type.reimb_type_id"
					 +  " JOIN ers_reimbursement_status AS status"
					 + " ON reimb.reimb_status_id = status.reimb_status_id"
					 + " where users.ers_username = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			List<Ticket> ticketList = new ArrayList<>();
			while(rs.next()) {
				Ticket t =  new Ticket(
						rs.getDouble(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(21),
						rs.getString(19));
				ticketList.add(t);
			}
			if(ticketList.isEmpty())
				System.out.println("No Tickets Found");
			return ticketList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addReimbursementRequest(Ticket ticket) {
try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into ers_reimbursement (reimb_amount,reimb_submitted,"
					+ "reimb_description,reimb_receipt,reimb_status,reimb_type"
					+ "values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, ticket.getReimb_amount());
			ps.setString(2, String.valueOf(ticket.getReimb_submitted()));
			ps.setString(3, ticket.getReimb_description());
			ps.setString(4,ticket.getReimb_receipt());
			ps.setInt(5, 1);
			ps.setInt(6, ticket.getTypeId());
			ps.executeUpdate();
			System.out.println("Ticket added successfully");
			return true;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
