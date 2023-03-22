package rs.raf.jul.nikola_pantos_rn5117.data.login

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class UserEntity (
    @PrimaryKey(autoGenerate = true) var id:Int,
    val username:String,
    val email:String,
    val firstName:String,
    val lastName:String,
    val gender:String,
    val image:String,
    val token:String
        ) {
}