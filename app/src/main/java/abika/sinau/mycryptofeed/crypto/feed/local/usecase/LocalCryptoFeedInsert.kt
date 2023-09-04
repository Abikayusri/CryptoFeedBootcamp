package abika.sinau.mycryptofeed.crypto.feed.local.usecase

import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedItem
import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedItemsMapper
import abika.sinau.mycryptofeed.crypto.feed.local.client.CryptoFeedLocalClient
import abika.sinau.mycryptofeed.factories.decorator.CryptoFeedCache

class LocalCryptoFeedInsert constructor(
    private val cryptoFeedLocalClient: CryptoFeedLocalClient
) : CryptoFeedCache {
    override suspend fun save(data: List<CryptoFeedItem>) {
        val mappingData = CryptoFeedItemsMapper.mapRemoteToLocalEntity(data)
        cryptoFeedLocalClient.insert(mappingData)
    }
}