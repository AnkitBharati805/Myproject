package com.nareshit.ticketbooking.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @Entity ==> A Table will created in the database ..By default Table Name is Class Name
 * @Table ==> This is optional ==> If we want to create a table with custom name rather than class name
 * By default property name will be the column name 
 * 
 * AUTO ==> JPA will create a sequence to the database. It will increment this sequence
 *  when insert statment is triggered
 * 
 * @Column is also optional
 */
@Entity
@Table(name = "tbl_ticket") //A Table will created with name called tbl_ticket
public class Ticket {
	
	@Id//This Annotation creates a primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;
	
	
	@Column(name = "passenger_name") // A Column will be in tbl_ticket with passenger_name 
	private String passengerName;
	
	@Column(name="source_station")
	private String sourceStation;
	
	@Column(name = "destination_station")
	private String destinationStation;
	
	@Column(name="travel_date")
	private Date travelDate;
	
	
	private String email;


	public Integer getTicketId() {
		return ticketId;
	}


	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}


	public String getPassengerName() {
		return passengerName;
	}


	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}


	public String getSourceStation() {
		return sourceStation;
	}


	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}


	public String getDestinationStation() {
		return destinationStation;
	}


	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}


	public Date getTravelDate() {
		return travelDate;
	}


	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	public Ticket() {}

	public Ticket(String passengerName, String sourceStation, String destinationStation, Date travelDate,
			String email) {
		super();
		this.passengerName = passengerName;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.travelDate = travelDate;
		this.email = email;
	}


	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", sourceStation=" + sourceStation
				+ ", destinationStation=" + destinationStation + ", travelDate=" + travelDate + ", email=" + email
				+ "]";
	}
	
	
	
	
	
	

}
