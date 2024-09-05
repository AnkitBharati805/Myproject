package com.nareshit.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value="/tickets") //http://locahost:8080/tickets
//http://locahost:8080/tickets ==? TicketController obj=ioc.getTicketController();
public class TicketController {
	
	
	
	@Autowired
	private TicketService ticketService; //TicketService ticketService=ioc.getTicketService();
										//TicketService obj=new TicketService();
	/*
	 * 
	 * REST ==> WEBSERVICES COMMUNICATION ==> HETEROGENIOUS FRAMEWORKS COMMUNICATION
	 *       ==> WITH JSON OBJECT ==> REST PROTOCOL COMMUNICATION WILL HAPPEN
	 *       
	 *       @POST ==> Creating the Data + @RequestMapping ==> @PostMapping
	 *       @Get ==> Retriving the DAta + @RequestMapping ==> @GetMapping
	 *       @Put ==> Updating the Data ==> @RequestMapping ==> @PutMapping
	 *       @Delete ==> Deleting the data ==>                 @DeleteMapping
	 *       
	 *       
	 *       Both Marshalling and UnMarshalling
	 *       
	 *       Marshalling ==> JAVA TO JSON
	 *                   ==> JSON TO JAVA ==> Jackson Library
	 */
	
	
	//Create Ticket
	
	@PostMapping(value="/create") //@PostMapping==> @Post + @RequestMapping
	//http://localhost:8080/tickets/create ==> obj.createTicket();
	public Ticket createTicket(@RequestBody Ticket ticketInput) {
		
		return ticketService.createTicket(ticketInput);
		
	}
	
	
	
	//Retrieve All Tickets
	@GetMapping(value="/all") //http://localhost:8080/tickets/all
	//http://localhost:8080/tickets/all ==> obj.getAllTickets();
	public Iterable<Ticket> getAllTickets(){
		return ticketService.getAllTickets();
	}
	
	
	
	//Retrive Individual Ticket
	//http://localhost:8080/tickets/get/1 ==> 1st Ticket
	//http://localhost:8080/tickets/get/2 ==> 2nd Ticket
	//http://localhost:8080/tickets/get/100 ==> 100th Ticket
	
	
	@GetMapping(value="/get/{ticketId}")
	public Ticket getTicket( @PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicket(ticketId);
	}
	
	
	//http://localhost:8080/tickets/vijay
	@GetMapping(value="/{passengerName}")
	public Ticket getTicket( @PathVariable("passengerName") String passengerName) {
		return ticketService.findByPassengerName(passengerName);
	}
	
	//Update Ticket
	
	//http://localhost:8080/tickets/1/a@b.com
	//http://localhost:8080/tickets/2/b@d.com
	@PutMapping(value="/{ticketId}/{newEmail}")
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId,
							   @PathVariable("newEmail") String newEmail) {
		
		return ticketService.updateTicket(ticketId, newEmail);
		
	}
	
	
	//Delete Ticket
	//http://localhost:8080/tickets/1 ==> 1st Ticket
	//http://localhost:8080/tickets/2 ==> 2nd Ticket
	//http://localhost:8080/tickets/100 ==> 100th Ticket

	@DeleteMapping(value="/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketService.deleteTicket(ticketId);
	}
}
