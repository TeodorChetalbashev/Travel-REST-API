package com.example.travel.modelsDTO;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class UpdateHolidayDTO
{

	private Long id;
	private Long location;
	private String title;
	private Date startDate;

	public UpdateHolidayDTO(Long id, Long location, String title, Date startDate, Integer duration, String price, Integer freeSlots) {
		this.id = id;
		this.location = location;
		this.title = title;
		this.startDate = startDate;
		this.duration = duration;
		this.price = price;
		this.freeSlots = freeSlots;
	}

	private Integer duration;
	private String price;
	private Integer freeSlots;
	
	
	public UpdateHolidayDTO()
	{
		
	}

	
	public Long getId()
	{
		return id;
	}


	public void setId(Long id)
	{
		this.id = id;
	}


	public Long getLocation()
	{
		return location;
	}


	public void setLocation(Long location)
	{
		this.location = location;
	}


	public String getTitle()
	{
		return title;
	}


	public void setTitle(String title)
	{
		this.title = title;
	}


	public Date getStartDate()
	{
		return startDate;
	}


	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}


	public Integer getDuration()
	{
		return duration;
	}


	public void setDuration(Integer duration)
	{
		this.duration = duration;
	}


	public String getPrice()
	{
		return price;
	}


	public void setPrice(String price)
	{
		this.price = price;
	}


	public Integer getFreeSlots()
	{
		return freeSlots;
	}


	public void setFreeSlots(Integer freeSlots)
	{
		this.freeSlots = freeSlots;
	}
	
	
}
