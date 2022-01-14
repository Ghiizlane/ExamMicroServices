package org.sid.coreapi.query

class GetAllCustomersQuery {}
class GetAllRadarsQuery {}
data class GetRadarByIdQuery(
        val id:String
)

data class GetCustomerByIdQuery(
 val id:String
)