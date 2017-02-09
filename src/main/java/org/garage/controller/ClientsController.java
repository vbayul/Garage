package org.garage.controller;

import java.util.List;

import org.garage.jpa.HibernateMapping;
import org.garage.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientsController {

	private HibernateMapping services = new HibernateMapping();
	
	@RequestMapping("/clients")
	public String getClients(ModelMap model){
		
		List<Client> clients = services.getClients();
		model.addAttribute("clients", clients);
		return "clients";
	}
	@RequestMapping("/clients/edit/{idClient}")
	public String editClient(@PathVariable int idClient, ModelMap model)
	{
		List<Client> client = services.getClient(idClient);
		model.addAttribute("client", client);
		return "edit";
	}
	
	/*
	@RequestMapping("/clients/add/")
	public String addClient(@ModelAttribute("client") Client client){
		
		return "clients";
	}
	*/
}
