package com.example.immatriculationcommandside.aggregates;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.sid.coreapi.commands.CreateVehiculeCommand;
import org.sid.coreapi.commands.UpdateVehiculeCommand;
import org.sid.coreapi.events.CreatedVehiculeEvent;
import org.sid.coreapi.events.UpdatedVehiculeEvent;

import java.util.Date;

@Slf4j
@Aggregate
public class VehiculeAggregate {
    @AggregateIdentifier
    private String id;
    private String numMat;
    private String marque;
    private Double puissanceFiscale;
    private String model;

    public VehiculeAggregate(){}

    @CommandHandler
    public VehiculeAggregate(CreateVehiculeCommand createVehicleCommand){
        AggregateLifecycle.apply(new CreatedVehiculeEvent(
                createVehicleCommand.getId(),
                createVehicleCommand.getNumMat(),
                createVehicleCommand.getMarque(),
                createVehicleCommand.getPuissanceFiscale(),
                createVehicleCommand.getModel()
        ));
    }

    @EventSourcingHandler
    public void on(CreatedVehiculeEvent createdVehicleEvent){
        this.id=createdVehicleEvent.getId();
        this.numMat=createdVehicleEvent.getNumMat();
        this.marque=createdVehicleEvent.getMarque();
        this.puissanceFiscale=createdVehicleEvent.getPuissanceFiscale();
        this.model=createdVehicleEvent.getModel();
    }

    @CommandHandler
    public VehiculeAggregate(UpdateVehiculeCommand updateVehicleCommand){
        AggregateLifecycle.apply(new UpdatedVehiculeEvent(
                updateVehicleCommand.getId(),
                updateVehicleCommand.getNumMat(),
                updateVehicleCommand.getMarque(),
                updateVehicleCommand.getPuissanceFiscale(),
                updateVehicleCommand.getModel()
                ));
    }

    @EventSourcingHandler
    public void on(UpdatedVehiculeEvent updatedVehicleEvent){
        this.id=updatedVehicleEvent.getId();
        this.numMat=updatedVehicleEvent.getNumMat();
        this.marque=updatedVehicleEvent.getMarque();
        this.puissanceFiscale=updatedVehicleEvent.getPuissanceFiscale();
        this.model=updatedVehicleEvent.getModel();
    }
}
