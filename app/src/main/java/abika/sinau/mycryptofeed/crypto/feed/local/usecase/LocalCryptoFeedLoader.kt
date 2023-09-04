package abika.sinau.mycryptofeed.crypto.feed.local.usecase

import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedItemsMapper
import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedLoader
import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedResult
import abika.sinau.mycryptofeed.crypto.feed.local.LocalClientResult
import abika.sinau.mycryptofeed.crypto.feed.local.client.CryptoFeedLocalClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class LocalCryptoFeedLoader constructor(
    private val cryptoFeedLocalClient: CryptoFeedLocalClient
) : CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> {
        return flow {
            cryptoFeedLocalClient.getAllCrypto()
                .catch {
                    emit(CryptoFeedResult.Failure(it))
                }.collect { result ->
                    when (result) {
                        is LocalClientResult.Success -> {
                            emit(
                                CryptoFeedResult.Success(
                                    CryptoFeedItemsMapper.mapEntityToDomain(
                                        result.data
                                    )
                                )
                            )
                        }

                        is LocalClientResult.Failure -> {
                            emit(CryptoFeedResult.Failure(result.throwable))
                        }
                    }
                }
        }
    }

}