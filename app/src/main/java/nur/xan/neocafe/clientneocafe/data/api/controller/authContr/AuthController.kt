package nur.xan.neocafe.clientneocafe.data.api.controller.authContr

import com.google.gson.JsonObject
import nur.xan.neocafe.clientneocafe.models.authModels.AuthSignUpModels
import nur.xan.neocafe.clientneocafe.models.sendCodeRegistrationModels.SendCodeRegistrationModels
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AuthController {



    @Headers("Accept: application/json")
    @POST("/api/client/auth/registration")
    suspend fun postClientRegister(
        @Body body: JsonObject
    ): Response<AuthSignUpModels>


    @Headers("Accept: application/json")
    @POST("/api/client/auth/sendCodeRegistration")
    suspend fun sendCodeRegistration(
        @Query("phoneNumber") phone: String)
            : Response<SendCodeRegistrationModels>

    @Headers("Accept: application/json")
    @POST("/api/client/auth/verify-phone-number")
    suspend fun verifyPhoneNumber(
        @Query("phoneNumber") phone: String,
        @Query("code") code: String)
            : Response<SendCodeRegistrationModels>



    @Headers("Accept: application/json")
    @POST("/api/client/auth/sendCodeLogin")
    suspend fun sendCodeLogin(
        @Query("phoneNumber") phone: String)
            : Response<SendCodeRegistrationModels>

    @Headers("Accept: application/json")
    @POST("/api/client/auth/login")
    suspend fun signInLogin(
        @Query("phoneNumber") phone: String,
        @Query("code") code: String)
            : Response<AuthSignUpModels>



}