package com.example.travel.services.impl;

import com.example.travel.modelsDTO.CreateReservationDTO;
import com.example.travel.modelsDTO.ResponseHolidayDTO;
import com.example.travel.modelsDTO.ResponseReservationDTO;
import com.example.travel.modelsDTO.UpdateReservationDTO;
import com.example.travel.modelsDTO.models.Holiday;
import com.example.travel.modelsDTO.models.Reservation;
import com.example.travel.repository.HolidayRepository;
import com.example.travel.repository.ReservationRepository;
import com.example.travel.services.ReservationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final HolidayRepository holidayRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(HolidayRepository holidayRepository, ReservationRepository reservationRepository) {
        this.holidayRepository = holidayRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ResponseReservationDTO createReservation(CreateReservationDTO createReservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setContactName(createReservationDTO.getContactName());
        reservation.setPhoneNumber(createReservationDTO.getPhoneNumber());
        reservation.setHoliday(holidayRepository.findById(createReservationDTO.getHoliday()).orElse(null));

        Reservation savedReservation = reservationRepository.save(reservation);
        return convertToResponse(savedReservation);
    }


    @Override
    public List<ResponseReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseReservationDTO getReservationById(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        return reservation.map(this::convertToResponse).orElse(null);
    }


    @Override
    public ResponseReservationDTO updateReservation(UpdateReservationDTO update) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(update.getId());
        if (reservationOptional.isPresent()) {
            Reservation reservation = reservationOptional.get();
            BeanUtils.copyProperties(update, reservation);
            reservation.setHoliday(holidayRepository.findById(update.getHoliday()).orElse(null));

            Reservation updatedReservation = reservationRepository.save(reservation);
            return convertToResponse(updatedReservation);
        }
        return null;
    }

    @Override
    public Boolean deleteReservation(Long reservationId) {
        if (reservationRepository.existsById(reservationId)) {
            reservationRepository.deleteById(reservationId);
            return true;
        }
        return false;
    }

    private ResponseReservationDTO convertToResponse(Reservation reservation) {
        ResponseReservationDTO response = new ResponseReservationDTO();
        BeanUtils.copyProperties(reservation, response);
        response.setHoliday(convertHolidayToResponse(reservation.getHoliday()));
        return response;
    }

    private ResponseHolidayDTO convertHolidayToResponse(Holiday holiday) {
        if (holiday == null) {
            return null;
        }
        ResponseHolidayDTO response = new ResponseHolidayDTO();
        BeanUtils.copyProperties(holiday, response);
        return response;
    }

}

