package com.kkh.mcalc.repository;



import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kkh.mcalc.dto.FoodValueListDTO;

@Repository
public interface FoodRepository extends JpaRepository<FoodValueListDTO, String> 
{

	
		
}