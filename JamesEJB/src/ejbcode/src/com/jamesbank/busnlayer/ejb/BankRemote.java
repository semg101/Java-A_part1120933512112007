package com.jamesbank.busnlayer.ejb;

import javax.ejb.Remote;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import com.jamesbank.busnlayer.table.Customer;   
import com.jamesbank.commonlayer.dto.Uil2BilTO;  

@Remote
public interface BankRemote  
{
    public int addCustomer(Uil2BilTO uil2bilTO);
    public Uil2BilTO findCustomer(int pKey);
    public Uil2BilTO updateCustomer(Uil2BilTO uil2bilTO);
    public List<Uil2BilTO> searchCustomersbyAcc (Uil2BilTO uil2bilTO);     
}
