package abika.sinau.mycryptofeed.crypto.feed.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import abika.sinau.mycryptofeed.crypto.feed.domain.CryptoFeedItem
import abika.sinau.mycryptofeed.crypto.feed.ui.CryptoFeedRoute

const val cryptoGraphRoute = "crypto_graph_route"
const val cryptoFeedRoute = "crypto_feed_route"

fun NavGraphBuilder.cryptoGraph(
    onCryptoClick: (CryptoFeedItem) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = cryptoGraphRoute,
        startDestination = cryptoFeedRoute
    ) {
        composable(
            route = cryptoFeedRoute
        ) {
            CryptoFeedRoute(onNavigateToCryptoDetails = onCryptoClick)
        }
        nestedGraphs()
    }
}