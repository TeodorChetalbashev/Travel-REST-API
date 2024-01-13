package com.example.travel.modelsDTO;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ResponseReservationDTO
{
	private Long id;
	private String contactName;
	private String phoneNumber;
	/*@ManyToOne
    @JoinColumn(name = "holiday_id")*/
    private ResponseHolidayDTO holiday;

	public ResponseReservationDTO(Long id, String contactName, String phoneNumber, ResponseHolidayDTO holiday) {
		this.id = id;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.holiday = holiday;
	}

	public ResponseReservationDTO()
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


	public String getContactName()
	{
		return contactName;
	}


	public void setContactName(String contactName)
	{
		this.contactName = contactName;
	}


	public String getPhoneNumber()
	{
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}


	public ResponseHolidayDTO getHoliday()
	{
		return holiday;
	}


	public void setHoliday(ResponseHolidayDTO holiday)
	{
		this.holiday = holiday;
	}
	
	
}
