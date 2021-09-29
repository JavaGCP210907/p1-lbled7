package com.revature.models;

import java.sql.Date;
import java.time.LocalDate;

public class Ticket {
	private int id;
	private double reimb_amount;
	private String reimb_submitted;
	private String reimb_resolved;
	private String reimb_description;
	private String reimb_receipt;
	private String reimb_status;
	private String reimb_type;
	
	public Ticket(double reimb_amount, String reimb_submitted, String reimb_resolved, String reimb_description,
			String reimb_receipt, String reimb_status, String reimb_type) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getStatusId() {
		if(this.reimb_status.toLowerCase().equals("lodging"))
			return 1;
		if(this.reimb_status.toLowerCase().equals("travel"))
			return 2;
		if(this.reimb_status.toLowerCase().equals("food"))
			return 3;
		if(this.reimb_status.toLowerCase().equals("other"))
			return 4;
		return 0;
	}
	public int getTypeId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimb_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reimb_description == null) ? 0 : reimb_description.hashCode());
		result = prime * result + ((reimb_receipt == null) ? 0 : reimb_receipt.hashCode());
		result = prime * result + ((reimb_resolved == null) ? 0 : reimb_resolved.hashCode());
		result = prime * result + ((reimb_status == null) ? 0 : reimb_status.hashCode());
		result = prime * result + ((reimb_submitted == null) ? 0 : reimb_submitted.hashCode());
		result = prime * result + ((reimb_type == null) ? 0 : reimb_type.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (Double.doubleToLongBits(reimb_amount) != Double.doubleToLongBits(other.reimb_amount))
			return false;
		if (reimb_description == null) {
			if (other.reimb_description != null)
				return false;
		} else if (!reimb_description.equals(other.reimb_description))
			return false;
		if (reimb_receipt == null) {
			if (other.reimb_receipt != null)
				return false;
		} else if (!reimb_receipt.equals(other.reimb_receipt))
			return false;
		if (reimb_resolved == null) {
			if (other.reimb_resolved != null)
				return false;
		} else if (!reimb_resolved.equals(other.reimb_resolved))
			return false;
		if (reimb_status == null) {
			if (other.reimb_status != null)
				return false;
		} else if (!reimb_status.equals(other.reimb_status))
			return false;
		if (reimb_submitted == null) {
			if (other.reimb_submitted != null)
				return false;
		} else if (!reimb_submitted.equals(other.reimb_submitted))
			return false;
		if (reimb_type == null) {
			if (other.reimb_type != null)
				return false;
		} else if (!reimb_type.equals(other.reimb_type))
			return false;
		return true;
	}
	


	public Ticket(double reimb_amount, String reimb_description, String reimb_receipt, String reimb_type) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = String.valueOf(LocalDate.now());
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_status = "Pending";
		this.reimb_type = reimb_type;
	}

	public Ticket(double reimb_amount, String reimb_submitted, LocalDate reimb_resolved, String reimb_description,
			String reimb_receipt, String reimb_type) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted =String.valueOf(LocalDate.now());
		this.reimb_resolved = null;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_status = "Pending";
		this.reimb_type = reimb_type;
	}




	@Override
	public String toString() {
		return "Ticket [reimb_amount=" + reimb_amount + ", reimb_submitted=" + reimb_submitted + ", reimb_resolved="
				+ reimb_resolved + ", reimb_description=" + reimb_description + ", reimb_receipt=" + reimb_receipt
				+ ", reimb_status=" + reimb_status + ", reimb_type=" + reimb_type + "]";
	}
	
	
	public double getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public String getReimb_submitted() {
		return reimb_submitted;
	}
	public void setReimb_submitted(String reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}
	public String getReimb_resolved() {
		return reimb_resolved;
	}
	public void setReimb_resolved(String reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}
	public String getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}
	public String getReimb_receipt() {
		return reimb_receipt;
	}
	public void setReimb_receipt(String reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}
	public String getReimb_status() {
		return reimb_status;
	}
	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}
	public String getReimb_type() {
		return reimb_type;
	}
	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
}

	