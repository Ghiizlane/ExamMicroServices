package org.sid.coreapi.dtos

import java.util.*

data class RadarRequestDTO(
        val vitesseMaximale:Double=0.0,
        val longitude : Double=0.0,
        val latitude : Double=0.0,
)

data class RadarRequestDTOUpdate(
        val id:String,
        val vitesseMaximale:Double,
        val longitude : Double,
        val latitude : Double,
)

data class VehiculeRequestDTO(
        val numMat:String,
        val marque : String,
        val puissanceFiscale : Double,
        val model : String
)
data class VehiculeRequestDTOUpdate(
        val id:String,
        val numMat:String,
        val marque : String,
        val puissanceFiscale : Double,
        val model : String
)
data class ProprietaireRequestDTO(
        val nom:String,
        val dateNaissance : Date,
        val email : String,
)
data class ProprietaireRequestDTOUpdate(
        val id:String,
        val nom:String,
        val dateNaissance : Date,
        val email : String,
)
data class InfractionsRequestDTO(
        val date:Date,
        val numMatVehicule : String,
        val vitesseVehicule : Double,
        val vitesseMaxRadar : Double,
        val montantInfraction: Double
)