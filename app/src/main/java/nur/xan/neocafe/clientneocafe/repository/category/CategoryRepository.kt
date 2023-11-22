package nur.xan.neocafe.clientneocafe.repository.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.google.gson.JsonObject
import nur.xan.neocafe.clientneocafe.data.api.retrofit.RetroFitInstance
import nur.xan.neocafe.clientneocafe.models.authModels.AuthSignUpModels
import nur.xan.neocafe.clientneocafe.models.sendCodeRegistrationModels.SendCodeRegistrationModels
import retrofit2.Response

class AuthRepository {

    fun postClientRegisterRepository(body: JsonObject): LiveData<Response<AuthSignUpModels>> =
        liveData {
            val response = RetroFitInstance.authController.postClientRegister(body)
            emit(response)
        }

    suspend fun sendCodeRegistrationRepository(phone: String): Response<SendCodeRegistrationModels> {
        return RetroFitInstance.authController.sendCodeRegistration(phone)
    }

    suspend fun verifyPhoneNumberRepository(phone: String, code: String): Response<SendCodeRegistrationModels> {
        return RetroFitInstance.authController.verifyPhoneNumber(phone, code)
    }

    suspend fun sendCodeLoginRepository(phone: String): Response<SendCodeRegistrationModels> {
        return RetroFitInstance.authController.sendCodeLogin(phone)
    }

    suspend fun signInLoginRepository(phone: String, code: String): Response<AuthSignUpModels> {
        return RetroFitInstance.authController.signInLogin(phone, code)
    }

}