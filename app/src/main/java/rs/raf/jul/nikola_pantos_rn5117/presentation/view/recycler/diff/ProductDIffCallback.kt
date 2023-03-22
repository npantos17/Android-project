package rs.raf.jul.nikola_pantos_rn5117.presentation.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.jul.nikola_pantos_rn5117.data.models.Product

class ProductDIffCallback():DiffUtil.ItemCallback<Product>() {

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }


    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.title==newItem.title && oldItem.description == newItem.description
                && oldItem.price == newItem.price && oldItem.discountPercentage == newItem.discountPercentage &&
                oldItem.rating == newItem.rating && oldItem.stock == newItem.stock  && oldItem.brand == newItem.brand
                && oldItem.category == newItem.category && oldItem.thumbnail == newItem.thumbnail
    }
}