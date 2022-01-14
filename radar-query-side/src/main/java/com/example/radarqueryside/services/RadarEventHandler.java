package com.example.radarqueryside.services;

import com.example.radarqueryside.entities.RadarEntity;
import com.example.radarqueryside.repositories.RadarRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.sid.coreapi.events.RadarCreatedEvent;
import org.sid.coreapi.events.RadarUpdatedEvent;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RadarEventHandler {
    private RadarRepository radarRepository;

    @EventHandler
    public void on(RadarCreatedEvent event){
        radarRepository.save(new RadarEntity(
                event.getId(),
                event.getVitesseMaximale(),
                event.getLongitude(),
                event.getLatitude()
        ));
    }

    @EventHandler
    public void on(RadarUpdatedEvent event){
        radarRepository.save(new RadarEntity(
                event.getId(),
                event.getVitesseMaximale(),
                event.getLongitude(),
                event.getLatitude()
        ));
    }
}
