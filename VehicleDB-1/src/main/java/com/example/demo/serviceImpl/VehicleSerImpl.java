package com.example.demo.serviceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFound;
import com.example.demo.module.Vehicle;
import com.example.demo.repo.VehicleRepo;
import com.example.demo.service.VehicleService;

@Service
public class VehicleSerImpl implements VehicleService
{
	@Autowired
	VehicleRepo repo;

	@Override
	public Vehicle addVehicle(Vehicle v)
	{
		return repo.save(v);
	}

	@Override
	public Vehicle getById(int vid) {
		return repo.findById(vid).orElseThrow(()->new ResourceNotFound("Vehicle", "ID", vid));
	}

	@Override
	public Vehicle deleteByid(int vid) {
		Vehicle v=repo.findById(vid).orElse(null);
		if(v!=null)
		{
			repo.deleteById(vid);
			return v;
		}
		else
		{
			throw new ResourceNotFound("Vehicle", "Id", vid);
		}

	}

	@Override
	public List<Vehicle> getByColor(String color) 
	{
		return repo.getByColor(color);	
	}

	@Override
	public List<Vehicle> allDetails() {
		return repo.findAll();
	}

	@Override
	public List<Vehicle> sortByPrice() {
		return repo.sortByPrice();
	}

	@Override
	public List<Vehicle> sortByPriceAndColor() {
		List<Vehicle> v=repo.sortByPriceAndColor();
		Collections.sort(v,new Comparator<Vehicle>() {
			@Override
			public int compare(Vehicle v1, Vehicle v2)
			{
				if(v1.getPrice()>v2.getPrice())	
					return -1;
				else if(v1.getPrice()<v2.getPrice())
					return 1;
				else
				{
					return v1.getColor().compareTo(v2.getColor());
				}
			}

		});
		return v;
	}

	@Override
	public Vehicle updateVehicle(Vehicle v) {
		Vehicle v1=repo.findById(v.getVid()).orElse(null);
		if(v1!=null)
		{
			v1.setVname(v.getVname());
			v1.setVmodel(v.getVmodel());
			v1.setColor(v.getColor());
			v1.setPrice(v.getPrice());
			return repo.save(v1);
		}
		else
		{
			throw new ResourceNotFound("Vehicle", "Id", v.getVid());
		}


	}

	@Override
	public List<Vehicle> moreByPrice(Double price) {
		return repo.moreByPrice(price);
	}

}
