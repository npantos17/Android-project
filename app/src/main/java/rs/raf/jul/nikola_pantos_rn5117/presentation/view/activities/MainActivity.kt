package rs.raf.jul.nikola_pantos_rn5117.presentation.view.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.jul.nikola_pantos_rn5117.R
import rs.raf.jul.nikola_pantos_rn5117.data.models.Filter
import rs.raf.jul.nikola_pantos_rn5117.presentation.contracts.ProductContract
import rs.raf.jul.nikola_pantos_rn5117.presentation.state.ProductState
import rs.raf.jul.nikola_pantos_rn5117.presentation.view.recycler.adapter.ProductsAdapter
import rs.raf.jul.nikola_pantos_rn5117.presentation.viewmodel.ProductsViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel:ProductContract.ViewModel by viewModel<ProductsViewModel>()

    private lateinit var productsAdapter: ProductsAdapter
    private var arrayAdapter: ArrayAdapter<String>?=null
    private var itemList = arrayOf("", "smarthpones","laptops","fragrances","skincare","groceries","home-decoration","furniture",
        "tops", "womens-dresses", "womens-shoes", "mens-shirts", "mens-shoes", "mens-watches",
    "womens-watches", "womens-bags", "womens-jewellery", "sunglasses", "automotive","motorcycle", "lighting")

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

//        val sharedPreference = getSharedPreferences(packageName, Context.MODE_PRIVATE)
//        val logged = sharedPreference.getBoolean("logged",false)
//
//        if(!logged){
//            val intent = Intent(this,
//                LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//
//        }



        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val sharedPreference = getSharedPreferences("login", Context.MODE_PRIVATE)
        val logged = sharedPreference.getBoolean("logged",false)


        if(!logged){
            val intent = Intent(this,
                LoginActivity::class.java)
            startActivity(intent)
            finish()

        }


//        val logoutBtn = findViewById<Button>(R.id.logoutBtn)
//        logoutBtn.setOnClickListener {
//            sharedPreference.edit().putBoolean("logged", false).apply()
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//        }

        var productsRv = findViewById<RecyclerView>(R.id.productsRv)
        var profileBtn = findViewById<Button>(R.id.profileBtn)
        var spinner = findViewById<Spinner>(R.id.categorySpinner)

        productsRv.layoutManager = LinearLayoutManager(this)
        productsAdapter = ProductsAdapter({
            val intent = Intent(this,ProductScreenActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)

        })
        productsRv.adapter = productsAdapter

        viewModel.productState.observe(this, Observer {
            renderState(it)
        })
        viewModel.getAllProducts()
        viewModel.fetchProducts()


        var btnFilter = findViewById<Button>(R.id.btnFilter)
        val search = findViewById<EditText>(R.id.search)

        btnFilter.setOnClickListener{
            val category = search.text.toString()

            val filter = Filter(category)
            viewModel.getFiltered(filter)

            spinner.setSelection(0)

        }
        profileBtn.setOnClickListener{
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)

        }

        arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,itemList)
        spinner.adapter = arrayAdapter


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                search.setText("")

                val filter = Filter(spinner.selectedItem.toString())
                viewModel.getFiltered(filter)

            }

        }






    }

    private fun renderState(state:ProductState){
        when(state){
            is ProductState.Success->{
                showLoadingState(false)
                //schedAdapter.setList(state.schedulers)
                productsAdapter.submitList(state.products)
//                System.out.println(state.products.size)
            }
            is ProductState.Error->{
                showLoadingState(false)
                Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
            }
            is ProductState.DataFetched->{
                showLoadingState(false)
                Toast.makeText(this, "Fresh data fetched from server", Toast.LENGTH_SHORT).show()
            }
            is ProductState.Loading->{
                showLoadingState(true)

            }
        }
    }

    private fun showLoadingState(loading: Boolean) {
        val loadingPb = findViewById<ProgressBar>(R.id.loadingPb)
        val scheduleRv = findViewById<RecyclerView>(R.id.productsRv)
        //binding.inputEt.isVisible = !loading
        scheduleRv.isVisible= !loading
        loadingPb.isVisible = loading
    }

}