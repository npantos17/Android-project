package rs.raf.jul.nikola_pantos_rn5117.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.jul.nikola_pantos_rn5117.data.database.StoreDatabase
import rs.raf.jul.nikola_pantos_rn5117.data.remote.ProductService
import rs.raf.jul.nikola_pantos_rn5117.data.repository.ProductRepository
import rs.raf.jul.nikola_pantos_rn5117.data.repository.ProductRepositoryImpl
import rs.raf.jul.nikola_pantos_rn5117.presentation.viewmodel.ProductsViewModel

val product_module = module {
    viewModel {
        ProductsViewModel(get())
    }

    single<ProductRepository>{
        ProductRepositoryImpl(
            remoteDataSource = get(), localDataSource = get()
        )
    }
    single {
        get<StoreDatabase>().getProductsDao()
    }
    single<ProductService> {
        create(get())
    }

}