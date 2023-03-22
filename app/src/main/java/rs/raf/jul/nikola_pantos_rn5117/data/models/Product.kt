package rs.raf.jul.nikola_pantos_rn5117.data.models

import android.os.Parcelable
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val id: Long,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
//    val images: String
//    var images: List<String> = listOf()

): Parcelable{




}
