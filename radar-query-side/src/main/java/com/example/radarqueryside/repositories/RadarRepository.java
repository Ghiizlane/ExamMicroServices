package com.example.radarqueryside.repositories;

import com.example.radarqueryside.entities.RadarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<RadarEntity, String> {
}
