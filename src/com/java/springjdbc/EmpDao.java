package com.java.springjdbc;

import java.util.List;

public interface EmpDao {
	
	public void insert(Employee e);
	public List<Employee> fetch();
	public void delete(Employee e);
	public void update(Employee e);
	
}
