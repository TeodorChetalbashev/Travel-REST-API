package com.example.travel.services;

import com.example.travel.modelsDTO.CreateReservationDTO;
import com.example.travel.modelsDTO.ResponseReservationDTO;
import com.example.travel.modelsDTO.UpdateReservationDTO;

import java.util.List;

public interface ReservationService {
    ResponseReservationDTO createReservation(CreateReservationDTO createReservationDTO);
    List<ResponseReservationDTO> getAllReservations();
    ResponseReservationDTO getReservationById(Long reservationId);

    ResponseReservationDTO updateReservation(UpdateReservationDTO update);
    Boolean deleteReservation(Long reservationId);

}
