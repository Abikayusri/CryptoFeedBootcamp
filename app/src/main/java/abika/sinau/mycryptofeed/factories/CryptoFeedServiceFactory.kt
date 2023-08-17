package abika.sinau.mycryptofeed.main.factories

import abika.sinau.mycryptofeed.frameworks.HttpFactory
import abika.sinau.mycryptofeed.crypto.feed.http.CryptoFeedService

class CryptoFeedServiceFactory {
    companion object {
        fun createCryptoFeedService(): CryptoFeedService {
            return HttpFactory.createRetrofit(
                HttpFactory.createMoshi(),
                HttpFactory.createOkhttpClient(
                    HttpFactory.createLoggingInterceptor()
                )
            ).create(CryptoFeedService::class.java)
        }
    }
}