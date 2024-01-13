package com.example.travel.services;

import com.example.travel.modelsDTO.CreateHolidayDTO;
import com.example.travel.modelsDTO.ResponseHolidayDTO;
import com.example.travel.modelsDTO.UpdateHolidayDTO;

import java.util.List;

public interface HolidayService {
    ResponseHolidayDTO createHoliday(CreateHolidayDTO createHolidayDTO);
    List<ResponseHolidayDTO> getAllHolidays();
    ResponseHolidayDTO getHolidayById(Long holidayId);
    ResponseHolidayDTO updateHoliday(UpdateHolidayDTO update);
    Boolean deleteHoliday(Long holidayId);

}

