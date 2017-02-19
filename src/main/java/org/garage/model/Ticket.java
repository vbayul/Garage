package org.garage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
	
	@Id
	@GeneratedValue
	@Column(name = "idtickets")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idcars")
	private Car car;
	
	@ManyToOne
	@JoinColumn(name = "idclients")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "idtroubles")
	private Trouble trouble;
	
	@Column(name = "commenttikets")
	private String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Trouble getTrouble() {
		return trouble;
	}

	public void setTrouble(Trouble trouble) {
		this.trouble = trouble;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
