package org.garage.controller;

import java.util.List;

import org.garage.jpa.HibernateMappingCars;
import org.garage.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarsController {

	private HibernateMappingCars service = new HibernateMappingCars();

	@RequestMapping(value = "/cars/car/new")
	public String newCar(ModelMap model){
		Car car = new Car();
		model.addAttribute("operation", "add");
		model.addAttribute("car", car);
		return "car";
	}
	
	@RequestMapping(value = "/cars")
	public String addCar(ModelMap model){
		List<Car> cars = service.getCars();
		model.addAttribute("cars", cars);
		return "cars";
	}

	@RequestMapping(value = "/cars/car/{idCar}")
	public String addCar(@PathVariable("idCar") int idCar, ModelMap model){
		
		Car car = service.getCar(idCar);
		model.addAttribute("operation", "update");
		model.addAttribute("car",car);
		return "car";
	}
	
	@RequestMapping(value = "/cars/car/add", method = RequestMethod.POST)
	public String addCar(@ModelAttribute("car") Car car, ModelMap model){
		
		int idCars = (Integer) service.addCar(car); 
		return "redirect:/garage/cars/car/"+idCars;
	}
	
	@RequestMapping(value = "/cars/car/update", method = RequestMethod.POST)
	public String updateCar(@ModelAttribute("car") Car car, ModelMap model){
		
		service.updateCar(car); 
		return "redirect:/garage/cars/car/"+car.getId();
	}
}