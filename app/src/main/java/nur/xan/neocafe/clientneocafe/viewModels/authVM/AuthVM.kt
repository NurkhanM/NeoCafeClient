package nur.xan.neocafe.clientneocafe.viewModels.authVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import nur.xan.neocafe.clientneocafe.models.authModels.AuthSignUpModels
import nur.xan.neocafe.clientneocafe.models.sendCodeRegistrationModels.SendCodeRegistrationModels
import nur.xan.neocafe.clientneocafe.repository.auth.AuthRepository
import retrofit2.Response

class AuthViewModels : ViewModel() {
    private val repo = AuthRepository()


    private val _myPostAllSignIn = MutableLiveData<JsonObject>()
    var mySendCodeRegistration: MutableLiveData<Response<SendCodeRegistrationModels>> = MutableLiveData()
    var mySendCodeLogin: MutableLiveData<Response<SendCodeRegistrationModels>> = MutableLiveData()
    var myVerifyPhoneNumber: MutableLiveData<Response<SendCodeRegistrationModels>> = MutableLiveData()
    var mySignInLogin: MutableLiveData<Response<AuthSignUpModels>> = MutableLiveData()



    val myClientRegister: LiveData<Response<AuthSignUpModels>> =
        _myPostAllSignIn.switchMap {
            repo.postClientRegisterRepository(it)
        }

    fun postClientRegister(body: JsonObject) {
        viewModelScope.launch {
            _myPostAllSignIn.postValue(body)
        }
    }

    fun sendCodeRegistration(phone: String) {
        viewModelScope.launch {
            mySendCodeRegistration.value = repo.sendCodeRegistrationRepository(phone)
        }
    }

    fun verifyPhoneNumber(phone: String, code: String) {
        viewModelScope.launch {
            myVerifyPhoneNumber.value = repo.verifyPhoneNumberRepository(phone, code)
        }
    }

    fun sendCodeLogin(phone: String) {
        viewModelScope.launch {
            mySendCodeLogin.value = repo.sendCodeLoginRepository(phone)
        }
    }

    fun signInLogin(phone: String, code: String) {
        viewModelScope.launch {
            mySignInLogin.value = repo.signInLoginRepository(phone, code)
        }
    }

}