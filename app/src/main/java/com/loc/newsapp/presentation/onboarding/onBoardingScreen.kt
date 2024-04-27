package com.loc.newsapp.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.loc.newsapp.presentation.common.NewsButton
import com.loc.newsapp.presentation.common.NewsTextButton
import com.loc.newsapp.presentation.onboarding.Dimens.MediumPadding2
import com.loc.newsapp.presentation.onboarding.Dimens.pageIndicatorWidth
import com.loc.newsapp.presentation.onboarding.components.onboardingPage
import com.loc.newsapp.presentation.onboarding.components.pageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun onBoardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(0) {
            pages.size
        }
        val scope = rememberCoroutineScope()
        val buttonState = remember{
            derivedStateOf {
                when(pagerState.currentPage){
                    0 -> listOf("","Next")
                    1 -> listOf("Back","Next")
                    2 -> listOf("Back","Get started")
                    else -> listOf("","")
                }
            }
        }
        HorizontalPager(state = pagerState) {index ->
            onboardingPage(page = pages[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            pageIndicator(modifier = Modifier.width(pageIndicatorWidth),pageSize = pages.size, selectedPage = pagerState.currentPage)
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (buttonState.value[0].isNotEmpty()){
                    NewsTextButton(
                        text = buttonState.value[0],
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(page = pagerState.currentPage -1)
                            }
                        }
                    )
                }
                NewsButton(text = buttonState.value[1]) {
                    scope.launch {
                        if (pagerState.currentPage == 2){
//                        TODO: navigate to home screen
                            pagerState.animateScrollToPage(page = pagerState.initialPage)

                        }else{
                            pagerState.animateScrollToPage(page = pagerState.currentPage +1)
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}