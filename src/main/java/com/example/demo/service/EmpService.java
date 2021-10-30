package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public class EmpService {
	private MongoTemplate mongoTemplate;
	
	@Autowired
	public EmpService(MongoTemplate mongoTemplate) {
		System.out.println("Heyy, I am Employee Service Class");
		this.mongoTemplate = mongoTemplate;
	}
	
	public String addEmployee(Employee employee) {
		Employee ins = mongoTemplate.insert(employee);
		System.out.println("Employee "+ins.getName()+" added into the database.");
		return "Employee "+ins.getName()+" added into the database.";
	}
	
	public List<Employee> getAllEmployees(){
		System.out.println("getAllEmployees");
		List<Employee> a = mongoTemplate.findAll(Employee.class);
		System.out.println(a);
		return a;
	}
	
	public Employee getEmployee(int id) {
		Query q = new Query();
		q.addCriteria(Criteria.where("id").is(id));
		System.out.println("getEmployee");
		return mongoTemplate.findOne(q, Employee.class);
	}
	
	public String updateEmployee(Employee employee) {
		mongoTemplate.save(employee);
		System.out.println("Employee "+employee.getName()+" updated into the database.");
		return "Employee "+employee.getName()+" updated into the database.";
	}
	
	public String updateEmployeeByID(int id, Map<String, String> data) {
		Query select = Query.query(Criteria.where("id").is(id));
		Update update = new Update();
		for(Map.Entry m:data.entrySet()){
			update.set((String) m.getKey(), m.getValue());  
	    }  
		
		//update.set("email", "p.maier@example.com");
		mongoTemplate.findAndModify(select, update, Employee.class);
		return "Updated";
	}
	
	public String deleteEmployee(int id) {
		Query q = new Query();
		q.addCriteria(Criteria.where("id").is(id));
		Employee employee = mongoTemplate.findAndRemove(q, Employee.class);
		System.out.println("Employee "+employee.getName()+" deleted from the database.");
		return "Employee "+employee.getName()+" deleted from the database.";
	}
}
