package rs.raf.jul.nikola_pantos_rn5117.presentation.state

import rs.raf.jul.nikola_pantos_rn5117.data.models.Product

sealed class ProductState{
    object Loading: ProductState()
    object DataFetched: ProductState()
    data class Success(val products: List<Product>): ProductState()
    data class Error(val message: String): ProductState()
}
