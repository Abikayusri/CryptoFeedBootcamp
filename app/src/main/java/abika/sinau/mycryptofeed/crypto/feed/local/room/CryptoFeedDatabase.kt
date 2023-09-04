package abika.sinau.mycryptofeed.crypto.feed.local.room

import abika.sinau.mycryptofeed.crypto.feed.local.entity.CryptoFeedEntity
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CryptoFeedEntity::class], version = 1)
abstract class CryptoFeedDatabase : RoomDatabase() {
    abstract fun cryptoFeedDao(): CryptoFeedDao
}