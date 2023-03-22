package rs.raf.jul.nikola_pantos_rn5117.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import rs.raf.jul.nikola_pantos_rn5117.data.login.LoginDao
import rs.raf.jul.nikola_pantos_rn5117.data.login.UserEntity
import rs.raf.jul.nikola_pantos_rn5117.data.models.Converters
import rs.raf.jul.nikola_pantos_rn5117.data.models.ProductEntity
import rs.raf.jul.nikola_pantos_rn5117.data.remote.ProductDao

@Database(
    entities = [ProductEntity::class, UserEntity::class],
    version = 2,
    exportSchema = false
)@TypeConverters(Converters::class)
abstract class StoreDatabase: RoomDatabase() {
    abstract fun getProductsDao(): ProductDao
    abstract fun getLoginDao(): LoginDao
}