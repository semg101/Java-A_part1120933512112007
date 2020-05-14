package com.jamesbank.commonlayer.dto;

import java.io.Serializable;

public class Uil2BilTO  implements java.io.Serializable
{
	private int id;
	private int toAcc;
	private int transferAmt;
	private String custName;
	private String accType;
	private String custPassword;
	private String custRole;
	private Double creditLimit;   
	private Double currentBalance;
	
	private String street;
    private String city;
    private String state;
	
	public Uil2BilTO () { 	}  
	
	public Uil2BilTO 
	(
		int _id, Double _creditLimit, Double _currentBalance,
		String _custName, String _accType, String _custPassword, String _custRole	
	 )
	{
		this.id = _id;
		this.custName = _custName;
		this.accType = _accType;
		this.custPassword = _custPassword;
		this.custRole = _custRole;
		this.creditLimit = _creditLimit;
		this.currentBalance = _currentBalance;
	}
	
	public int getId() { return id; }
	public void setId(int _id) { id = _id; }
	
	public int getToAcc() { return toAcc; }
	public void setToAcc(int _toAcc) { toAcc = _toAcc; }
	
	public int getTransferAmt() { return transferAmt; }
	public void setTransferAmt(int _transferAmt) { transferAmt = _transferAmt; }
		
	public Double getCreditLimit() { return creditLimit; }
	public void setCreditLimit(Double _creditLimit) { creditLimit = _creditLimit; }
	
	public Double getCurrentBalance() { return currentBalance; }
	public void setCurrentBalance(Double _currentBalance) { currentBalance = _currentBalance; }
	
	public String getCustName() { return custName; }
	public void setCustName(String _custName) { custName = _custName; }

	public String getAccType() { return accType; }
	public void setAccType(String _accType) { accType = _accType; }

	public String getCustPassword() { return custPassword; }
	public void setCustPassword(String _custPassword) { custPassword = _custPassword; }

	public String getCustRole() { return custRole; }
	public void setCustRole(String _custRole) { custRole = _custRole; }
	
	//--------- Secondary Table Insert
    public String getStreet() { return street; }
    public void setStreet(String _street) { this.street = _street; }

    public String getCity() { return city; }
    public void setCity(String _city) { this.city = _city; }

    public String getState() { return state; }
    public void setState(String _state) { this.state = _state; }
	//---------
	
	//-------------
	private Double transType;
	private String amount;
	
	public Double getTransType() { return transType; }
	public void setTransType(Double _transType) { transType = _transType; }
	
	public String getAmount() { return amount; }
	public void setAmount(String _amount) { custRole = _amount; }
	//-------------

}
