package com.kkh.mcalc.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.kkh.mcalc.dto.FoodValueListDTO;
import com.kkh.mcalc.model.service.IFoodValueListService;

@RestController
@RequestMapping(value= {"/"})
@CrossOrigin(origins = {"http://localhost:4200"})
public class FoodValueListController 
{
	@Autowired
	private IFoodValueListService foodservice;
	
	@GetMapping(value="/all-food",  headers="Accept=application/json")
	 public List<FoodValueListDTO> getAll()
		{
	        List<FoodValueListDTO> t =foodservice.getAllFood();
	        return t;
		}
	
	@GetMapping(value = "/food/{foodname}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FoodValueListDTO> getByName(@PathVariable("foodname") String foodname) 
	{
        System.out.println("Fetching User with foodname " + foodname);
        
        FoodValueListDTO f = foodservice.getByName(foodname);
        if (f == null) {
            return new ResponseEntity<FoodValueListDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FoodValueListDTO>(f, HttpStatus.OK);
    }

	
	 @PostMapping(value="/food",headers="Accept=application/json")
	    public ResponseEntity<Void> createFood(@RequestBody FoodValueListDTO dto, UriComponentsBuilder ucBuilder){
	        System.out.println("Creating Food "+dto.getFoodname());
	        foodservice.createFood(dto);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/{foodname}").buildAndExpand(dto.getFoodname()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	
	
	
	 @PutMapping(value="/food", headers="Accept=application/json")
	    public ResponseEntity<String> updateFood(@RequestBody FoodValueListDTO currentFood)
	    {
	        System.out.println("sd");
	        FoodValueListDTO f = foodservice.getByName(currentFood.getFoodname());
	        if (f==null) {
	            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	        }
	        foodservice.updateFood(currentFood, currentFood.getFoodname());
	        return new ResponseEntity<String>(HttpStatus.OK);
	    }
	
	 @DeleteMapping(value="/food/{foodname}", headers ="Accept=application/json")
	    public ResponseEntity<FoodValueListDTO> deleteFood(@PathVariable("foodname") String foodname) 
	 {
		 FoodValueListDTO f = foodservice.getByName(foodname);
	        if (f == null) {
	            return new ResponseEntity<FoodValueListDTO>(HttpStatus.NOT_FOUND);
	        }
	        foodservice.deleteFood(foodname);
			//final String responseString = String.format("Food with foodname: %s is deleted successfully.", foodname);
		    //LOG.info(responseString);
	        return new ResponseEntity<FoodValueListDTO>(HttpStatus.NO_CONTENT);//.body(responseString);;
	    }
}
