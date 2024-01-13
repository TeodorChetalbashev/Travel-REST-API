package com.example.travel.repository;

import com.example.travel.modelsDTO.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Long>
{

}
