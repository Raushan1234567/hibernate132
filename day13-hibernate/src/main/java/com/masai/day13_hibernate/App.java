package com.masai.day13_hibernate;

import java.util.Scanner;

import com.dao.Interface;
import com.dao.ServiceImple;
import com.dto.Employee;


public class App 
{
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);
        int c;
        do {
        	System.out.println("1. Add");
        	System.out.println("2. View");
        	System.out.println("3. Update");
        	System.out.println("4. Delete");
        	System.out.println("0. Exit");
        	c=sc.nextInt();
        	switch(c) {
        	case 1:
        		Add(sc);
        		break;
        	case 2:
        		View(sc);
        		break;
        	case 3:
        		Update(sc);
        		break;
        	case 4:
        		Delete(sc);
        		break;
        	case 0:
        		System.out.println("Thanks");
        		break;
        		default :
        			System.out.println("invalid");
break;

        	}
        }while(c!=0);
          sc.close();   
    }

	private static void Add(Scanner sc) {
	
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter address ");
		String address =sc.next();
		System.out.println("Enter salary");
		int  salary =sc.nextInt();
		
		Employee a=new Employee(name,address,salary);
		
	Interface b=new ServiceImple();
	b.save(a);
		
	}

	private static void View(Scanner sc) {
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		Interface b=new ServiceImple();
	String d=	b.getAddressOfEmployee(id);
	if(d==null) {
		System.out.println("Employee not found for this id");
	}else {
	System.out.println(d);
	}
		
	}

	private static void Update(Scanner sc) {
		System.out.println("Enter id");
		int id=sc.nextInt();
		System.out.println("Enter Bonus amount");
		int  bonus=sc.nextInt();
		
		Interface b=new ServiceImple();
		
		b.giveBonusToEmployee(id, bonus);
		
	}

	private static void Delete(Scanner sc) {
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		Interface b=new ServiceImple();
		
		boolean r=b.deleteEmployee(id);
		if(r==true) {
			System.out.println("Deleted Successfuly");
		}
		
		
		
	}
}
