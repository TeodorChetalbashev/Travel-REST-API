package com.example.travel.controllers;


import com.example.travel.modelsDTO.CreateReservationDTO;
import com.example.travel.modelsDTO.ResponseReservationDTO;
import com.example.travel.modelsDTO.UpdateReservationDTO;
import com.example.travel.services.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/reservations")
@RestController
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService service) {
        this.reservationService = service;
    }

    @PostMapping
    public ResponseEntity<ResponseReservationDTO> createReservation(@Valid @RequestBody CreateReservationDTO reservationDTO){
        ResponseReservationDTO response = reservationService.createReservation(reservationDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseReservationDTO>> getAllReservation() {
        List<ResponseReservationDTO> allReservations = reservationService.getAllReservations();
        return ResponseEntity.ok(allReservations);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<ResponseReservationDTO> getReservationById(@PathVariable Long reservationId) {
        ResponseReservationDTO reservation = reservationService.getReservationById(reservationId);
        return ResponseEntity.ok(reservation);
    }

    @PutMapping
    public ResponseEntity<ResponseReservationDTO> updateHoliday(@Valid @RequestBody UpdateReservationDTO update) {
        ResponseReservationDTO updatedReservation = reservationService.updateReservation(update);
        return ResponseEntity.ok(updatedReservation);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Boolean> deleteHoliday(@PathVariable Long reservationId) {
        Boolean deleted = reservationService.deleteReservation(reservationId);
        return ResponseEntity.ok(deleted);
    }
}

