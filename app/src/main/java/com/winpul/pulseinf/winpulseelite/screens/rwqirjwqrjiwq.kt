package com.winpul.pulseinf.winpulseelite.screens

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.winpul.pulseinf.winpulseelite.R

@Composable
fun ruwhqrjiwqijrwq(score:Int, navController: NavController){
    Image(painter = painterResource(id = R.drawable.end),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize())
    val ruhwqrjiqwjirjiqwji = remember{
        Brush.verticalGradient(
            listOf(
                Color(0xFFECC58D),
                Color(0xFFC09A61)
            )
        )
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(24.dp)){
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .background(ruhwqrjiqwjirjiqwji, RoundedCornerShape(16.dp))
                    .border(1.dp, Color(0xFF252525), RoundedCornerShape(16.dp))
                    .padding(16.dp)){
                Text(
                    text = "Game over!",
                    fontFamily = FontFamily(Font(R.font.qwijqrji)),
                    fontSize = 38.sp,
                    letterSpacing = 3.sp,
                    color = Color(0xFF1F1E1E),

                )
                Text(
                    text = "Your score: ${score}",
                    fontFamily = FontFamily(Font(R.font.qwijqrji)),
                    fontSize = 46.sp,
                    letterSpacing = 3.sp,
                    color = Color(0xFF1F1E1E),

                )
            }

            Spacer(modifier = Modifier.size(16.dp))
            Box(modifier = Modifier
                .background(
                    ruhwqrjiqwjirjiqwji,
                    RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .clickable {
                    navController.popBackStack()
                }
                .border(1.dp, Color(0xFF252525), RoundedCornerShape(16.dp))
                .padding(16.dp)
                .padding(horizontal = 16.dp)
            ) {
                Text(text = "Retry",
                    fontFamily = FontFamily(Font(R.font.qwijqrji)),
                    fontSize = 26.sp,
                    letterSpacing = 2.sp,
                    color = Color(0xFF252525))
            }
            val ctx = LocalContext.current as Activity
            Box(modifier = Modifier
                .background(
                    ruhwqrjiqwjirjiqwji,
                    RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .clickable {
                    ctx.finishAffinity()
                }
                .border(1.dp, Color(0xFF252525), RoundedCornerShape(16.dp))
                .padding(16.dp)
                .padding(horizontal = 16.dp)
            ) {
                Text(text = "Exit",
                    fontFamily = FontFamily(Font(R.font.qwijqrji)),
                    fontSize = 26.sp,
                    letterSpacing = 2.sp,
                    color = Color(0xFF252525))
            }
        }
    }
}