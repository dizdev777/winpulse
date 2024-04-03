package com.winpul.pulseinf.winpulseelite.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.winpul.pulseinf.winpulseelite.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun rhiwqjrqwrwqriwq(navController:NavController){
    Image(painter = painterResource(id = R.drawable.bg),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize())
    val pagerState = rememberPagerState {
        2
    }
    val textIfFromPage = remember{
        listOf("In this game you have to catch a ball to score the most points. However, you can catch it in a certain area, just above the ground (about the middle of the screen). Determine the subtleties of the game and beat all the records!",
            "When you catch the ball, an inscription will appear at the top of the screen! Good luck to you!")
    }
    val imgIdFromPage = remember{
        listOf(
            R.drawable.run,
            R.drawable.collect)
    }
    HorizontalPager(state = pagerState) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = painterResource(id = imgIdFromPage[it]),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize(0.6f)
                        .clip(RoundedCornerShape(24.dp)),
                    contentScale = ContentScale.Crop
                )
                val gradik = remember {
                    Brush.verticalGradient(
                        listOf(
                            Color(0xFFF3CA8D),
                            Color(0xFFB99155)
                        )
                    )
                }
                Text(
                    text = textIfFromPage[it],
                    fontFamily = FontFamily(Font(R.font.qwijqrji)),
                    fontSize = 15.sp,
                    color = Color(0xFF252525),
                    letterSpacing = 1.5.sp,
                    modifier = Modifier
                        .background(gradik, AbsoluteCutCornerShape(16.dp))
                        .padding(16.dp)
                )
                val scope  = rememberCoroutineScope()
                IconButton(onClick = {
                    if(pagerState.canScrollForward){
                        scope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    }
                    else
                        navController.popBackStack()
                }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_arrow_right_alt_24),
                        contentDescription = "",
                        modifier = Modifier
                            .size(48.dp)
                            .background(
                                Color.White,
                                CircleShape
                            ))
                }
            }
        }

    }
}