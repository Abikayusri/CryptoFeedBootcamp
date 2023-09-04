package abika.sinau.mycryptofeed.crypto.feed.composite

import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedLoader
import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class CryptoFeedLoaderComposite(
    private val primary: CryptoFeedLoader,
    private val fallback: CryptoFeedLoader
) : CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> {
        return flow {
            primary.load().collect {
                try {
                    primary.load().collect {
                        when (it) {
                            is CryptoFeedResult.Success -> emit(it)
                            is CryptoFeedResult.Failure -> emit(fallback.load().first())
                        }
                    }
                } catch (e: Exception) {
                    fallback.load()
                }
            }
        }
    }

}