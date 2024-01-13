package com.example.travel.services.impl;


import com.example.travel.modelsDTO.CreateHolidayDTO;
import com.example.travel.modelsDTO.ResponseHolidayDTO;
import com.example.travel.modelsDTO.UpdateHolidayDTO;
import com.example.travel.modelsDTO.models.Holiday;
import com.example.travel.modelsDTO.models.Location;
import com.example.travel.repository.HolidayRepository;
import com.example.travel.repository.LocationRepository;
import com.example.travel.services.HolidayService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HolidayServiceImpl implements HolidayService {
        private final HolidayRepository repository;
        private final LocationRepository locationRepository;
        @Autowired
        public HolidayServiceImpl(HolidayRepository repository, LocationRepository locationRepository) {
        this.repository = repository;
        this.locationRepository = locationRepository;
        }


        private ResponseHolidayDTO converterToResponse(Holiday holiday) {
            ResponseHolidayDTO response = new ResponseHolidayDTO();
            BeanUtils.copyProperties(holiday, response);
            return response;
        }
        private Location loadLocationById(long id){
        return locationRepository.findById(id).get();
        }

        @Override
        public ResponseHolidayDTO createHoliday(CreateHolidayDTO createHolidayDTO) {

            Holiday holiday = new Holiday();

            Location location = this.loadLocationById(createHolidayDTO.getLocation());

            holiday.setLocation(location);
            BeanUtils.copyProperties(createHolidayDTO, holiday);
            Holiday savedLocation = repository.save(holiday);
            ResponseHolidayDTO response = new ResponseHolidayDTO();
            BeanUtils.copyProperties(savedLocation, response);
            return response;
        }

    @Override
    public List<ResponseHolidayDTO> getAllHolidays() {
        List<Holiday> response = repository.findAll();

        return response.stream().map(this::converterToResponse).collect(Collectors.toList());
    }

    @Override
    public ResponseHolidayDTO getHolidayById(Long holidayId) {
        Optional<Holiday> optionalHoliday = repository.findById(holidayId);
        return optionalHoliday.map(this::converterToResponse).orElse(null);
    }

    @Override
    public ResponseHolidayDTO updateHoliday(UpdateHolidayDTO update) {
        Optional<Holiday> holidayOptional = repository.findById(update.getId());
        if (holidayOptional.isPresent()) {
            Holiday holiday = holidayOptional.get();
            BeanUtils.copyProperties(update, holiday);
            Holiday updatedHoliday = repository.save(holiday);
            return converterToResponse(updatedHoliday);
        }
        return null;
    }

    @Override
    public Boolean deleteHoliday(Long holidayId) {
        if (repository.existsById(holidayId)) {
            repository.deleteById(holidayId);
            return true;
        }
        return false;
    }


}