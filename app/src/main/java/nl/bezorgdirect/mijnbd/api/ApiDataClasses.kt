package nl.bezorgdirect.mijnbd.api

data class Feed (val Id: Int?, val Name: String?)

data class Location (val id: String?, val latitude: Double?, val longitude: Double?, val address: String?, val postalCode: String?,
                     val place: String?, val isWarehouse: Boolean?)

data class User (val id: String?, var emailAddress: String?, val firstName: String?, val lastName: String?, var phoneNumber: String?,
                          val home: Location, val dateOfBirth: String?, var range: Int?, var vehicle: Int?, val vehicleDisplayName: String?, val fare: Float?, val totalEarnings: Float?)

data class Availability (val id: String?, val delivererId: String?, var date:  String?, var startTime: String?, var endTime: String?)

data class BDNotification (val id: String?, val delivererId: String?, val deliveryId: String?,val createdAt: String?, val acceptedAt: String?,
                           val refusedAt: String?, val expiredAt: String?, val status: Int?, val statusDisplayName: String?)


data class Delivery (val id: String?, val delivererId: String?, val customerPhoneNumber: String?, val dueDate: String?, val vehicle: Int?, val startedAtId: String?,
                     val warehouseDistanceInKilometers: Float?, val warehouseETA: String?, val warehousePickUpAt:  String?, val customerDistanceInKilometers: Float?,
                     val customerETA: String?, val customerId: String?, val currentId: String?, val deliveredAt: String?, val price: Float?, val tip: Float?,
                     val paymentMethod: Int?, val paymenMethodDisplayName: String?, val status: Int?, val statusDisplayName: String?, val warehouse: Location,
                     val customer: Location, val current: Location, val vehicleDisplayName: String)



