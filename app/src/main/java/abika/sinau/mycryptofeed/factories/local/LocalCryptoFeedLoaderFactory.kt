package abika.sinau.mycryptofeed.factories.local

import abika.sinau.mycryptofeed.crypto.feed.db.usecase.LocalCryptoFeedLoader
import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedLoader

class LocalCryptoFeedLoaderFactory {
    companion object {
        fun createLocalCryptoFeedLoader(): CryptoFeedLoader {
            return LocalCryptoFeedLoader(CryptoFeedLocalFactory.createCryptoFeedLocal())
        }
    }
}