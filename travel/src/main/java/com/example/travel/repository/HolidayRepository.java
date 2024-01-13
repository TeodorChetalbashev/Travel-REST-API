package com.example.travel.repository;

import com.example.travel.modelsDTO.models.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday, Long>
{

}
