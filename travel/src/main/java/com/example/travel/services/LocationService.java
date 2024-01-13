package com.example.travel.services;

import com.example.travel.modelsDTO.CreateLocationDTO;
import com.example.travel.modelsDTO.ResponseLocationDTO;
import com.example.travel.modelsDTO.UpdateLocationDTO;

import java.util.List;

public interface LocationService {
    ResponseLocationDTO createLocation(CreateLocationDTO createLocationDTO);
    List<ResponseLocationDTO> getAllLocations();
    ResponseLocationDTO getLocationById(Long locationId);

    ResponseLocationDTO updateLocation(UpdateLocationDTO updateLocationDTO);
    Boolean deleteLocation(Long locationId);
}
