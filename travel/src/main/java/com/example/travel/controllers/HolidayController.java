package com.example.travel.controllers;

import com.example.travel.modelsDTO.CreateHolidayDTO;
import com.example.travel.modelsDTO.ResponseHolidayDTO;
import com.example.travel.modelsDTO.UpdateHolidayDTO;
import com.example.travel.services.HolidayService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/holidays")
@RestController
public class HolidayController {

	private final HolidayService holidayService;

	public HolidayController(HolidayService holidayService) {
		this.holidayService = holidayService;
	}


	@PostMapping()
	public ResponseEntity<ResponseHolidayDTO> createHoliday(@Valid @RequestBody CreateHolidayDTO createHolidayDTO) {
		ResponseHolidayDTO responseHolidayDTO = holidayService.createHoliday(createHolidayDTO);
		return new ResponseEntity<>(responseHolidayDTO, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ResponseHolidayDTO>> getAllHolidays() {
		List<ResponseHolidayDTO> allHolidays = holidayService.getAllHolidays();
		return ResponseEntity.ok(allHolidays);
	}

	@GetMapping("/{holidayId}")
	public ResponseEntity<ResponseHolidayDTO> getHolidayById(@PathVariable Long holidayId) {
		ResponseHolidayDTO holiday = holidayService.getHolidayById(holidayId);
		return ResponseEntity.ok(holiday);
	}

	@PutMapping
	public ResponseEntity<ResponseHolidayDTO> updateHoliday(@Valid @RequestBody UpdateHolidayDTO updateHolidayDTO) {
		ResponseHolidayDTO updatedHoliday = holidayService.updateHoliday(updateHolidayDTO);
		return ResponseEntity.ok(updatedHoliday);
	}

	@DeleteMapping("/{holidayId}")
	public ResponseEntity<Boolean> deleteHoliday(@PathVariable Long holidayId) {
		Boolean deleted = holidayService.deleteHoliday(holidayId);
		return ResponseEntity.ok(deleted);
	}
}