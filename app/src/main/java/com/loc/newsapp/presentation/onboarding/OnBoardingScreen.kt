package com.loc.newsapp.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.loc.newsapp.presentation.Dimens.MediumPadding2
import com.loc.newsapp.presentation.Dimens.MediumPadding3

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    val isSystemInDarkMode = isSystemInDarkTheme()
    val systemUiColor = rememberSystemUiController()
    SideEffect {
        systemUiColor.setSystemBarsColor(
            color = Color.Black.copy(0.1f),
            darkIcons = isSystemInDarkMode
        )
    }
    Box(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }
        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MediumPadding3, start = MediumPadding2, end = MediumPadding2)
                .background(Color.Black)
        ) {

        }
    }
}