package com.example.radarcommandside.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.sid.coreapi.commands.CreateRadarCommand;
import org.sid.coreapi.dtos.RadarRequestDTO;
import org.sid.coreapi.dtos.RadarRequestDTOUpdate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/radar/commands")
public class RadarCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;


    @PostMapping("/create")
    public CompletableFuture<String> newRadar(@RequestBody RadarRequestDTO request){
        return commandGateway.send(new CreateRadarCommand(
                UUID.randomUUID().toString(),
                request.getVitesseMaximale(),
                request.getLongitude(),
                request.getLatitude()
        ));

    }

    @PostMapping("/update")
    public CompletableFuture<String> updateRadar(@RequestBody RadarRequestDTOUpdate request){
        return commandGateway.send(new CreateRadarCommand(
                request.getId(),
                request.getVitesseMaximale(),
                request.getLongitude(),
                request.getLatitude()
        ));
    }

    @GetMapping("/eventStore/{radarId}")
    public Stream eventStore(@PathVariable String radarId){
        return eventStore.readEvents(radarId).asStream();
    }

}
