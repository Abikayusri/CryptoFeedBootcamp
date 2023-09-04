package abika.sinau.mycryptofeed.factories.decorator

import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedLoader
import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CryptoFeedLoaderCacheDecorator(
    private val decorate: CryptoFeedLoader,
    private val cache: CryptoFeedCache
) : CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> {
        return flow {
            decorate.load().collect { result ->
                if (result is CryptoFeedResult.Success) {
                    cache.save(result.cryptoFeedItems)
                }
                emit(result)
            }
        }
    }
}