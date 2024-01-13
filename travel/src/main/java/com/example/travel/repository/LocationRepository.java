package com.example.travel.repository;

import com.example.travel.modelsDTO.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<Location, Long>
{

}
