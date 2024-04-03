package com.winpul.pulseinf.winpulseelite.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.winpul.pulseinf.winpulseelite.R

@Composable
fun HURIirhwhqurwhqrhi(navController: NavController){
    Image(painter = painterResource(id = R.drawable.splash),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize())
    val anim = remember{
        Animatable(0f)
    }
    LaunchedEffect(key1 = Unit, block = {
        anim.animateTo(100f, tween(900,0, LinearEasing))
        navController.navigate("home")
    })
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(24.dp)){
            Text(text = "${anim.value.toInt()} %",
                fontFamily = FontFamily(Font(R.font.qwijqrji)),
                fontSize = 26.sp,
                color = Color(0xFF6EC20E))
            LinearProgressIndicator(progress = anim.value / 100f, color = Color(0xFF6EC20E),
                trackColor = Color(0xFF43631E),
                modifier = Modifier.size(130.dp,16.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
        }
    }
    
}