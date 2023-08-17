package abika.sinau.mycryptofeed.crypto.feed.domain

import abika.sinau.mycryptofeed.crypto.feed.db.entity.CryptoFeedEntity
import abika.sinau.mycryptofeed.crypto.feed.http.RemoteCryptoFeedItem

class CryptoFeedItemsMapper {
    companion object {
        fun map(items: List<RemoteCryptoFeedItem>): List<CryptoFeedItem> {
            return items.map {
                CryptoFeedItem(
                    coinInfo = CoinInfoItem(
                        it.remoteCoinInfo.id.orEmpty(),
                        it.remoteCoinInfo.name.orEmpty(),
                        it.remoteCoinInfo.fullName.orEmpty(),
                        it.remoteCoinInfo.imageUrl.orEmpty()
                    ),
                    raw = RawItem(
                        usd = UsdItem(
                            it.remoteRaw.usd.price ?: 0.0,
                            it.remoteRaw.usd.changePctDay ?: 0F
                        )
                    )
                )
            }
        }

        fun mapRemoteToEntity(items: List<RemoteCryptoFeedItem>): List<CryptoFeedEntity> {
            return items.map {
                CryptoFeedEntity(
                    id = it.remoteCoinInfo.id.orEmpty(),
                    name = it.remoteCoinInfo.name.orEmpty(),
                    fullName = it.remoteCoinInfo.fullName.orEmpty(),
                    imageUrl = it.remoteCoinInfo.imageUrl.orEmpty(),
                    price = it.remoteRaw.usd.price?: 0.0,
                    changePctDay = it.remoteRaw.usd.changePctDay?: 0F
                )
            }
        }

        fun mapEntityToDomain(items: List<CryptoFeedEntity>): List<CryptoFeedItem> {
            return items.map {
                CryptoFeedItem(
                    coinInfo = CoinInfoItem(
                        it.id,
                        it.name,
                        it.fullName,
                        it.imageUrl
                    ),
                    raw = RawItem(
                        usd = UsdItem(
                            it.price,
                            it.changePctDay
                        )
                    )
                )
            }
        }
    }
}