package rs.raf.jul.nikola_pantos_rn5117.data.login

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import rs.raf.jul.nikola_pantos_rn5117.data.models.Product

@Parcelize
data class User(
    val id:Int,
    val username:String,
    val email:String,
    val firstName:String,
    val lastName:String,
    val gender:String,
    val image:String,
    val token:String,
    val cart: List<Product>

): Parcelable {
}