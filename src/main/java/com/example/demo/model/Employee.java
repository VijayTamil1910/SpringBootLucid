package com.example.demo.model;



import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employeeInfo")
public class Employee {
	
	private int id;
	private String name;
	private int age;
	private String title;
	private String dob;
	
	public Employee() {
		System.out.println("Employee class constructor");
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getId() {
		System.out.println("GetID"+id);
		return id;
	}

	public String getName() {
		System.out.println("GetName"+name);
		return name;
	}

	public int getAge() {
		System.out.println("GetAge"+age);
		return age;
	}

	public String getTitle() {
		System.out.println("GetTitle"+title);
		return title;
	}

	public String getDob() {
		System.out.println("GetDob"+dob);
		return dob;
	}
	
	

}
