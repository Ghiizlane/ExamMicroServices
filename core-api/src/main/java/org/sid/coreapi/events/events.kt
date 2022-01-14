package org.sid.coreapi.events

import java.util.*

abstract class BaseEvent<T>(
    open val id : T
)

data class RadarCreatedEvent(
        override val id:String,
        val vitesseMaximale:Double,
        val longitude : Double,
        val latitude : Double,
):BaseEvent<String>(id)
data class RadarUpdatedEvent(
        override val id:String,
        val vitesseMaximale:Double,
        val longitude : Double,
        val latitude : Double,
):BaseEvent<String>(id)


// immatriculation events

data class CreatedVehiculeEvent(
        override val id:String,
        val numMat:String,
        val marque : String,
        val puissanceFiscale : Double,
        val model : String
):BaseEvent<String>(id)

data class UpdatedVehiculeEvent(
        override val id:String,
        val numMat:String,
        val marque : String,
        val puissanceFiscale : Double,
        val model : String
):BaseEvent<String>(id)

data class CreatedProprietaireEvent(
        override val id:String,
        val nom:String,
        val dateNaissance : Date,
        val email : String,
):BaseEvent<String>(id)

data class UpdatedProprietaireEvent(
        override val id:String,
        val nom:String,
        val dateNaissance : Date,
        val email : String,
):BaseEvent<String>(id)

// infraction events

data class CreatedInfractionsEvent(
        override val id:String,
        val date:Date,
        val matriculeVehicle : String,
        val vitesseVehicle : Double,
        val vitesseMaxRadar : Double,
        val montantInfraction: Double
):BaseEvent<String>(id)

data class UpdatedInfractionsEvent(
        override val id:String,
        val date:Date,
        val numMatVehicle : String,
        val vitesseVehicle : Double,
        val vitesseMaxRadar : Double,
        val montantInfraction: Double
):BaseEvent<String>(id)
