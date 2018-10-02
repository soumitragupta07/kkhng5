package com.kkh.mcalc.dto;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="foodvaluemasterlist")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FoodValueListDTO implements Serializable
{

	/**
	 * author:soumitra gupta
	 */
	private static final long serialVersionUID = 1L;
	
	
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name="foodid")
	//private int foodid;
	
	@Id
	@Column(name="foodname")
	 public String foodname;
	@Column(name="cal")
	private int cal;
	@Column(name="fat")
	private int fat;
	@Column(name="carbs")
	private int carbs;
	@Column(name="fiber")
	private int fiber;
	@Column(name="protein")
	private int protein;
	
	
	public FoodValueListDTO()
	{}
	
	
public FoodValueListDTO(String foodname, int cal, int fat, int carbs, int fiber, int protein) {
		super();
		this.foodname = foodname;
		this.cal = cal;
		this.fat = fat;
		this.carbs = carbs;
		this.fiber = fiber;
		this.protein = protein;
	}
	//	public int getFoodid()
//	{
//		return foodid;
//	}
//	public void setFoodid(int foodid) 
//	{
//		this.foodid = foodid;
//	}
	public String getFoodname()
	{
		return foodname;
	}
	public String findByName()
	{
		return foodname;
	}
	public void setFoodname(String foodname) 
	{
		this.foodname = foodname;
	}
	public int getCal()
	{
		return cal;
	}
	public void setCal(int cal) 
	{
		this.cal = cal;
	}
	public int getFat()
	{
		return fat;
	}
	public void setFat(int fat) 
	{
		this.fat = fat;
	}
	public int getCarbs() 
	{
		return carbs;
	}
	public void setCarbs(int carbs) 
	{
		this.carbs = carbs;
	}
	public int getFiber() 
	{
		return fiber;
	}
	public void setFiber(int fiber)
	{
		this.fiber = fiber;
	}
	public int getProtein()
	{
		return protein;
	}
	public void setProtein(int protein)
	{
		this.protein = protein;
	}
	
	

	
	
	
}
