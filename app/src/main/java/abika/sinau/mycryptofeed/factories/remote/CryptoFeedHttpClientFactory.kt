package abika.sinau.mycryptofeed.factories.remote

import abika.sinau.mycryptofeed.crypto.feed.http.CryptoFeedHttpClient
import abika.sinau.mycryptofeed.crypto.feed.http.CryptoFeedRetrofitHttpClient

class CryptoFeedHttpClientFactory {
    companion object {
        fun createCryptoFeedHttpClient(): CryptoFeedHttpClient {
            return CryptoFeedRetrofitHttpClient(
                CryptoFeedServiceFactory.createCryptoFeedService()
            )
        }
    }
}