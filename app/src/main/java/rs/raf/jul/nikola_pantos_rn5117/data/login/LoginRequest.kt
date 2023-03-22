package rs.raf.jul.nikola_pantos_rn5117.data.login

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest (var username:String, var password: String){



    private fun init(username:String,  password: String){
       this.username = username
       this.password = password

   }

    private fun getUsernamee(): String{
        return username
    }
    private  fun getPass(): String{
        return password;
    }
}