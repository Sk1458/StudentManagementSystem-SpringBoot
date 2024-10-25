package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students_data_project")
public class StuMgmtEntity {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String branch;
	@Column
	private String city;
	@Column
	private int age;
	@Column
	private String rollno;
	@Column
	private String course;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "StuMgmtEntity [id=" + id + ", name=" + name + ", branch=" + branch + ", city=" + city + ", age=" + age
				+ ", rollno=" + rollno + ", course=" + course + "]";
	}
	
}
