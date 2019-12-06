package nl.bezorgdirect.mijnbd.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    /************************auth******************************************/
    @POST("login") //Login as a Deliverer
    fun loginPost(@Body params: LoginParams): Call<User>

    @POST("logout") //Logout the authenticated Deliverer
    fun logoutPost(@Header("Authorization") auth: String): Call<Void>

    /************************availablities******************************************/
    @POST("availablities") //Availabilities will be pushed to authenticated Deliverer's Availabilities array
    fun availablitiesPost(@Header("Authorization") auth: String): Call<ResponseBody>

    @GET("availablities") //List Availabilities of authenticated Deliverer
    fun availablitiesGet(@Header("Authorization") auth: String): Call<ArrayList<Availability>>

    @PUT("availablities") //Update Availabilities of authenticated Deliverer
    fun availablitiesPut(@Header("Authorization") @Body availability: Availability): Call<Availability>

    @DELETE("availablities/{id}") //Delete Availability with {Id} of authenticated Deliverer
    fun availablitiesDelete(@Path("id") id: String, @Header("x-authtoken") auth: String): Call<ResponseBody>

    /************************Deliverers******************************************/
    @GET("me") //Read authenticated Deliverer
    fun deliverGet(@Header("Authorization") auth: String): Call<User>

    @PUT("me") //Update authenticated Deliverer
    fun deliverPut(@Header("Authorization") @Body user: User): Call<Availability>

    /************************Notifications******************************************/
    @GET("notifications") //Read Notification of authenticated Deliverer
    fun notificationGet(@Header("Authorization") auth: String): Call<BDNotification>

    @PATCH("notifications/{id}") //Update Notification of authenticated Deliverer
    fun notifacationPatch(@Header("Authorization") auth: String,
                          @Body params: UpdateNotificationParams): Call<ResponseBody>

    /************************Locations******************************************/
    @GET("locations/warehouses") //List Warehouses
    fun locationGet(@Header("Authorization") auth: String): Call<ArrayList<Location>>

    /************************Deliveries******************************************/
    @GET("deliverery") //Read Delivery of authenticated Deliverer
    fun delivereryGet(@Header("Authorization") auth: String): Call<Delivery>

    @PATCH("delivery/location") //Update currentLocation in Delivery
    fun deliverylocationPatch(@Header("Authorization") auth: String,
                              @Body params: UpdateLocationParams): Call<Delivery>

    @PATCH("delivery/{id}/status") //Update status in Delivery
    fun deliverystatusPatch(@Header("Authorization") auth: String,
                            @Path("id") id: String,
                            @Body params: UpdateStatusParams): Call<Delivery>

    @GET("delivereries") //List Deliveries of authenticated Deliverer
    fun delivereriesGet(@Header("Authorization") auth: String): Call<ArrayList<Delivery>>

}
