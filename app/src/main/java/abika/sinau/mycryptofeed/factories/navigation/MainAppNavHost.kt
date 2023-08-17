package abika.sinau.mycryptofeed.factories.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import abika.sinau.mycryptofeed.crypto.details.navigation.cryptoDetailScreen
import abika.sinau.mycryptofeed.crypto.details.navigation.navigateToCryptoDetails
import abika.sinau.mycryptofeed.crypto.feed.ui.navigation.cryptoGraph
import abika.sinau.mycryptofeed.crypto.feed.ui.navigation.cryptoGraphRoute

@Composable
fun MainAppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = cryptoGraphRoute
) {
    NavHost(
        navController = navHostController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        cryptoGraph(
            onCryptoClick = navHostController::navigateToCryptoDetails
        ) {
            cryptoDetailScreen(
                popBackStack = navHostController::popBackStack
            )
        }
    }
}