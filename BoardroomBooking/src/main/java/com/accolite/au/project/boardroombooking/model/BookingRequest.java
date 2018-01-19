package com.accolite.au.project.boardroombooking.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name = "BookingRequest")
public class BookingRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int status;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;

	private String purpose;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@Cascade(value = { CascadeType.ALL })
	private User user;

	@ManyToOne
	@JoinColumn(name = "room_id")
	@Cascade(value = { CascadeType.ALL })
	private BoardRoom boardroom;

	public BookingRequest() {
		super();
	}

	public BookingRequest(int status, Date startTime, Date endTime, String purpose, User user, BoardRoom boardroom) {
		super();
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.purpose = purpose;
		this.user = user;
		this.boardroom = boardroom;
	}

	public BookingRequest(int id, int status, Date startTime, Date endTime, String purpose, User user,
			BoardRoom boardroom) {
		super();
		this.id = id;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
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

	public Date getstartTime() {
		return startTime;
	}

	public void setstartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getendTime() {
		return endTime;
	}

	public void setendTime(Date endTime) {
		this.endTime = endTime;
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
