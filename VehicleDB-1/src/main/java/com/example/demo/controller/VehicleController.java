package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
public class VehicleController 
{
	@Autowired
	VehicleService ser;

	@PostMapping("/addVehicles")
	ResponseEntity<Vehicle> addVehicle1(@RequestBody Vehicle v)
	{
		return new ResponseEntity<Vehicle>(ser.addVehicle(v),HttpStatus.CREATED);
	}

	@GetMapping("/getbyid")
	ResponseEntity<Vehicle> getVehicleById(@RequestHeader int vid)
	{
		return new ResponseEntity<Vehicle>(ser.getById(vid),HttpStatus.FOUND);
	}

	@DeleteMapping("/deleteVehicle")
	ResponseEntity<Vehicle> deleteById(@RequestParam int vid)
	{
		return new ResponseEntity<Vehicle>(ser.deleteByid(vid),HttpStatus.OK);
	}

	@GetMapping("/getbycolor")
	ResponseEntity<List<Vehicle>> getByColor(@RequestHeader String color)
	{
		return new ResponseEntity<List<Vehicle>>(ser.getByColor(color),HttpStatus.FOUND);
	}

	@GetMapping("/allVehicles")
	ResponseEntity<List<Vehicle>> allVehicles()
	{
		return new ResponseEntity<List<Vehicle>>(ser.allDetails(),HttpStatus.FOUND);
	}

	@PutMapping("/updateVehicle")
	ResponseEntity<Vehicle> vehicleUpdate(@RequestBody Vehicle v)
	{
		return new ResponseEntity<Vehicle>(ser.updateVehicle(v),HttpStatus.FOUND);
	}

	@GetMapping("/sortByPrice")
	ResponseEntity<List<Vehicle>> vehicleSort()
	{
		return new ResponseEntity<List<Vehicle>>(ser.sortByPrice(),HttpStatus.FOUND);
	}

	@GetMapping("/sortByColorAndPrice")
	ResponseEntity<List<Vehicle>> vehicleSortByColor()
	{
		return new ResponseEntity<List<Vehicle>>(ser.sortByPriceAndColor(),HttpStatus.FOUND);
	}

	@GetMapping("/vehicleByPrice")
	ResponseEntity<List<Vehicle>> vehicleMoreByPrice(@RequestHeader Double price)
	{
		return new ResponseEntity<List<Vehicle>>(ser.moreByPrice(price),HttpStatus.FOUND);
	}


}
