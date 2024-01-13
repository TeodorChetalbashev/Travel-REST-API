package com.example.travel.modelsDTO;

import java.util.Date;


import com.example.travel.modelsDTO.models.Location;


public class ResponseHolidayDTO
{

	private Long id;

	public ResponseHolidayDTO(Long id, Location location, String title, Date startDate, Integer duration, String price, Integer freeSlots) {
		this.id = id;
		this.location = location;
		this.title = title;
		this.startDate = startDate;
		this.duration = duration;
		this.price = price;
		this.freeSlots = freeSlots;
	}

	/*@ManyToOne
        @JoinColumn(name = "location_id")*/
    private Location location; //dai Location ot models
	private String title;
	private Date startDate;
	private Integer duration;
	private String price;
	private Integer freeSlots;


	public ResponseHolidayDTO()
	{

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getFreeSlots() {
		return freeSlots;
	}

	public void setFreeSlots(Integer freeSlots) {
		this.freeSlots = freeSlots;
	}
}
