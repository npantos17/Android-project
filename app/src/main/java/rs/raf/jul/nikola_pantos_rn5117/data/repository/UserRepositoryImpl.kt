package rs.raf.jul.nikola_pantos_rn5117.data.repository

import android.content.Context
import android.content.SharedPreferences
import io.reactivex.Observable
import rs.raf.jul.nikola_pantos_rn5117.data.login.*
import rs.raf.jul.nikola_pantos_rn5117.data.models.Resource
import rs.raf.jul.nikola_pantos_rn5117.presentation.view.activities.ProfileActivity

class UserRepositoryImpl (private val localDataSourse:LoginDao,  private val loginService: LoginService) : UserRepository{
//class UserRepositoryImpl (private val loginService: LoginService) : UserRepository{


    override fun login(loginRequest: LoginRequest): Observable<Resource<Unit>> {
//        val response = loginService.login(loginRequest)

//        return response.map { Resource.Success(Unit) }
        return loginService.login(loginRequest).map {
           val entity = UserEntity(
                it.id,
                it.username,
                it.email,
                it.firstName,
                it.lastName,
                it.gender,
                it.image,
                it.token
            )
//            localDataSourse.login(entity)
            ProfileActivity.userEntity = entity
            localDataSourse.deleteAndInsertAll(entity)
        }.map {
            Resource.Success(Unit)
        }
    }

//    override fun getUser(): UserEntity {
//        return localDataSourse.getUser()
//    }
    override fun getUser(): Observable<UserEntity> {
        return localDataSourse.getUser()
    }


}