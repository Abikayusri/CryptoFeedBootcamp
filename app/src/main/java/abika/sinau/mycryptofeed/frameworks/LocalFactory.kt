package abika.sinau.mycryptofeed.frameworks

import abika.sinau.mycryptofeed.MyApplication
import abika.sinau.mycryptofeed.crypto.feed.local.room.CryptoFeedDatabase
import androidx.room.Room

object LocalFactory {
    lateinit var application: MyApplication

    @Volatile
    private var INSTANCE: CryptoFeedDatabase? = null

    fun getDatabase(): CryptoFeedDatabase {
        val tempInstance = INSTANCE
        if (tempInstance != null) {
            return tempInstance
        }

        synchronized(this) {
            val instance = Room.databaseBuilder(
                application.applicationContext,
                CryptoFeedDatabase::class.java,
                "crypto_database"
            ).build()
            INSTANCE = instance
            return instance
        }
    }
}