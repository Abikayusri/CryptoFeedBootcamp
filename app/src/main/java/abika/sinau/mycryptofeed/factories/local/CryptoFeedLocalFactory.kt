package abika.sinau.mycryptofeed.factories.local

import abika.sinau.mycryptofeed.crypto.feed.local.client.CryptoFeedLocalClient
import abika.sinau.mycryptofeed.crypto.feed.local.client.CryptoFeedLocalClientImpl
import abika.sinau.mycryptofeed.frameworks.LocalFactory

class CryptoFeedLocalFactory {
    companion object {
        fun createCryptoFeedLocal(): CryptoFeedLocalClient {
            return CryptoFeedLocalClientImpl(LocalFactory.getDatabase().cryptoFeedDao())
        }
    }
}