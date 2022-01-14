package com.example.immatriculationcommandside.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.sid.coreapi.commands.CreateProprietaireCommand;
import org.sid.coreapi.commands.CreateVehiculeCommand;
import org.sid.coreapi.commands.UpdateProprietaireCommand;
import org.sid.coreapi.commands.UpdateVehiculeCommand;
import org.sid.coreapi.dtos.ProprietaireRequestDTO;
import org.sid.coreapi.dtos.ProprietaireRequestDTOUpdate;
import org.sid.coreapi.dtos.VehiculeRequestDTO;
import org.sid.coreapi.dtos.VehiculeRequestDTOUpdate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/vehicule/commands")
public class VehiculeController {
    private CommandGateway commandGateway;
    private EventStore eventStore;


    @PostMapping("/create")
    public CompletableFuture<String> newVehicule(@RequestBody VehiculeRequestDTO request){
        return commandGateway.send(new CreateVehiculeCommand(
                UUID.randomUUID().toString(),
                request.getNumMat(),
                request.getMarque(),
                request.getPuissanceFiscale(),
                request.getModel()
        ));

    }

    @PostMapping("/update")
    public CompletableFuture<String> updateVehicule(@RequestBody VehiculeRequestDTOUpdate request){
        return commandGateway.send(new UpdateVehiculeCommand(
                request.getId(),
                request.getNumMat(),
                request.getMarque(),
                request.getPuissanceFiscale(),
                request.getModel()
        ));
    }

    @GetMapping("/eventStore/{id}")
    public Stream eventStore(@PathVariable String id){
        return eventStore.readEvents(id).asStream();
    }

}
