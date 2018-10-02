package com.kkh.mcalc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kkh.mcalc.dto.FoodValueListDTO;
import com.kkh.mcalc.repository.FoodRepository;

@Service
@Transactional
public class FoodValueListService implements IFoodValueListService
{

	@Autowired
	FoodRepository foodrepository;

	

	@Override
	public void createFood(FoodValueListDTO dto) 
	{

     foodrepository.save(dto);
		
	}

	@Override
	public List<FoodValueListDTO> getAllFood() {
		
		  return (List<FoodValueListDTO>) foodrepository.findAll();
	}

	@Override
	public FoodValueListDTO getByName(String foodname) {
		  return foodrepository.findOne(foodname);
	}

	@Override
	public void deleteFood(String foodname) {
		foodrepository.delete(foodname);
		
	}

	@Override
	public FoodValueListDTO updateFood(FoodValueListDTO dto, String s) {
		   return foodrepository.save(dto);
		
	}

}
