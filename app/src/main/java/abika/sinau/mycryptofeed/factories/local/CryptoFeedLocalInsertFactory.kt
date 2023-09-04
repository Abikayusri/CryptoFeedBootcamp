package abika.sinau.mycryptofeed.factories.local

import abika.sinau.mycryptofeed.crypto.feed.local.usecase.LocalCryptoFeedInsert
import abika.sinau.mycryptofeed.factories.decorator.CryptoFeedCache

class CryptoFeedLocalInsertFactory {
    companion object {
        fun createLocalCryptoFeedLoader(): CryptoFeedCache {
            return LocalCryptoFeedInsert(CryptoFeedLocalFactory.createCryptoFeedLocal())
        }
    }
}