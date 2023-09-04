package abika.sinau.mycryptofeed.crypto.feed.local.room

import abika.sinau.mycryptofeed.crypto.feed.local.entity.CryptoFeedEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface CryptoFeedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cryptoFeed: List<CryptoFeedEntity>)

    @Query("SELECT * FROM crypto_feed")
    fun getAllCryptFeedItems(): Flow<List<CryptoFeedEntity>>
}