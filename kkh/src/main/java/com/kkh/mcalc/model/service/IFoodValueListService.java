package com.kkh.mcalc.model.service;

import java.util.List;

import com.kkh.mcalc.dto.FoodValueListDTO;

public interface IFoodValueListService 
{
	public void createFood(FoodValueListDTO dto);
	
	public List<FoodValueListDTO> getAllFood();
	public FoodValueListDTO getByName(String foodname);
  
    public FoodValueListDTO  updateFood(FoodValueListDTO dto, String s);
    
    public void deleteFood(String foodname);

}
