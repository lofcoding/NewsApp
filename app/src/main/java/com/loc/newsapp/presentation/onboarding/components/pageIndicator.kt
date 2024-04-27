package com.loc.newsapp.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.loc.newsapp.presentation.onboarding.Dimens.IndicatorSize
import com.loc.newsapp.ui.theme.BlueGray

@Composable
fun pageIndicator(
    modifier: Modifier = Modifier,
    pageSize : Int,
    selectedPage : Int,
    selectedColor : Color = MaterialTheme.colorScheme.primary,
    unSelectedColor : Color = BlueGray
) {
    Row (modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween){
//        repeat index(page) start from 0
        repeat(pageSize){page ->
            Box(
                modifier = Modifier.size(IndicatorSize).clip(CircleShape)
                    .background(if (page == selectedPage) selectedColor else unSelectedColor)
            )
        }
    }
}