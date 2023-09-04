package abika.sinau.mycryptofeed.crypto.feed.local

import abika.sinau.mycryptofeed.crypto.feed.local.entity.CryptoFeedEntity

sealed class LocalClientResult {

    data class Success(val data: List<CryptoFeedEntity>) : LocalClientResult()

    data class Failure(val throwable: Throwable) : LocalClientResult()
}