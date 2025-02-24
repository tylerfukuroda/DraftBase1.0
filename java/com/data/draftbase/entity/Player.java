package com.data.draftbase.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Player implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	@JsonProperty
	private String firstName;
	
	@Column
	@JsonProperty
	private String lastName;
	
	@Column
	@JsonProperty
	private String position;
	
	@Column
	@JsonProperty
	private Integer height;
	
	@Column
	@JsonProperty
	private Integer weight;
	
	@Column
	@JsonProperty
	private Integer age;
	
	@Column(name = "class")
	@JsonProperty
	private Integer draftClass;
	
	@Column
	@JsonProperty
	private String school;
	
	public Player(Long id, String firstName, String lastName, String position, int height, int weight, int age, int draftClass, String school) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.draftClass = draftClass;
		this.school = school;
	}
	
	public Player(Long id, String firstName, String lastName, String position) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		height = 0;
		weight = 0;
		age = 0;
		draftClass = 2025;
		school = "Empty";
	}
	
	public Player() {
		id = 0;
		firstName = "";
		lastName = "";
		position = "";
		height = 0;
		weight = 0;
		age = 0;
		draftClass = 2025;
		school = "";
	}
	
	
	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPosition() {
		return position;
	}
	public Integer getHeight() {
		return height;
	}
	public Integer getWeight() {
		return weight;
	}
	public Integer getAge() {
		return age;
	}
	public Integer getDraftClass() {
		return draftClass;
	}
	public String getSchool() {
		return school;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setDraftClass(Integer draftClass) {
		this.draftClass = draftClass;
	}
	public void setSchool(String school) {
		this.school = school;
	}

	
	
	
	

}
