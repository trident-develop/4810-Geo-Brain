package com.ironhidegames.android.ironmari.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ironhidegames.android.ironmari.data.PrefsManager
import com.ironhidegames.android.ironmari.ui.screens.CountryDetailScreen
import com.ironhidegames.android.ironmari.ui.screens.LoadingScreen
import com.ironhidegames.android.ironmari.ui.screens.MainScreen
import com.ironhidegames.android.ironmari.ui.screens.ResultScreen
import com.ironhidegames.android.ironmari.ui.screens.Tab
import com.ironhidegames.android.ironmari.ui.screens.TestTakingScreen

/**
 * All navigable destinations in the app. A hand-rolled nav stack is used instead
 * of navigation-compose to keep the dependency footprint minimal.
 */
sealed class Screen {
    data object Loading : Screen()
    data object Main : Screen()
    data class CountryDetail(val countryId: String) : Screen()
    data class TestTaking(val testId: Int) : Screen()
    data class TestResult(
        val testId: Int,
        val score: Int,
        val total: Int,
        val correct: Int,
        val incorrect: Int,
        val timeExpired: Boolean
    ) : Screen()
}

@Composable
fun GeoBrainApp(prefs: PrefsManager) {
    val backStack = remember { mutableStateListOf<Screen>(Screen.Loading) }
    val current = backStack.lastOrNull() ?: Screen.Loading

    // Lifted main-tab selection — survives pushes/pops of detail screens so
    // back from TestTaking/CountryDetail lands on the original tab.
    var mainTab by remember { mutableStateOf(Tab.Learn) }

    // Intercept the system back button on any pushed screen (anything above Main).
    // Leaves Loading/Main alone so the system can close the app from the root.
    val canGoBack = backStack.size > 1 && current !is Screen.Loading
    BackHandler(enabled = canGoBack) {
        backStack.removeAt(backStack.lastIndex)
    }

    AnimatedContent(
        targetState = current,
        modifier = Modifier.fillMaxSize(),
        transitionSpec = {
            (slideInHorizontally { it / 6 } + fadeIn()) togetherWith
                    (slideOutHorizontally { -it / 8 } + fadeOut())
        },
        label = "nav"
    ) { screen ->
        when (screen) {
            Screen.Loading -> LoadingScreen(
                onDone = {
                    backStack.clear()
                    backStack.add(Screen.Main)
                }
            )

            Screen.Main -> MainScreen(
                prefs = prefs,
                currentTab = mainTab,
                onTabChange = { mainTab = it },
                onOpenCountry = { id ->
                    mainTab = Tab.Learn
                    backStack.add(Screen.CountryDetail(id))
                },
                onOpenTest = { id ->
                    mainTab = Tab.Tests
                    backStack.add(Screen.TestTaking(id))
                }
            )

            is Screen.CountryDetail -> CountryDetailScreen(
                countryId = screen.countryId,
                onBack = { if (backStack.size > 1) backStack.removeAt(backStack.lastIndex) }
            )

            is Screen.TestTaking -> TestTakingScreen(
                testId = screen.testId,
                prefs = prefs,
                onFinish = { result ->
                    if (backStack.size > 1) backStack.removeAt(backStack.lastIndex)
                    backStack.add(result)
                },
                onBack = { if (backStack.size > 1) backStack.removeAt(backStack.lastIndex) }
            )

            is Screen.TestResult -> ResultScreen(
                result = screen,
                onRetry = {
                    if (backStack.size > 1) backStack.removeAt(backStack.lastIndex)
                    backStack.add(Screen.TestTaking(screen.testId))
                },
                onBack = { if (backStack.size > 1) backStack.removeAt(backStack.lastIndex) }
            )
        }
    }
}
