package rs.raf.jul.nikola_pantos_rn5117.data.models

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ProductResponse (
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
        ){
}