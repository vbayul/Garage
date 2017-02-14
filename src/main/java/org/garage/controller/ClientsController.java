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
	
	@RequestMapping(value = "/clients/{idClient}")
	public String updateClient(@PathVariable int idClient, ModelMap model){
		Client client = services.getClient(idClient);
		List<Car> cars = services.getCars(idClient);
		model.addAttribute("cars", cars);
		model.addAttribute("client", client);
		return "edit";
	}
	
	@RequestMapping(value = "/clients/edit/{idClient}")
	public String addCarToClient(@PathVariable("idClient") int idClient, ModelMap model){
		Client client = services.getClient(idClient);
		List<Car> cars = services.getCars(idClient);
		model.addAttribute("cars", cars);
		model.addAttribute("client", client);
		return "edit";
	}
	
	@RequestMapping(value = "/clients/delete/{idClient}/{idCar}", method=RequestMethod.GET)
	public String deleteCarFromClient(@PathVariable("idClient") int idClient, @PathVariable("idCar") int idCar, ModelMap model){
		services.deleteCarFromClient(idCar);
		return "redirect:/garage/clients/"+idClient;
	}
	
	@RequestMapping( value = "/clients/update/", method = RequestMethod.POST)
	public String addClient(@ModelAttribute("client") Client client, ModelMap model){

		services.updateClient(client);
		return "redirect:/garage/clients";
	}
}
