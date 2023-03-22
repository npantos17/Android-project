package rs.raf.jul.nikola_pantos_rn5117.data.login

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponse (
    val id:Int,
    val username:String,
    val email:String,
    val firstName:String,
    val lastName:String,
    val gender:String,
    val image:String,
    val token:String

        ){
}