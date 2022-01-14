package com.example.immatriculationcommandside.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.sid.coreapi.commands.CreateProprietaireCommand;
import org.sid.coreapi.commands.CreateRadarCommand;
import org.sid.coreapi.commands.UpdateProprietaireCommand;
import org.sid.coreapi.dtos.ProprietaireRequestDTO;
import org.sid.coreapi.dtos.ProprietaireRequestDTOUpdate;
import org.sid.coreapi.dtos.RadarRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/proprietaire/commands")
public class ProprietaireController {
    private CommandGateway commandGateway;
    private EventStore eventStore;


    @PostMapping("/create")
    public CompletableFuture<String> newProprietaire(@RequestBody ProprietaireRequestDTO request){
        return commandGateway.send(new CreateProprietaireCommand(
                UUID.randomUUID().toString(),
                request.getNom(),
                request.getDateNaissance(),
                request.getEmail()
        ));

    }

    @PostMapping("/update")
    public CompletableFuture<String> updateRadar(@RequestBody ProprietaireRequestDTOUpdate request){
        return commandGateway.send(new UpdateProprietaireCommand(
                request.getId(),
                request.getNom(),
                request.getDateNaissance(),
                request.getEmail()
        ));
    }

    @GetMapping("/eventStore/{id}")
    public Stream eventStore(@PathVariable String id){
        return eventStore.readEvents(id).asStream();
    }

}
