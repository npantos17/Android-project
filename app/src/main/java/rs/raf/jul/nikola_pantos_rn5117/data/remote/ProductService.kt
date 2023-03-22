package rs.raf.jul.nikola_pantos_rn5117.data.remote

import io.reactivex.Observable
import retrofit2.http.GET
import rs.raf.jul.nikola_pantos_rn5117.data.models.ProductResponse
import rs.raf.jul.nikola_pantos_rn5117.data.models.ResponseProducts

interface ProductService {
//    @GET("products")
//    fun getAll(): Observable<List<ProductResponse>>
      @GET("products")
      fun getAll(): Observable<ResponseProducts>
}