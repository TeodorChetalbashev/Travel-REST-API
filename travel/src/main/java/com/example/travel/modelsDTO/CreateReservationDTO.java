package com.example.travel.modelsDTO;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CreateReservationDTO
{

	
	private String contactName;
	private String phoneNumber;
	private long holiday;


	public CreateReservationDTO(String contactName, String phoneNumber, long holiday) {

		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.holiday = holiday;
	}

	public CreateReservationDTO()
	{
		
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


	public long getHoliday()
	{
		return holiday;
	}


	public void setHoliday(long holiday)
	{
		this.holiday = holiday;
	}


	
	
}
