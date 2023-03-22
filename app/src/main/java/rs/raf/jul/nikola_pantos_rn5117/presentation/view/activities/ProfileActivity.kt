package rs.raf.jul.nikola_pantos_rn5117.presentation.view.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.jul.nikola_pantos_rn5117.R
import rs.raf.jul.nikola_pantos_rn5117.data.login.LoginRequest
import rs.raf.jul.nikola_pantos_rn5117.data.login.UserEntity
import rs.raf.jul.nikola_pantos_rn5117.presentation.contracts.LoginContract
import rs.raf.jul.nikola_pantos_rn5117.presentation.viewmodel.LoginViewModel

class ProfileActivity (): AppCompatActivity() {

    private val viewModel:LoginContract.ViewModel by viewModel<LoginViewModel>()
    companion object{
//        lateinit var userEntity: UserEntity
        var userEntity: UserEntity = UserEntity(0, "null","null", "null","null", "null", "null", "null")
    }
//    init {
//        instance = this
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

//        userEntity = UserEntity(0, "null","null", "null","null", "null", "null", "null")


        val sharedPreference = getSharedPreferences("login", Context.MODE_PRIVATE)
        if(!userEntity.firstName.equals("null")){
//            val req = LoginRequest("kminchelle", "0lelplR")
//
//            val response = viewModel.login(req)
            sharedPreference.edit().putString("username", userEntity.username).apply()
            sharedPreference.edit().putString("firstName", userEntity.firstName).apply()
            sharedPreference.edit().putString("lastName", userEntity.lastName).apply()
            sharedPreference.edit().putString("email", userEntity.email).apply()
            sharedPreference.edit().putString("gender", userEntity.gender).apply()
            sharedPreference.edit().putString("image", userEntity.image).apply()
        }

        val logoutBtn = findViewById<Button>(R.id.logoutBtn)
        logoutBtn.setOnClickListener {
            sharedPreference.edit().putBoolean("logged", false).apply()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val usernameTv = findViewById<TextView>(R.id.usernameTv)
        val emailTv = findViewById<TextView>(R.id.emailTv)
        val firstNameTv = findViewById<TextView>(R.id.firstNameTv)
        val lastNameTv = findViewById<TextView>(R.id.lastNameTv)
        val genderTv = findViewById<TextView>(R.id.genderTv)
        val profileImg = findViewById<ImageView>(R.id.profileImg)

//        System.out.println(userEntity.firstName)

//        usernameTv.setText(userEntity.username)
//        emailTv.setText(userEntity.email)
//        firstNameTv.setText(userEntity.firstName)
//        lastNameTv.setText(userEntity.lastName)
//        genderTv.setText(userEntity.gender)
//
////        Glide.with(itemView).load(product.thumbnail).into(view.thumbnailImg)
//        Glide.with(this).load(userEntity.image).into(profileImg)
        usernameTv.setText(sharedPreference.getString("username", ""))
        emailTv.setText(sharedPreference.getString("email", ""))
        firstNameTv.setText(sharedPreference.getString("firstName", ""))
        lastNameTv.setText(sharedPreference.getString("lastName", ""))
        genderTv.setText(sharedPreference.getString("gender", ""))

        Glide.with(this).load(sharedPreference.getString("image", "")).into(profileImg)



    }

    fun init(){
//        val user = viewModel.getUser()
//        var profileUser: UserEntity = UserEntity(2, "null", "null", "null", "null", "null", "null", "null")
//        user.map {
//            System.out.println(it.firstName)
//            profileUser = UserEntity(
//                it.id,
//                it.username,
//                it.email,
//                it.firstName,
//                it.lastName,
//                it.gender,
//                it.image,
//                it.token
//            )
//        }
        System.out.println(userEntity.firstName)

//        System.out.println(user.)
    }

    override fun onBackPressed() {
        finish()
    }
}