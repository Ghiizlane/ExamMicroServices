package com.example.radarqueryside.controllers;

import com.example.radarqueryside.entities.RadarEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.sid.coreapi.query.GetAllRadarsQuery;
import org.sid.coreapi.query.GetRadarByIdQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/radar/query")
public class RadarController {
    private QueryGateway queryGateway;


    @GetMapping("/all")
    public CompletableFuture<List<RadarEntity>> radars(){
        return queryGateway.query(new GetAllRadarsQuery(),
                ResponseTypes.multipleInstancesOf(RadarEntity.class));
    }

    @GetMapping("/byId/{id}")
    public CompletableFuture<RadarEntity> getRadar(@PathVariable String id){
        return queryGateway.query(new GetRadarByIdQuery(id),
                ResponseTypes.instanceOf(RadarEntity.class));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String > responseEntity= new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
