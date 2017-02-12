package org.garage.model;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

	@Id 
	@GeneratedValue
	@Column(name = "idclients")
	private int id;
	@Column(name = "nameclients")
	private String name;

	@ManyToOne
	@JoinColumn(name = "idcars")
	private Car car;
	
	public Car getCar() {
	    return this.car;
	}
	public void setCars(Car car) {
	    this.car = car;
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
