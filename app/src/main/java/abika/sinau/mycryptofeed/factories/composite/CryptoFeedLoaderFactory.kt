package abika.sinau.mycryptofeed.factories.composite

import abika.sinau.mycryptofeed.crypto.feed.composite.CryptoFeedLoaderComposite
import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedLoader

class CryptoFeedLoaderFactory {
    companion object {
        fun createCryptoFeedLoaderCompositeFactory(
            primary: CryptoFeedLoader,
            secondary: CryptoFeedLoader
        ): CryptoFeedLoader {
            return CryptoFeedLoaderComposite(primary, secondary)
        }
    }
}