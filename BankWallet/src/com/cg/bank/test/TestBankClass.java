package com.cg.bank.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.cg.bank.exception.BankAccException;
import com.cg.bank.service.IBankAccService;
import com.cg.bank.service.BankAccServiceImpl;

public class TestBankClass {

   
    @Test
    public void validateName1() throws BankAccException{
    
        String name="Manish11";
        IBankAccService service=new BankAccServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(false,result);
    }
    
    @Test
    public void validateMobile2() throws BankAccException{
    
        String mobNo="8559802";
        IBankAccService service=new BankAccServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }
	
    @Test
    public void validateName2() throws BankAccException{
    
        String name="Mani";
        IBankAccService service=new BankAccServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(true,result);
    }
    @Test
    public void validateName3() throws BankAccException{
    
        String name="mani";
        IBankAccService service=new BankAccServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(false,result);
    }
  
    
    @Test
    public void validateMobile() throws BankAccException{
    
        String mobNo="MANish9828963";
        IBankAccService service=new BankAccServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }
    
    @Test
    public void validateMobile3() throws BankAccException{
    
        String mobNo="M9828963Mani";
        IBankAccService service=new BankAccServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }
    @Test
    public void validateMobile1() throws BankAccException{
    
        String mobNo="8559802823";
        IBankAccService service=new BankAccServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(true,result);
    }
    
	
}
