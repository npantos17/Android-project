package rs.raf.jul.nikola_pantos_rn5117.presentation.contracts

import android.database.Observable
import androidx.lifecycle.LiveData
import rs.raf.jul.nikola_pantos_rn5117.data.login.LoginRequest
import rs.raf.jul.nikola_pantos_rn5117.data.login.LoginResponse
import rs.raf.jul.nikola_pantos_rn5117.data.login.UserEntity
import rs.raf.jul.nikola_pantos_rn5117.presentation.state.LoginState

interface LoginContract {

    interface ViewModel{
        val loginState: LiveData<LoginState>
        fun login(loginRequest: LoginRequest)
//        fun getUser(): UserEntity
        fun getUser(): io.reactivex.Observable<UserEntity>

    }
}