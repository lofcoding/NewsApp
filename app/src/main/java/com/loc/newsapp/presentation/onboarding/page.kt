package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class page (
    val title : String,
    val description : String,
   @DrawableRes val image : Int
)

val pages = listOf(
    page(
        title = "Lorem ipsum is simply dummy",
        description = "Lorem ipsum is simply dummy text of the printing and typesetting inddustry",
        image = R.drawable.onboarding1
    ),
    page(
        title = "Lorem ipsum is simply dummy",
        description = "Lorem ipsum is simply dummy text of the printing and typesetting inddustry",
        image = R.drawable.onboarding2
    ),
    page(
        title = "Lorem ipsum is simply dummy",
        description = "Lorem ipsum is simply dummy text of the printing and typesetting inddustry",
        image = R.drawable.onboarding3
    )
)