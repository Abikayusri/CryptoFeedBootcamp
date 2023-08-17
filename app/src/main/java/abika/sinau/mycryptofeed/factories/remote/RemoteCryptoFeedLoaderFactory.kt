package abika.sinau.mycryptofeed.factories.remote

import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedLoader
import abika.sinau.mycryptofeed.crypto.feed.http.usecases.RemoteCryptoFeedLoader
import abika.sinau.mycryptofeed.factories.local.CryptoFeedLocalFactory

class RemoteCryptoFeedLoaderFactory {
    companion object {
        fun createRemoteCryptoFeedLoader(): CryptoFeedLoader {
            return RemoteCryptoFeedLoader(
                CryptoFeedHttpClientFactory.createCryptoFeedHttpClient(),
//                CryptoFeedLocalFactory.createCryptoFeedLocal()
            )
        }
    }
}