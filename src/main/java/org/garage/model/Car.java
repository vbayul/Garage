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
