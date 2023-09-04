package abika.sinau.mycryptofeed.factories.decorator

import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedItem


interface CryptoFeedCache {
    suspend fun save(data: List<CryptoFeedItem>)
}