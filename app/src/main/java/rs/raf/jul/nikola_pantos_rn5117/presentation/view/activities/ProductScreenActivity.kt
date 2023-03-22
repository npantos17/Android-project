package rs.raf.jul.nikola_pantos_rn5117.presentation.view.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import rs.raf.jul.nikola_pantos_rn5117.R
import rs.raf.jul.nikola_pantos_rn5117.data.models.Product

class ProductScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_screen)

        val product = intent.getParcelableExtra<Product>("product") as Product


        val titleTv = findViewById<TextView>(R.id.detailsTitleTv)
        val descriptionTv = findViewById<TextView>(R.id.detailsDescriptionTv)
        val priceTv = findViewById<TextView>(R.id.detailsPriceTv)
        val discountTv = findViewById<TextView>(R.id.detailsDiscountTv)
        val ratingTv = findViewById<TextView>(R.id.detailsRatingTv)
        val brandTv = findViewById<TextView>(R.id.detailsBrandTv)
        val categoryTv = findViewById<TextView>(R.id.detailsCategoryTv)
        val addToCartBtn = findViewById<Button>(R.id.addToCartBtn)

        titleTv.setText(product.title)
        descriptionTv.setText(product.description)
        priceTv.setText(product.price.toString())
        discountTv.setText(product.discountPercentage.toString())
        brandTv.setText(product.brand)
        categoryTv.setText(product.category)
        ratingTv.setText(product.rating.toString())

        if(product.rating < 4.2){
            ratingTv.setTextColor(Color.RED)
        }else if(product.rating >= 4.2 && product.rating <= 4.4){
            ratingTv.setTextColor(Color.YELLOW)

        }else if(product.rating > 4.4 && product.rating <= 4.6){
            ratingTv.setTextColor(Color.YELLOW)

        }else if(product.rating > 4.6 && product.rating <= 4.8){
            ratingTv.setTextColor(Color.GREEN)

        }else if(product.rating > 4.6 && product.rating <= 5.0){
            ratingTv.setTextColor(Color.GREEN)

        }







    }



    override fun onBackPressed() {
        finish()
    }
}