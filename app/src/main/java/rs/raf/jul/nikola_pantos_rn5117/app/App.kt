package rs.raf.jul.nikola_pantos_rn5117.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import rs.raf.jul.nikola_pantos_rn5117.modules.core_module
import rs.raf.jul.nikola_pantos_rn5117.modules.product_module
import rs.raf.jul.nikola_pantos_rn5117.modules.user_module
import timber.log.Timber

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init(){
        initTimber()
        initKoin()
    }

    private fun initTimber(){
        Timber.plant(Timber.DebugTree())
    }
    private fun initKoin(){
        val modules = listOf(
            core_module,
            user_module,
            product_module



        )
        startKoin {
            androidLogger(Level.ERROR)
//            androidLogger(Level.DEBUG)
            androidContext(this@App)
            androidFileProperties()
            fragmentFactory()
            modules(modules)
        }
    }
}