package rs.raf.jul.nikola_pantos_rn5117.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseProducts (val products: List<ProductResponse>){

}