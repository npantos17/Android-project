package rs.raf.jul.nikola_pantos_rn5117.presentation.contracts

import androidx.lifecycle.LiveData
import rs.raf.jul.nikola_pantos_rn5117.presentation.state.ProductState
import java.util.logging.Filter

interface ProductContract {

    interface ViewModel {
        val productState: LiveData<ProductState>

        fun fetchProducts()
        fun getAllProducts()
        fun getFiltered(filter: rs.raf.jul.nikola_pantos_rn5117.data.models.Filter)
    }
}