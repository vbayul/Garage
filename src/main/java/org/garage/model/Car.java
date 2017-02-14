package org.garage.model;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {

	@Id
	@GeneratedValue
	@Column(name="idcars")
	private int id;
	@Column(name="namecars")
	private String name;
	@Column(name="idclients")
	private int idclients;
	@Column(name="yearcars")
	private int yearcars;
	
	public int getIdclients() {
		return idclients;
	}
	public void setIdclients(int idclients) {
		this.idclients = idclients;
	}
	public int getYearcars() {
		return yearcars;
	}
	public void setYearcars(int yearcars) {
		this.yearcars = yearcars;
	}
	
	public Car() {
	}
	public Car(int id) {
		this.id = id;
	}
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
}
