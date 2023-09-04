package abika.sinau.mycryptofeed.crypto.feed.local.client

import abika.sinau.mycryptofeed.crypto.feed.local.LocalClientResult
import abika.sinau.mycryptofeed.crypto.feed.local.entity.CryptoFeedEntity
import abika.sinau.mycryptofeed.crypto.feed.local.room.CryptoFeedDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class CryptoFeedLocalClientImpl constructor(
    private val cryptoFeedDao: CryptoFeedDao
) : CryptoFeedLocalClient {

    override suspend fun insert(dataInsert: List<CryptoFeedEntity>) {
        cryptoFeedDao.insertAll(dataInsert)
    }

    override fun getAllCrypto(): Flow<LocalClientResult> {
        return flow {
            cryptoFeedDao.getAllCryptFeedItems()
                .catch {
                    emit(LocalClientResult.Failure(it))
                }.collect {
                    emit(LocalClientResult.Success(it))
                }
        }
    }
}