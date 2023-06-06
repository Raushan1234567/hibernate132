package com.dao;

import com.dto.Employee;

public interface Interface {
	public void save(Employee emp);
	public String getAddressOfEmployee(int empId);
	public int giveBonusToEmployee(int empId, int bonus);
	public boolean deleteEmployee(int empId);
}
