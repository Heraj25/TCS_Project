package com.database;


public class Customer {
private String C_ssn;
private String C_name, C_email, C_address, C_number, C_aadhar, C_pan, C_acno, C_actyp, C_bal;

	public Customer(String C_ssn, String C_name, String C_email, String C_address, String C_number, String C_aadhar, String C_pan, String C_acno, String C_actyp, String C_bal) {
		// TODO Auto-generated constructor stub
		this.C_ssn=C_ssn;
		this.C_name=C_name;
		this.C_email=C_email;
		this.C_address=C_address;
		this.C_number=C_number;
		this.C_aadhar=C_aadhar;
		this.C_pan=C_pan;
		this.C_acno=C_acno;
		this.C_actyp = C_actyp;
		this.C_bal=C_bal;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getC_ssn() {
		return C_ssn;
	}

	public void setC_ssn(String C_ssn) {
		this.C_ssn = C_ssn;
	}

	public String getC_bal() {
		return C_bal;
	}

	public void setC_bal(String c_bal) {
		C_bal = c_bal;
	}

	public String getC_pan() {
		return C_pan;
	}

	public void setC_pan(String c_pan) {
		C_pan = c_pan;
	}

	public String getC_acno() {
		return C_acno;
	}

	public void setC_acno(String c_acno) {
		C_acno = c_acno;
	}
	
	public String getC_actyp() {
		return C_actyp;
	}
	public void setC_actyp(String c_actyp) {
		C_actyp = c_actyp;
	}

	public String getC_address() {
		return C_address;
	}

	public void setC_address(String c_address) {
		C_address = c_address;
	}

	public String getC_name() {
		return C_name;
	}

	public void setC_name(String c_name) {
		C_name = c_name;
	}

	public String getC_aadhar() {
		return C_aadhar;
	}

	public void setC_aadhar(String c_aadhar) {
		C_aadhar = c_aadhar;
	}

	public String getC_email() {
		return C_email;
	}

	public void setC_email(String c_email) {
		C_email = c_email;
	}

	public String getC_number() {
		return C_number;
	}

	public void setC_number(String c_number) {
		C_number = c_number;
	}

}


