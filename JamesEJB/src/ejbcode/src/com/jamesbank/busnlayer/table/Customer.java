package com.jamesbank.busnlayer.table;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CUSTOMER")
@SecondaryTable (name="ADDRESS",
                pkJoinColumns={
                   @PrimaryKeyJoinColumn(name="ADDRESS_ID")})
public class Customer implements Serializable
{
	private int id;
	private String custName;
	private String accType;
	private String custPassword;
	private String custRole;
	private Double creditLimit;
	private Double currentBalance;	
	private String street;
    private String city;
    private String state;
	
	@Id @GeneratedValue
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
	
	@Column(name="CREDITLIMIT")
	public Double getCreditLimit() { return creditLimit; }
	public void setCreditLimit(Double _creditLimit) { creditLimit = _creditLimit; }
	
	@Column(name="CURRENTBALANCE")
	public Double getCurrentBalance() { return currentBalance; }
	public void setCurrentBalance(Double _currentBalance) { currentBalance = _currentBalance; }
	
	@Column(name="CUSTNAME")
	public String getCustName() { return custName; }
	public void setCustName(String _custName) { custName = _custName; }

	@Column(name="ACCTYPE")
	public String getAccType() { return accType; }
	public void setAccType(String _accType) { accType = _accType; }

	@Column(name="PASSWORD")
	public String getCustPassword() { return custPassword; }
	public void setCustPassword(String _custPassword) { custPassword = _custPassword; }

	@Column(name="ROLE")
	public String getCustRole() { return custRole; }
	public void setCustRole(String _custRole) { custRole = _custRole; }
	
	@Column(name="STREET", table="ADDRESS")
    public String getStreet() { return street; }
    public void setStreet(String _street) { this.street = _street; }
    
    @Column(name="CITY", table="ADDRESS")
    public String getCity() { return city; }
    public void setCity(String _city) { this.city = _city; }
    
    @Column(name="STATE", table="ADDRESS")
    public String getState() { return state; }
    public void setState(String _state) { this.state = _state; }
}
