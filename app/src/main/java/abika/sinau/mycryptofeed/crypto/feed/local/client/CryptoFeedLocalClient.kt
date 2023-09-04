package abika.sinau.mycryptofeed.crypto.feed.local.client

import abika.sinau.mycryptofeed.crypto.feed.local.LocalClientResult
import abika.sinau.mycryptofeed.crypto.feed.local.entity.CryptoFeedEntity
import kotlinx.coroutines.flow.Flow

interface CryptoFeedLocalClient {
    suspend fun insert(dataInsert: List<CryptoFeedEntity>)

    fun getAllCrypto(): Flow<LocalClientResult>
}