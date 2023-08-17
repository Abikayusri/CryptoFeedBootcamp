package abika.sinau.mycryptofeed.crypto.feed.db.room

import abika.sinau.mycryptofeed.crypto.feed.db.entity.CryptoFeedEntity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CryptoFeedEntity::class], version = 1)
abstract class CryptoFeedDatabase : RoomDatabase() {
    abstract fun cryptoFeedDao(): CryptoFeedDao

    companion object {
        const val DATABASE_NAME = "crypto_database"

        @Volatile
        private var INSTANCE: CryptoFeedDatabase? = null

        fun getDatabase(context: Context): CryptoFeedDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CryptoFeedDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}