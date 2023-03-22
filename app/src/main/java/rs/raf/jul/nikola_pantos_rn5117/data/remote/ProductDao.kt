package rs.raf.jul.nikola_pantos_rn5117.data.remote

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.jul.nikola_pantos_rn5117.data.models.ProductEntity

@Dao
abstract class ProductDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    abstract fun insert(entity: ProductEntity): Completable

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    abstract fun insertAll(entities: List<ProductEntity>): Completable

    @Query("SELECT * FROM products")
    abstract fun getAll(): Observable<List<ProductEntity>>

    @Query("DELETE FROM products")
    abstract fun deleteAll()

    @Transaction
    open fun deleteAndInsertAll(entities: List<ProductEntity>) {
        deleteAll()
        insertAll(entities).blockingAwait()
    }

}