package rs.raf.jul.nikola_pantos_rn5117.presentation.viewmodel

import android.database.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.jul.nikola_pantos_rn5117.data.login.LoginRequest
import rs.raf.jul.nikola_pantos_rn5117.data.login.LoginResponse
import rs.raf.jul.nikola_pantos_rn5117.data.login.UserEntity
import rs.raf.jul.nikola_pantos_rn5117.data.repository.UserRepository
import rs.raf.jul.nikola_pantos_rn5117.presentation.contracts.LoginContract
import rs.raf.jul.nikola_pantos_rn5117.presentation.state.LoginState

class LoginViewModel(private val userRepository: UserRepository): ViewModel(), LoginContract.ViewModel {

    override val loginState: MutableLiveData<LoginState> = MutableLiveData()

    private val subscriptions = CompositeDisposable()
    override fun login(loginRequest: LoginRequest) {

        val subscription = userRepository.login(loginRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loginState.value  = LoginState.Success("Login success")
            },
                {
                    loginState.value = LoginState.Error("Invalid credentials")
                })
        subscriptions.add(subscription)
//        userRepository.login(loginRequest)

    }

    override fun getUser(): io.reactivex.Observable<UserEntity> {
        val subscription = userRepository.getUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({

            })
        subscriptions.add(subscription)

        return userRepository.getUser()
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }


}