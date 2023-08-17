package abika.sinau.mycryptofeed

import android.app.Application

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: abika.sinau.mycryptofeed.Application? = null
    }
}