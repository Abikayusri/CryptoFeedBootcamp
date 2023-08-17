package abika.sinau.mycryptofeed.crypto.feed.db.room

import abika.sinau.mycryptofeed.crypto.feed.db.entity.CryptoFeedEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface CryptoFeedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cryptoFeed: List<CryptoFeedEntity>)

    @Query("SELECT * FROM crypto_feed")
    suspend fun getAllCryptFeedItems(): List<CryptoFeedEntity>
}