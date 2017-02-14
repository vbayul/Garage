package org.garage.model;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

	@Id 
	@GeneratedValue
	@Column(name = "idclients")
	private int id;
	@Column(name = "nameclients")
	private String name;
	@Column(name="phoneclients")
	private String phone;
	/*
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idclients")
	private List<Car> car;
	*/	

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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
