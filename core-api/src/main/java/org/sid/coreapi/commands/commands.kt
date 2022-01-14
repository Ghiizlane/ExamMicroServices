package org.sid.coreapi.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

abstract class BaseCommand<T>(
    @TargetAggregateIdentifier
    open val id : T
)

data class CreateRadarCommand(
        override val id:String,
        val vitesseMaximale:Double,
        val longitude : Double,
        val latitude : Double,
):BaseCommand<String>(id)

data class UpdateRadarCommand(
        override val id:String,
        val vitesseMaximale:Double,
        val longitude : Double,
        val latitude : Double,
):BaseCommand<String>(id)


// immatriculation commands


data class CreateVehiculeCommand(
        override val id:String,
        val numMat:String,
        val marque : String,
        val puissanceFiscale : Double,
        val model : String
):BaseCommand<String>(id)

data class UpdateVehiculeCommand(
        override val id:String,
        val numMat:String,
        val marque : String,
        val puissanceFiscale : Double,
        val model : String
):BaseCommand<String>(id)

data class CreateProprietaireCommand(
        override val id:String,
        val nom:String,
        val dateNaissance : Date,
        val email : String,
):BaseCommand<String>(id)

data class UpdateProprietaireCommand(
        override val id:String,
        val nom:String,
        val dateNaissance : Date,
        val email : String,
):BaseCommand<String>(id)



// infraction commands

data class CreateInfractionsCommand(
        override val id:String,
        val date:Date,
        val matriculeVehicle : String,
        val vitesseVehicle : Double,
        val vitesseMaxRadar : Double,
        val montantInfraction: Double
):BaseCommand<String>(id)

data class UpdateInfractionsCommand(
        override val id:String,
        val date:Date,
        val numMatVehicle : String,
        val vitesseVehicle : Double,
        val vitesseMaxRadar : Double,
        val montantInfraction: Double
):BaseCommand<String>(id)