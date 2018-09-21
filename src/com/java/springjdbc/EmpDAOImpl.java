package com.java.springjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.*;

public class EmpDAOImpl implements EmpDao{

	private DataSource ds;
	
	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public void insert(Employee e) {
		try {
		Connection con=ds.getConnection();
		PreparedStatement pstmt=con.prepareStatement("insert into springdatasource (username,password,email,id) values(?,?,?,?)");
		pstmt.setString(1, e.getName());
		pstmt.setString(2, e.getPassword());
		pstmt.setString(3, e.getEmail());
		pstmt.setString(4, e.getId());
		int i=pstmt.executeUpdate();
		if(i==1) {
			System.out.println("Insert SUCCESS");
		}else
			System.out.println("Insert FAIL");
		
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
		}
	}

	@Override
	public List<Employee> fetch() {
		List<Employee> ls=new ArrayList<>();
		try {
			Connection con=ds.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from springdatasource");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setName(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setEmail(rs.getString("email"));
				e.setId(rs.getString("id"));
				ls.add(e);
			}
			System.out.println(ls);
			
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
		}	
		return ls;
	}

	@Override
	public void delete(Employee e) {
		try {
			Connection con=ds.getConnection();
			PreparedStatement pstmt=con.prepareStatement("delete from springdatasource where username=?");
			pstmt.setString(1, e.getName());
			int i=pstmt.executeUpdate();
			if(i==1) {
				System.out.println("Record DEleted");
			}else
				System.out.println("Record Not DEleted");
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
		}	
		
	}

	@Override
	public void update(Employee e) {
		try {
			Connection con=ds.getConnection();
			PreparedStatement pstmt=con.prepareStatement("update springdatasource set email=? where username=?");
			pstmt.setString(1, e.getEmail());
			pstmt.setString(2, e.getName());
			int i=pstmt.executeUpdate();
			if(i==1) {
				System.out.println("UPDATE SUCCESS");
			}else
				System.out.println("UPDATE FAIL");
			
			
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
		}	
		
	}
	

}
