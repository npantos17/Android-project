package rs.raf.jul.nikola_pantos_rn5117.data.repository

import io.reactivex.Observable
import rs.raf.jul.nikola_pantos_rn5117.data.models.Filter
import rs.raf.jul.nikola_pantos_rn5117.data.models.Product
import rs.raf.jul.nikola_pantos_rn5117.data.models.Resource

interface ProductRepository {

    fun fetchAll(): Observable<Resource<Unit>>
    fun getAll(): Observable<List<Product>>

    fun filter(filter: Filter): Observable<List<Product>>
}