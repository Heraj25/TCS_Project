package com.database;

public class Employee {
	private String E_Id, E_fname, E_lname, E_email, E_password, E_cpassword, E_address, E_contact;
	
	public Employee(String E_Id, String E_fname, String E_lname, String E_email, String E_password, String E_cpassword, String E_address, String E_contact){
		this.E_Id=E_Id;
		this.E_fname=E_fname;
		this.E_lname=E_lname;
		this.E_email=E_email;
		this.E_password=E_password;
		this.E_cpassword=E_cpassword;
		this.E_address=E_address;
		this.E_contact=E_contact;
	}

	public String getE_Id() {
		return E_Id;
	}

	public void setE_Id(String e_Id) {
		E_Id = e_Id;
	}

	public String getE_fname() {
		return E_fname;
	}

	public void setE_fname(String e_fname) {
		E_fname = e_fname;
	}

	public String getE_lname() {
		return E_lname;
	}

	public void setE_lname(String e_lname) {
		E_lname = e_lname;
	}

	public String getE_email() {
		return E_email;
	}

	public void setE_email(String e_email) {
		E_email = e_email;
	}

	public String getE_password() {
		return E_password;
	}

	public void setE_password(String e_password) {
		E_password = e_password;
	}

	public String getE_cpassword() {
		return E_cpassword;
	}

	public void setE_cpassword(String e_cpassword) {
		E_cpassword = e_cpassword;
	}

	public String getE_address() {
		return E_address;
	}

	public void setE_address(String e_address) {
		E_address = e_address;
	}

	public String getE_contact() {
		return E_contact;
	}

	public void setE_contact(String e_contact) {
		E_contact = e_contact;
	} 

}
