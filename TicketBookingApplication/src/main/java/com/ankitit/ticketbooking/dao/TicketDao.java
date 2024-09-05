package com.nareshit.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ticketbooking.model.Ticket;

//Its a wrapper on Datababase
/*
 * Connecting to database
 * CRUD OPERATIONS ==> CREATE,READ , UPDATE AND DELETE
 * 
 * CRUD REPOSITORY ==> FOR PERFORMING CRUD OPERATIONS ==> Developer no need to write code for CRUD Operation
 * 					two inputs ==> 1) Model Class Name
 *                                 2) Data Type of Primary Key
 *                                 
 *  SAVE METHOD USED FOR BOTH INSERT AND UPDATE OPERATIONS
 * 			
 * 
 * 
 */

@Repository
public interface TicketDao extends CrudRepository<Ticket, Integer>{
	
	/*
	 * 
	 * With TicketDao we can perform all CRUD OPERATIONS
	 * 
	 * C ==> CREATE ==> INSERTING THE DATA ==> TICKETDAO.SAVE()
	 * 
	 * R ==> READ ==> SELECT * FROM TABLE ==> TICKETDAO.FINDALL() ==> ALL THE DATA IN THE TABLE
	 *            ==> SELECT * FROM TABLE WHERE COLUMN=? ==> TICKETDAO.FINDBYID() ==> RETRIEVES SPECIFIC RECORD
	 *            
	 *  U ==> UPDATE ==> UPDATE ==> UPDATE TABLE SET ..... ==> TICKETDAO.SAVE();
	 *  
	 *  D ==> DELETE ==> DELETE FROM TABLE WHERE <CONDITION> ==> TICKETDAO.DELETEBYID()
	 *  
	 *  
	 */

	
	public Ticket findByPassengerName(String passengerName); //Abstract Method
	//Framework will implement ==> select * from tbl_ticket where passenger_name=passengerName
	//Resultset Into Java Object
}
