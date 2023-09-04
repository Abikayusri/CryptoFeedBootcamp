package abika.sinau.mycryptofeed.crypto.feed.http.usecases

import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedItemsMapper
import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedLoader
import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedResult
import abika.sinau.mycryptofeed.crypto.feed.http.ConnectivityException
import abika.sinau.mycryptofeed.crypto.feed.http.CryptoFeedHttpClient
import abika.sinau.mycryptofeed.crypto.feed.http.HttpClientResult
import abika.sinau.mycryptofeed.crypto.feed.http.InvalidDataException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteCryptoFeedLoader constructor(
    private val cryptoFeedHttpClient: CryptoFeedHttpClient,
) :
    CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> = flow {
        cryptoFeedHttpClient.get().collect { result ->
            when (result) {
                is HttpClientResult.Success -> {
                    val cryptoFeed = result.root.data
                    if (cryptoFeed.isNotEmpty()) {
                        val cryptoFeedRemote = CryptoFeedItemsMapper.map(cryptoFeed)

                        emit(CryptoFeedResult.Success(cryptoFeedRemote))
                    } else {
                        emit(CryptoFeedResult.Success(emptyList()))
                    }
                }

                is HttpClientResult.Failure -> {
                    when (result.throwable) {
                        is ConnectivityException -> {
                            emit(CryptoFeedResult.Failure(Connectivity()))
                        }

                        is InvalidDataException -> {
                            emit(CryptoFeedResult.Failure(InvalidData()))
                        }
                    }
                }
            }
        }
    }
}

class InvalidData : Throwable()
class Connectivity : Throwable()