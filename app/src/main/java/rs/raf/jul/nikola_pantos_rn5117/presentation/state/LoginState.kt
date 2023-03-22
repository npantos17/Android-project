package rs.raf.jul.nikola_pantos_rn5117.presentation.state

sealed class LoginState {
    data class Success(val message:String):LoginState()
    data class Error(val message:String):LoginState()
}