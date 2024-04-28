package com.loc.newsapp

import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.loc.newsapp.preferences.useCases.Cases
import com.loc.newsapp.presentation.onboarding.onBoardingScreen
import com.loc.newsapp.presentation.onboarding.viewModels.onBoardingViewModel
import com.loc.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

// application playlist : https://www.youtube.com/playlist?list=PLzZEuVaFb9Exi-pc8qtHBrrLg8bUn-TP6
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var cases: Cases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        to make the app screen behind the systemBar(statusBar)
//        and you can see this solution : https://www.youtube.com/watch?v=pPNtAU1prB8 and https://www.youtube.com/watch?v=q8PQnNo11Bk
        WindowCompat.setDecorFitsSystemWindows(window,false)
//to install the splash screen
        installSplashScreen()
        lifecycleScope.launch {
            cases.readAppEntry().collect{
                Log.d("Saved",it.toString())
            }
        }
        setContent {
            NewsAppTheme {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)){
                    val boardViewModel : onBoardingViewModel = hiltViewModel()
                    onBoardingScreen(boardViewModel::onEvent)
                }
            }
        }
    }
}
