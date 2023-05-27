package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Vehicle;

public interface VehicleService 
{
	Vehicle addVehicle(Vehicle v);

	Vehicle getById(int vid);

	Vehicle deleteByid(int eid);

	List<Vehicle> getByColor(String color);

	List<Vehicle> allDetails();

	List<Vehicle> sortByPrice();

	List<Vehicle> sortByPriceAndColor();

	Vehicle updateVehicle(Vehicle v);

	List<Vehicle> moreByPrice(Double price);



}
