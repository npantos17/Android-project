package rs.raf.jul.nikola_pantos_rn5117.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.jul.nikola_pantos_rn5117.data.models.Product
import rs.raf.jul.nikola_pantos_rn5117.databinding.LayoutItemProductBinding
import rs.raf.jul.nikola_pantos_rn5117.presentation.view.recycler.diff.ProductDIffCallback
import rs.raf.jul.nikola_pantos_rn5117.presentation.view.recycler.viewholder.ProductViewHolder

class ProductsAdapter (private val onProductClicked:(Product)->Unit): ListAdapter<Product, ProductViewHolder>(ProductDIffCallback())  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemBinding = LayoutItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(itemBinding, {
            val product = getItem(it)
            onProductClicked.invoke(product)

        })
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        //holder.bind(schedItemList.get(position))
        holder.bind(getItem(position))
    }

}