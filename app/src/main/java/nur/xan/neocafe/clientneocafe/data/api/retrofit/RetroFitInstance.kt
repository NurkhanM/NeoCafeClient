package nur.xan.neocafe.clientneocafe.data.api.retrofit

import com.google.gson.GsonBuilder
import nur.xan.neocafe.clientneocafe.data.api.controller.authContr.AuthController
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


object RetroFitInstance {
    private val retrofit by lazy {

        val interceptor = HttpLoggingInterceptor()
//        val interceptor = TokenInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.MINUTES)
            .writeTimeout(15, TimeUnit.MINUTES) // write timeout
            .readTimeout(15, TimeUnit.MINUTES) // read timeout
            .addInterceptor(interceptor)
//            .addInterceptor(OAuthInterceptor("Bearer", TOKEN_USER))
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        Retrofit.Builder().baseUrl("http://104.248.32.77:8080")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }
    val authController: AuthController by lazy {
        retrofit.create(AuthController::class.java)
    }


}