package com.example.radarcommandside.aggregates;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.sid.coreapi.commands.CreateRadarCommand;
import org.sid.coreapi.commands.UpdateRadarCommand;
import org.sid.coreapi.events.RadarCreatedEvent;
import org.sid.coreapi.events.RadarUpdatedEvent;

@Slf4j
@Aggregate
public class RadarAggregate {
    @AggregateIdentifier
    private String id;
    private double vitesseMaximale;
    private double longitude;
    private double latitude;

    public RadarAggregate(){}


    @CommandHandler
    public RadarAggregate(CreateRadarCommand createRadarCommand){
        log.info("creat radar command ***********");

        AggregateLifecycle.apply(new RadarCreatedEvent(
            createRadarCommand.getId(),
                createRadarCommand.getVitesseMaximale(),
                createRadarCommand.getLongitude(),
                createRadarCommand.getLatitude()
        ));
    }

    @EventSourcingHandler
    public void on(RadarCreatedEvent radarCreatedEvent){
        log.info("creat radar event ***********");
        this.id=radarCreatedEvent.getId();
        this.vitesseMaximale=radarCreatedEvent.getVitesseMaximale();
        this.longitude=radarCreatedEvent.getLongitude();
        this.latitude=radarCreatedEvent.getLatitude();
    }



    @CommandHandler
    public RadarAggregate(UpdateRadarCommand updateRadarCommand){
        log.info("update radar command ***********");

        AggregateLifecycle.apply(new RadarCreatedEvent(
                updateRadarCommand.getId(),
                updateRadarCommand.getVitesseMaximale(),
                updateRadarCommand.getLongitude(),
                updateRadarCommand.getLatitude()
        ));
    }

    @EventSourcingHandler
    public void on(RadarUpdatedEvent radarUpdatedEvent){
        log.info("update radar event ***********");
        this.id=radarUpdatedEvent.getId();
        this.vitesseMaximale=radarUpdatedEvent.getVitesseMaximale();
        this.longitude=radarUpdatedEvent.getLongitude();
        this.latitude=radarUpdatedEvent.getLatitude();
    }




}
