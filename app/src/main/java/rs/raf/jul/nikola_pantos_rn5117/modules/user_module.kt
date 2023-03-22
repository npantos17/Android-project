package rs.raf.jul.nikola_pantos_rn5117.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.jul.nikola_pantos_rn5117.data.database.StoreDatabase
import rs.raf.jul.nikola_pantos_rn5117.data.login.LoginService
import rs.raf.jul.nikola_pantos_rn5117.data.repository.UserRepository
import rs.raf.jul.nikola_pantos_rn5117.data.repository.UserRepositoryImpl
import rs.raf.jul.nikola_pantos_rn5117.presentation.viewmodel.LoginViewModel

val user_module = module {
    viewModel {
        LoginViewModel(get())
    }

    single<UserRepository>{
        UserRepositoryImpl(
            loginService = get(), localDataSourse = get()
        )
    }
    single {
        get<StoreDatabase>().getLoginDao()
    }
    single<LoginService> {
        create(get())
    }
}