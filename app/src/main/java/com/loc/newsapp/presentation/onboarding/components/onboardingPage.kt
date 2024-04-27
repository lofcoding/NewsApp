package com.loc.newsapp.presentation.onboarding.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.loc.newsapp.R
import com.loc.newsapp.presentation.onboarding.Dimens
import com.loc.newsapp.presentation.onboarding.Dimens.MediumPadding1
import com.loc.newsapp.presentation.onboarding.Dimens.MediumPadding2
import com.loc.newsapp.presentation.onboarding.page
import com.loc.newsapp.presentation.onboarding.pages
import com.loc.newsapp.ui.theme.NewsAppTheme

@Composable
fun onboardingPage(
    modifier: Modifier = Modifier,
    page : page
) {
        Column(modifier = modifier) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f),
                painter = painterResource(id = page.image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(MediumPadding1))
            Text(
                text = page.title,
                modifier = Modifier.padding(horizontal = MediumPadding2),
                style = MaterialTheme.typography.displaySmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = colorResource(id = R.color.display_small)
            )
            Text(
                text = page.description,
                modifier = Modifier.padding(horizontal = MediumPadding2),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = colorResource(id = R.color.text_medium)
            )
        }
}
@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,showBackground = true)
@Composable
fun ShowOnBOardingpage(){
    NewsAppTheme{
        Surface(modifier = Modifier.fillMaxSize()) {
            onboardingPage(page = pages[0])
        }
    }
}