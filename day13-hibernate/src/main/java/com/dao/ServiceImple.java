package com.dao;

import com.dto.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ServiceImple implements Interface{

	@Override
	public void save(Employee emp) {
		
		EntityManager c=null;
		
		c=Connect.getco();
		
		EntityTransaction et=c.getTransaction();
		
		et.begin();
		c.persist(emp);
		et.commit();
		c.close();
		
	}

	@Override
	public String getAddressOfEmployee(int empId) {
		// TODO Auto-generated method stub
		EntityManager c=null;
		
		String p=null;
		c=Connect.getco();
		Employee t=c.find(Employee.class, empId);
		
		if(t==null) {
			return p;
			
		
		}
		
		else {
			p=t.getAddress();
			
		}
		
		return  p;
	}

	@Override
	public int giveBonusToEmployee(int empId, int bonus) {
		// TODO Auto-generated method stub
		EntityManager c=null;
		int sal=0;
		c=Connect.getco();
		
Employee t=c.find(Employee.class, empId);
		
		if(t==null) {
			System.out.println("Employee not found for this id");
		}
		else {
			EntityTransaction et =c.getTransaction();
			sal=t.getSalary()+bonus;
			et.begin();
			t.setSalary(sal);
			et.commit();
		}
		
		
		return sal;
	}

	@Override
	public boolean deleteEmployee(int empId) {
	
		EntityManager c=null;
		boolean f;
		c=Connect.getco();
		
Employee t=c.find(Employee.class, empId);
		
		if(t==null) {
			System.out.println("Employee not found for this id");
			return false;
		}
		else {
			EntityTransaction et =c.getTransaction();
			
			et.begin();
		    c.remove(t);
			et.commit();
		}
		
		
		return true;
	}


	
}
