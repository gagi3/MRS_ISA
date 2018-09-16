package com.isamrst17.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Reservation {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Screening getScreening() {
		return screening;
	}

	public void setScreening(Screening screening) {
		this.screening = screening;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Screening screening;
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy="reservation", fetch = FetchType.EAGER)
	private List<Ticket> tickets;
	
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private User user;
	
	private int points;
	
	private double price;
}
