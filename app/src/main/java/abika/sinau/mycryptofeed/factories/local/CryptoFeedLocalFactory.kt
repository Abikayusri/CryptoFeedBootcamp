package abika.sinau.mycryptofeed.factories.local

import abika.sinau.mycryptofeed.MyApplication
import abika.sinau.mycryptofeed.crypto.feed.db.room.CryptoFeedDao
import abika.sinau.mycryptofeed.crypto.feed.db.room.CryptoFeedDatabase

class CryptoFeedLocalFactory {
    companion object {
        fun provideApplication(): MyApplication {
            return MyApplication.instance!!
        }

        fun createCryptoFeedLocal(): CryptoFeedDao {
            return CryptoFeedDatabase.getDatabase(provideApplication()).cryptoFeedDao()
        }
    }
}