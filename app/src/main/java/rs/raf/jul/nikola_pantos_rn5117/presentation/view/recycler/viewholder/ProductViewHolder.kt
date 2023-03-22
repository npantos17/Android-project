package rs.raf.jul.nikola_pantos_rn5117.presentation.view.recycler.viewholder

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import rs.raf.jul.nikola_pantos_rn5117.data.models.Product
import rs.raf.jul.nikola_pantos_rn5117.databinding.LayoutItemProductBinding
import java.util.function.Consumer

//class ProductViewHolder(private val view: LayoutItemProductBinding, private val onProductClicked:(Int)->Unit) : RecyclerView.ViewHolder(view.root) {
class ProductViewHolder(private val view: LayoutItemProductBinding, private val onProductClicked:(Int)->Unit) : RecyclerView.ViewHolder(view.root) {


    init{
//        view.thumbnailImg.setOnClickListener{
//            onProductClicked.invoke(adapterPosition)
//        }
//        view.titleTv.setOnClickListener{
//            onProductClicked.invoke(adapterPosition)
//        }
//        view.priceTv.setOnClickListener{
//            onProductClicked.invoke(adapterPosition)
//        }
//        view.ratingTv.setOnClickListener{
//            onProductClicked.invoke(adapterPosition)
//        }
        view.root.setOnClickListener{
            onProductClicked.invoke(adapterPosition)
        }


    }

    fun bind(product: Product){
        view.titleTv.setText(product.title)
        view.priceTv.setText(product.price.toString())
//        view.priceTv.setText("2000")
        view.ratingTv.setText(product.rating.toString())

        if(product.rating < 4.2){
            view.ratingTv.setTextColor(Color.RED)
        }else if(product.rating >= 4.2 && product.rating <= 4.4){
            view.ratingTv.setTextColor(Color.YELLOW)

        }else if(product.rating > 4.4 && product.rating <= 4.6){
            view.ratingTv.setTextColor(Color.YELLOW)

        }else if(product.rating > 4.6 && product.rating <= 4.8){
            view.ratingTv.setTextColor(Color.GREEN)

        }else if(product.rating > 4.6 && product.rating <= 5.0){
            view.ratingTv.setTextColor(Color.GREEN)

        }

        Glide.with(itemView).load(product.thumbnail).into(view.thumbnailImg)




    }

}