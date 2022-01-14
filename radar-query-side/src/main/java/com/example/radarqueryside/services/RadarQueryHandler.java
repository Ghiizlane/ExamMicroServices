package com.example.radarqueryside.services;

import com.example.radarqueryside.entities.RadarEntity;
import com.example.radarqueryside.repositories.RadarRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.sid.coreapi.query.GetAllRadarsQuery;
import org.sid.coreapi.query.GetRadarByIdQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RadarQueryHandler {
    private RadarRepository radarRepository;

    @QueryHandler
    public List<RadarEntity> List(GetAllRadarsQuery query){
        return radarRepository.findAll();
    }
    @QueryHandler
    public RadarEntity getRadarById(GetRadarByIdQuery query){
        return radarRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("error"));
    }
}
