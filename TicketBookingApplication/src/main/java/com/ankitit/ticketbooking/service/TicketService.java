package com.nareshit.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.ticketbooking.dao.TicketDao;
import com.nareshit.ticketbooking.model.Ticket;

@Service

/*
 * 
 * Framework will consider this as service class for handling transaction managment and configuration layer for connectiong
 *     external frameworks like kafka,rabmitmq,structs,HIBERNATE,JAX RS , JAX WS etc...
 *     
 *     
 *     save ==> Create and Update
 *     findAll ==> Retrieve All
 *     
 *     findById ==> Retrieve Single==> select * from ticket where ticketid=?
 *     
 *     
 *     deleteById ==> Delete Single
 *     saveAll ==> Create or Update Multiple
 *     
 *     findAllBYId ==> Retreive Multiple 
 *     
 */
public class TicketService {
	
	
	//Call the DAO Layer and perfrom the DB Operations
	
	
	@Autowired
	private TicketDao ticketDao; //TicketDao ticketDao =new TicketDao();
	
	
	
	//Create Ticket
	
	public Ticket createTicket(Ticket inputObj) {
		return ticketDao.save(inputObj);
		//save ==> Insert and Update 
		/*
		 * If inputObj.getTicketId() ==>  Primary Key ==>  null
		 *    inputObj.getTicketId() !=null ==> If its not there in the database ==> Insert
		 *    inputObj.getTicketId() !=null ==> If id exists  in the database ==> Update
		 *    
		 */
	}
	
	
	
	//Retrieve All Tickets
	public Iterable<Ticket> getAllTickets(){
		
		return ticketDao.findAll();
		
		//findAll ==> select * from tbl_ticket
		// Database will give ResultSet ==> Resultset will converted into Iterable<Ticket>
		
	}
	
	
	
	//Retrieve Single Ticket
	public Ticket getTicket(Integer ticketId) {
		return ticketDao.findById(ticketId)  //findById ==> select * from tbl_ticket where ticket_id=ticketId
						.orElse(new Ticket());
				
	}
	
	
	
	//Update Ticket
	
	public Ticket updateTicket(Integer ticketId,String newEmail) {
		
		Ticket dbTicketObj=getTicket(ticketId);
		dbTicketObj.setEmail(newEmail);
		return ticketDao.save(dbTicketObj); //Save ==Update 
		
	}
	
	
	
	//Delete Ticket
	public void deleteTicket(Integer ticketId) {
		ticketDao.deleteById(ticketId);
		//deleteById ==> delete tbl_ticket where ticket_id=ticketId
	}

	
	//Derived Method Invocation
	
	public Ticket findByPassengerName(String passengerName) {
		return ticketDao.findByPassengerName(passengerName);
	}
}
