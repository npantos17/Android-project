package rs.raf.jul.nikola_pantos_rn5117.presentation.view.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import rs.raf.jul.nikola_pantos_rn5117.R
import rs.raf.jul.nikola_pantos_rn5117.data.login.LoginRequest
import rs.raf.jul.nikola_pantos_rn5117.data.login.LoginResponse
import rs.raf.jul.nikola_pantos_rn5117.data.login.LoginService
import rs.raf.jul.nikola_pantos_rn5117.presentation.contracts.LoginContract
import rs.raf.jul.nikola_pantos_rn5117.presentation.state.LoginState
import rs.raf.jul.nikola_pantos_rn5117.presentation.viewmodel.LoginViewModel

class LoginActivity (): AppCompatActivity() {


    private val viewModel:LoginContract.ViewModel by viewModel<LoginViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        initListeners()
    }

    private fun initListeners(){
        var loginBtn = findViewById<Button>(R.id.loginBtn)
        var emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE)


        viewModel.loginState.observe(this, Observer {
            when(it){
                is LoginState.Success->{
                    Toast.makeText(this,it.message, Toast.LENGTH_SHORT).show()
                    System.out.println("Uspesno logovanje")

//                    System.out.println(user.firstName)
                    sharedPreferences.edit().putBoolean("logged", true).apply()
//                    sharedPreferences.edit().putString("name", email).apply()
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                is LoginState.Error->{
                    Toast.makeText(this,it.message, Toast.LENGTH_SHORT).show()
                    System.out.println("Neuspesno logovanje")
                }
            }

        })

        loginBtn.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()



//            if(!email.equals("kminchelle") || !password.equals("0lelplR")){
//                Toast.makeText(this, "No such credentials", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
            val req = LoginRequest(email, password)

            val response = viewModel.login(req)





//            sharedPreferences.edit().putBoolean("logged", true).apply()
//            sharedPreferences.edit().putString("name", email).apply()
//
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//            finish()

        }

    }

    fun login(loginRequest: LoginRequest){
//        val loginResponseCall = loginService.login(loginRequest)

//        loginService.login(loginRequest).enqueue(callback)


    }
}