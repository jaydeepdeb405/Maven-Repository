package com.spring.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao{
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Employee employee) {
		String query = "INSERT INTO employee values('"+employee.getId()+"','"+employee.getName()+"','"+employee.getSalary()+"')";
		return template.update(query);
	}
	
	public List<Employee> getEmployee(){
		return template.query("SELECT * FROM employee",new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet resultSet, int row) throws SQLException {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setSalary(resultSet.getDouble(3));
				return employee;
			}
		});
	}
	public List<Employee> getEmployeeRSE(){
		return template.query("SELECT * FROM employee", new ResultSetExtractor<List<Employee>>() {
			@Override
			public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				List<Employee> empList = new ArrayList<Employee>();
				while(resultSet.next()) {
					Employee employee = new Employee(resultSet.getInt(1),
							resultSet.getString(2),
							resultSet.getDouble(3));
					empList.add(employee);
				}
				return empList;
			}
		});
	}
	public void delete(int empId) {
		String query = "DELETE FROM employee where id="+empId;
		template.execute(query);
	}
	
	public Employee getEmployeeById(int empId) {
		Employee employee = null;
		String query = "SELECT * FROM employee where id="+empId;
	
		return employee;
	}
}
