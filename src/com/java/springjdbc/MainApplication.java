package com.java.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
	public static void main(String[] args) {

	ApplicationContext context=new ClassPathXmlApplicationContext("resources/spring.xml");
	EmpDAOImpl e=(EmpDAOImpl)context.getBean("empdao");
	/*Employee emp=new Employee();
	emp.setName("reddy");
	emp.setPassword("reddy123");
	emp.setEmail("reddy@gmail.com");
	emp.setId("1215");
	e.insert(emp);*/
	
	/*e.fetch();*/
	
	/*Employee emp=new Employee();
	emp.setName("reddy");
	emp.setEmail("reddy12345@gmail.com");
	e.update(emp);*/
	
	Employee emp=new Employee();
	emp.setName("reddy");
	e.delete(emp);
	}	
	
}
