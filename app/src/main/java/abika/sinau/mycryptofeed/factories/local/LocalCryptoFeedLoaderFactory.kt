package abika.sinau.mycryptofeed.factories.local

import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedLoader
import abika.sinau.mycryptofeed.crypto.feed.local.usecase.LocalCryptoFeedLoader

class LocalCryptoFeedLoaderFactory {
    companion object {
        fun createLocalCryptoFeedLoader(): CryptoFeedLoader {
            return LocalCryptoFeedLoader(CryptoFeedLocalFactory.createCryptoFeedLocal())
        }
    }
}