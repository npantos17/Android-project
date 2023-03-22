package rs.raf.jul.nikola_pantos_rn5117.data.login

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.jul.nikola_pantos_rn5117.data.models.ProductEntity

@Dao
abstract class LoginDao {

//    @Insert( onConflict = OnConflictStrategy.REPLACE )
//    abstract fun insert(entity: ProductEntity): Completable

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    abstract fun login(entities: UserEntity): Completable

//    @Query("SELECT * FROM users")
//    abstract fun getAll(): Observable<List<ProductEntity>>

    @Query("DELETE FROM users")
    abstract fun deleteAll()

    @Query("SELECT * FROM users WHERE id=0")
    abstract fun getUser(): Observable<UserEntity>

    @Transaction
    open fun deleteAndInsertAll(entity: UserEntity) {
        deleteAll()
        login(entity).blockingAwait()
    }

}