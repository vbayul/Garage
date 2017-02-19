package org.garage.controller;

import java.util.List;

import org.garage.jpa.HibernateMappingCars;
import org.garage.jpa.HibernateMappingClients;
import org.garage.jpa.HibernateMappingTickets;
import org.garage.jpa.HibernateMappingTroubles;
import org.garage.model.Car;
import org.garage.model.Client;
import org.garage.model.Ticket;
import org.garage.model.Trouble;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TicketsController {

	private HibernateMappingTickets service = new HibernateMappingTickets();
	private HibernateMappingCars serviceCar = new HibernateMappingCars();
	private HibernateMappingClients serviceClient = new HibernateMappingClients();	
	private HibernateMappingTroubles serviceTrouble = new HibernateMappingTroubles();
	
	@RequestMapping(path = "/tickets")
	public String getTikets(ModelMap model){
		
		List<Ticket> tickets = service.getTickets();
		model.addAttribute("tickets", tickets);
		
		return "tickets";
	}
	
	@RequestMapping(path = "/tickets/ticket/{idTicket}")
	public String getTicket(@PathVariable("idTicket") int idTicket, ModelMap model){
		
		Ticket ticket = service.getTicket(idTicket);
		List<Car> cars = serviceCar.getCars();
		List<Trouble> troubles = serviceTrouble.getTroubles();
		
		model.addAttribute("troubles", troubles);	
		model.addAttribute("cars", cars);
		model.addAttribute("ticket", ticket);
		model.addAttribute("operation", "update");
		return "ticket";
	}
	
	@RequestMapping(path = "/tickets/ticket/update", method=RequestMethod.POST)
	public String getUpdate(@ModelAttribute("ticket") Ticket ticket, 
			ModelMap model){
		service.updateTicket(ticket);		
		return "redirect:/garage/tickets/ticket/"+ticket.getId();
	}
	
	@RequestMapping(path = "/tickets/ticket/clients")
	public String createTicket( ModelMap model){
		
		List<Client> clients = serviceClient.getClientsWithCar();
		model.addAttribute("clients", clients);
		return "ticketclients";
	}
	
	@RequestMapping(path = "/tickets/ticket/create/{idClient}")
	public String createTicket(@PathVariable("idClient") int idClient, ModelMap model){
		
		Ticket ticket = new Ticket();
		Client client = serviceClient.getClient(idClient);
		ticket.setClient(client);
		List<Car> cars = serviceClient.getCarsByClient(idClient);
		List<Trouble> troubles = serviceTrouble.getTroubles();
		
		model.addAttribute("troubles", troubles);	
		model.addAttribute("cars", cars);
		model.addAttribute("ticket", ticket);
		model.addAttribute("operation", "add");
		
		return "ticket";
	}
	
	@RequestMapping(path = "/tickets/ticket/add", method = RequestMethod.POST)
	public String addTicket(@ModelAttribute("ticket") Ticket ticket, ModelMap model){
		
		int id = service.saveTicket(ticket);
		return "redirect:/garage/tickets/ticket/"+id;
	}

}
