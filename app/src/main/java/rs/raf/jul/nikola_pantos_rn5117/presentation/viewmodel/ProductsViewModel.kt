package rs.raf.jul.nikola_pantos_rn5117.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.jul.nikola_pantos_rn5117.data.models.Resource
import rs.raf.jul.nikola_pantos_rn5117.data.repository.ProductRepository
import rs.raf.jul.nikola_pantos_rn5117.presentation.contracts.ProductContract
import rs.raf.jul.nikola_pantos_rn5117.presentation.state.ProductState
import timber.log.Timber
import java.util.logging.Filter

class ProductsViewModel(private val productRepository: ProductRepository): ViewModel(), ProductContract.ViewModel {

    override val productState: MutableLiveData<ProductState> = MutableLiveData()

    private val subscriptions = CompositeDisposable()

    override fun fetchProducts() {
        val subscription = productRepository.fetchAll()
            .startWith(Resource.Loading())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                when(it){
                    is Resource.Loading-> productState.value = ProductState.Loading
                    is Resource.Success-> productState.value = ProductState.DataFetched
                    is Resource.Error->productState.value = ProductState.Error("Error while fetching data 33")
                }
            },{
                productState.value = ProductState.Error("Error while fetching data")
                Timber.e(it)

            })
        subscriptions.add(subscription)
    }

    override fun getAllProducts() {
        System.out.println("uslo u get")
        val subscription = productRepository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                productState.value = ProductState.Success(it)
            },
                {
                    productState.value = ProductState.Error("Error while fetching from database")

                })
        subscriptions.add(subscription )
    }

    override fun getFiltered(filter: rs.raf.jul.nikola_pantos_rn5117.data.models.Filter) {
        val subscription = productRepository
            .filter(filter)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                productState.value = ProductState.Success(it)
            },
                {
                    productState.value = ProductState.Error("Error while fetching from database")

                })
        subscriptions.add(subscription )
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }
}