package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class LoginDao {
	
	public boolean validateLogin(String username, String password) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select ers_password from users where ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if(password.equals(rs.getString(1))){
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkManager(String username) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select user_role_id from users where ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if(rs.getInt(1)==2) {
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
