package com.jamesbank.busnlayer.ejb;
 
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import com.jamesbank.busnlayer.table.Customer;
import com.jamesbank.commonlayer.dto.Uil2BilTO; 
     
@Stateless   
public class BankBean implements BankRemote 
{
    @PersistenceContext(unitName="bankPersistance") private EntityManager manager;
    public Uil2BilTO findCustomer(int pKey)
    {
    	Customer customer = manager.find(Customer.class, pKey);
    	Uil2BilTO uil2bilTO = new Uil2BilTO();
    	uil2bilTO.setId(customer.getId());
    	uil2bilTO.setCreditLimit(customer.getCreditLimit());
    	uil2bilTO.setCurrentBalance(customer.getCurrentBalance());
    	uil2bilTO.setCustName(customer.getCustName());
    	uil2bilTO.setAccType(customer.getAccType());
    	uil2bilTO.setCustPassword(customer.getCustPassword());
    	uil2bilTO.setCustRole(customer.getCustRole());
    	uil2bilTO.setCity(customer.getCity());
    	uil2bilTO.setState(customer.getState());
    	uil2bilTO.setStreet(customer.getStreet());    	
		return uil2bilTO;
    }   
    public List<Uil2BilTO> searchCustomersbyAcc (Uil2BilTO inuil2bilTO)
    {
    	System.out.println("Inside searchCustomersbyAcc "+inuil2bilTO.getCustName());
    	System.out.println("Inside searchCustomersbyAcc "+inuil2bilTO.getCustPassword());
    	String sql = "select c from Customer c";
    	Query query = null;
    	if(null != inuil2bilTO.getCustName() && null != inuil2bilTO.getCustPassword())
    	{
    		sql = "from Customer c where c.custName=?1 and c.custPassword=?2";
    		query = manager.createQuery(sql);
    		query.setParameter(1, (String)inuil2bilTO.getCustName());
		    query.setParameter(2, (String)inuil2bilTO.getCustPassword());
    	}
    	else
    	{
    		query = manager.createQuery("select c from Customer c");
    	}
        List<Customer> inList = query.getResultList();
        List<Uil2BilTO> outlist = new ArrayList();
        for(Iterator<Customer> rsItr = inList.iterator();rsItr.hasNext();)
        {
        	Customer customer = rsItr.next();
        	Uil2BilTO outuil2bilTO = new Uil2BilTO();
        	System.out.println("cust name "+customer.getCustName());
        	outuil2bilTO.setId(customer.getId());
    		outuil2bilTO.setCreditLimit(customer.getCreditLimit());
    		outuil2bilTO.setCurrentBalance(customer.getCurrentBalance());
    		outuil2bilTO.setCustName(customer.getCustName());
    		outuil2bilTO.setAccType(customer.getAccType());
    		outuil2bilTO.setCustPassword(customer.getCustPassword());
    		outuil2bilTO.setCustRole(customer.getCustRole());
    		outlist.add(outuil2bilTO);    		 
        }
        System.out.println("outlist size "+outlist.size());
        return outlist;
    }   
    public int addCustomer(Uil2BilTO uil2bilTO) 
    {     	  
    	Customer customer = new Customer();
      	customer.setCreditLimit(uil2bilTO.getCreditLimit());
    	customer.setCurrentBalance(uil2bilTO.getCurrentBalance());
    	customer.setCustName(uil2bilTO.getCustName());
    	customer.setAccType(uil2bilTO.getAccType());
    	customer.setCustPassword(uil2bilTO.getCustPassword());
    	customer.setCustRole(uil2bilTO.getCustRole());
    	customer.setStreet(uil2bilTO.getStreet());
    	customer.setCity(uil2bilTO.getCity());
    	customer.setState(uil2bilTO.getState());
    	manager.persist(customer); 
    	return customer.getId();
    }
    public Uil2BilTO updateCustomer(Uil2BilTO uil2bilTO) 
    {     	  
    	Customer customer = new Customer();
       	customer.setId(uil2bilTO.getId());
      	customer.setCreditLimit(uil2bilTO.getCreditLimit());
    	customer.setCurrentBalance(uil2bilTO.getCurrentBalance());
    	customer.setCustName(uil2bilTO.getCustName());
       	customer.setAccType(uil2bilTO.getAccType());
    	customer.setCustPassword(uil2bilTO.getCustPassword());
    	customer.setCustRole(uil2bilTO.getCustRole());
    	customer.setStreet(uil2bilTO.getStreet());
       	customer.setCity(uil2bilTO.getCity());
    	customer.setState(uil2bilTO.getState());
    	manager.merge(customer);
    	return uil2bilTO;
    }      
}
