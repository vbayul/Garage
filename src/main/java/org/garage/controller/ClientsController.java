package org.garage.controller;

import java.util.List;

import org.garage.jpa.HibernateMapping;
import org.garage.model.Car;
import org.garage.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientsController {

	private HibernateMapping services = new HibernateMapping();
	
	@RequestMapping( value = "/clients")
	public String getClients(ModelMap model){
		List<Client> clients = services.getClients();
		model.addAttribute("clients", clients);
		return "clients";
	}

	@RequestMapping(value = "/clients/client/new")
	public String newCarToClient(ModelMap model){
		Client client = new Client();
		model.addAttribute("operation", "add");
		model.addAttribute("client", client);
		return "client";
	}
	
	@RequestMapping(value = "/clients/client/add", method=RequestMethod.POST)
	public String addCarToClient(@ModelAttribute("client") Client client, ModelMap model){
		int idClient = services.addClient(client);
		return "redirect:/garage/clients/client/"+idClient;
	}
	
	
	@RequestMapping(value = "/clients/client/{idClient}")
	public String addCarToClient(@PathVariable("idClient") int idClient, ModelMap model){
		Client client = services.getClient(idClient);
		List<Car> cars = services.getCarsByClient(idClient);
		
		model.addAttribute("operation", "update");
		model.addAttribute("clientcars", cars);
		model.addAttribute("client", client);
		return "client";
	}

	@RequestMapping(value = "/clients/client/{idClient}/add/{idCar}")
	public String addCarToClient(@PathVariable("idClient") int idClient, @PathVariable("idCar") int idCar, ModelMap model){
		services.addCarToClient(idCar, idClient);
		return "redirect:/garage/clients/client/"+idClient;
	}
	
	@RequestMapping(value = "/clients/client/{idClient}/add")
	public String addCar(@PathVariable("idClient") int idClient, ModelMap model){
		List<Car> cars = services.getCarsFree();
		
		model.addAttribute("cars", cars);
		model.addAttribute("client", idClient);
		
		return "addcars";
	}
	
	@RequestMapping(value = "/clients/client/{idClient}/delete/{idCar}")
	public String deleteCarFromClient(@PathVariable("idClient") int idClient, @PathVariable("idCar") int idCar, ModelMap model){
		services.deleteCarFromClient(idCar);
		return "redirect:/garage/clients/client/"+idClient;
	}
	
	@RequestMapping( value = "/clients/client/update/", method = RequestMethod.POST)
	public String addClient(@ModelAttribute("client") Client client, ModelMap model){
		System.out.println("--------------------"+client.getName());
		services.updateClient(client);
		return "redirect:/garage/clients/client/"+client.getId();
	}
}
