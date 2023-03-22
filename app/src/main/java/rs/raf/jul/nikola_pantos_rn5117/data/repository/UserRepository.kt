package rs.raf.jul.nikola_pantos_rn5117.data.repository

import io.reactivex.Observable
import rs.raf.jul.nikola_pantos_rn5117.data.login.LoginRequest
import rs.raf.jul.nikola_pantos_rn5117.data.login.LoginResponse
import rs.raf.jul.nikola_pantos_rn5117.data.login.User
import rs.raf.jul.nikola_pantos_rn5117.data.login.UserEntity
import rs.raf.jul.nikola_pantos_rn5117.data.models.Resource

interface UserRepository {

    fun login(loginRequest: LoginRequest): Observable<Resource<Unit>>

//    fun getUser(): UserEntity
    fun getUser(): Observable<UserEntity>
}