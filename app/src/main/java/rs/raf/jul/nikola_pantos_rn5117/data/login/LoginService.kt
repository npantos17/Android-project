package rs.raf.jul.nikola_pantos_rn5117.data.login

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.*

interface LoginService {

    @POST("/auth/login")
    fun login(@Body loginRequest: LoginRequest): Observable<LoginResponse>

//    @POST("/auth/login")
//    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>
}