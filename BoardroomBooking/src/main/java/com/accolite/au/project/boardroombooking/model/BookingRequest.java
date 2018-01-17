package com.accolite.au.project.boardroombooking.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "BookingRequest")
public class BookingRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int status;
	private LocalDateTime booking_date;
	private LocalTime hours;
	private String purpose;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private BoardRoom boardroom;


	public BookingRequest() {
		super();
	}

	public BookingRequest(int status, LocalDateTime booking_date, LocalTime hours, String purpose, User user,
			BoardRoom boardroom) {
		super();
		this.status = status;
		this.booking_date = booking_date;
		this.hours = hours;
		this.purpose = purpose;
		this.user = user;
		this.boardroom = boardroom;
	}

	public BookingRequest(int id, int status, LocalDateTime booking_date, LocalTime hours, String purpose, User user,
			BoardRoom boardroom) {
		super();
		this.id = id;
		this.status = status;
		this.booking_date = booking_date;
		this.hours = hours;
		this.purpose = purpose;
		this.user = user;
		this.boardroom = boardroom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(LocalDateTime booking_date) {
		this.booking_date = booking_date;
	}

	public LocalTime getHours() {
		return hours;
	}

	public void setHours(LocalTime hours) {
		this.hours = hours;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BoardRoom getBoardroom() {
		return boardroom;
	}

	public void setBoardroom(BoardRoom boardroom) {
		this.boardroom = boardroom;
	}

}
