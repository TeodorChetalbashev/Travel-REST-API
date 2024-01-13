package com.example.travel.modelsDTO;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CreateLocationDTO
{

	
	private String street;
	private String number;
	private String city;

	public CreateLocationDTO(String street, String number, String city, String country, String imageUrl) {

		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
		this.imageUrl = imageUrl;
	}

	private String country;
	private String imageUrl;
	
	
	private CreateLocationDTO()
	{
		
	}


	public String getStreet()
	{
		return street;
	}


	public void setStreet(String street)
	{
		this.street = street;
	}


	public String getNumber()
	{
		return number;
	}


	public void setNumber(String number)
	{
		this.number = number;
	}


	public String getCity()
	{
		return city;
	}


	public void setCity(String city)
	{
		this.city = city;
	}


	public String getCountry()
	{
		return country;
	}


	public void setCountry(String country)
	{
		this.country = country;
	}


	public String getImageUrl()
	{
		return imageUrl;
	}


	public void setImageUrl(String imageUrl)
	{
		this.imageUrl = imageUrl;
	}



	
	
}