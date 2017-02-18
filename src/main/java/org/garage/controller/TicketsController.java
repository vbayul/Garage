package org.garage.controller;

import java.util.List;

import org.garage.jpa.HibernateMappingTickets;
import org.garage.model.Car;
import org.garage.model.Client;
import org.garage.model.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TicketsController {

	private HibernateMappingTickets service = new HibernateMappingTickets();
	
	@RequestMapping(path = "/tickets")
	public String getTikets(ModelMap model){
		
		List<Ticket> tickets = service.getTickets();
		model.addAttribute("tickets", tickets);
		
		return "tickets";
	}
	
	@RequestMapping(path = "/tickets/ticket/{idTicket}")
	public String getTicket(@PathVariable("idTicket") int idTicket, ModelMap model){
		
		Ticket ticket = service.getTicket(idTicket);
		
		model.addAttribute("ticket", ticket);
		return "ticket";
	}
	
	@RequestMapping(path = "/tickets/ticket/update", method=RequestMethod.POST)
	public String getUpdate(@ModelAttribute("ticket") Ticket ticket, 
			@ModelAttribute("car") Car car, //@ModelAttribute("client") Client client,
			ModelMap model){
		
		System.out.println(car.getId());		
		
		return "tickets";
	}

}
