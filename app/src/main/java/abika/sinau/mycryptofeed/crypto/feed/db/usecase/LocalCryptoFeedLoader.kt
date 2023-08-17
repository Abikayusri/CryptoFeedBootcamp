package abika.sinau.mycryptofeed.crypto.feed.db.usecase

import abika.sinau.mycryptofeed.crypto.feed.db.room.CryptoFeedDao
import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedItemsMapper
import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedLoader
import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedResult
import abika.sinau.mycryptofeed.crypto.feed.http.usecases.Connectivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LocalCryptoFeedLoader constructor(
    private val cryptoFeedDao: CryptoFeedDao
) : CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> {
        return flow {
            try {
                val data = cryptoFeedDao.getAllCryptFeedItems()

                if (data.isNotEmpty()) {
                    emit(CryptoFeedResult.Success(CryptoFeedItemsMapper.mapEntityToDomain(data)))
                } else {
                    emit(CryptoFeedResult.Failure(Connectivity()))
                }
            } catch (e: Exception) {
                emit(CryptoFeedResult.Failure(Connectivity()))
            }
        }.flowOn(Dispatchers.IO)
    }

}