package rs.raf.jul.nikola_pantos_rn5117.data.repository

import io.reactivex.Observable
import rs.raf.jul.nikola_pantos_rn5117.data.models.Filter
import rs.raf.jul.nikola_pantos_rn5117.data.models.Product
import rs.raf.jul.nikola_pantos_rn5117.data.models.ProductEntity
import rs.raf.jul.nikola_pantos_rn5117.data.models.Resource
import rs.raf.jul.nikola_pantos_rn5117.data.remote.ProductDao
import rs.raf.jul.nikola_pantos_rn5117.data.remote.ProductService
import timber.log.Timber

class ProductRepositoryImpl (private val localDataSource : ProductDao, private val remoteDataSource : ProductService):ProductRepository{
    override fun fetchAll(): Observable<Resource<Unit>> {
        return remoteDataSource.getAll()
            .doOnNext {
                Timber.e("Upis u bazu")
                val entities = it.products.map {
                    ProductEntity(0,
                        it.title,
                        it.description,
                        it.price,
                        it.discountPercentage,
                        it.rating,
                        it.stock,
                        it.brand,
                        it.category,
                        it.thumbnail,
//                        it.images
                    )
                }
                localDataSource.deleteAndInsertAll(entities)
            }
            .map {
                Resource.Success(Unit)
            }
    }

    override fun getAll(): Observable<List<Product>> {
        return localDataSource
            .getAll()
            .map {
                it.map {
                    Product(
                        it.id,
                        it.title,
                        it.description,
                        it.price,
                        it.discountPercentage,
                        it.rating,
                        it.stock,
                        it.brand,
                        it.category,
                        it.thumbnail,
//                        it.images
                    )
                }
            }
    }



    override fun filter(filter: Filter): Observable<List<Product>> {
        val rawData: Observable<List<Product>> = getAll()

        return rawData.map {
            it.filter {
                (it.category.contains(filter.category, true))
            }
        }
    }


}