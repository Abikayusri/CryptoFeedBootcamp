package abika.sinau.mycryptofeed

import abika.sinau.mycryptofeed.frameworks.LocalFactory
import android.app.Application

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LocalFactory.application = this
    }
}