package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.module.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>
{
	@Query(value="select * from vehicle where color=?1",nativeQuery=true)
	List<Vehicle> getByColor(String color);

	@Query(value="select * from vehicle order by price",nativeQuery=true)
	List<Vehicle> sortByPrice();

	@Query(value="select * from vehicle order by price",nativeQuery=true)
	List<Vehicle> sortByPriceAndColor();

	@Query(value="select * from vehicle where price>=?1",nativeQuery=true)
	List<Vehicle> moreByPrice(Double price);
}
