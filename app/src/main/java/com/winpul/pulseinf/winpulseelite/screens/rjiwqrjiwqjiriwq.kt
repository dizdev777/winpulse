package com.winpul.pulseinf.winpulseelite.screens

import android.view.MotionEvent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.winpul.pulseinf.winpulseelite.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun rhjwqriqrwqriw(fhijqwirqwjriwi:MutableState<Int>, navController: NavController) {

    LaunchedEffect(key1 = Unit, block = {
        fhijqwirqwjriwi.value = 0
    })
    Image(
        painter = painterResource(id = R.drawable.field),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    val riwjqijqrjiwiq = remember {
        Animatable(0f)
    }
    val irwjqirqwfjiqw = remember {
        mutableStateOf(false)
    }
    val rhuwqhriqrjiw = remember{
        Animatable(0f)
    }
    val uwqrhqhrqjwriqw2 = remember{
        Animatable(0f)
    }
    val rwuhqriqjrjiwqji = LocalConfiguration.current.screenWidthDp/2
    val rhuwqriwiqjrjiqwrji = LocalConfiguration.current.screenHeightDp
    val fhiqwrihwjiqrw = remember{
        mutableIntStateOf(2600)
    }
    val fuhqwiriqjwrjiw = remember{
        Animatable(0f)
    }
    val ifjjiqwrjiqwri = remember {
        mutableStateOf(1f)
    }
    val jfiwqjriwrjwr = remember{
        mutableStateOf(3)
    }
    LaunchedEffect(key1 = Unit, block = {

        while (!irwjqirqwfjiqw.value) {
            ifjjiqwrjiqwri.value = 1f
            rhuwqhriqrjiw.snapTo((0..rwuhqriqjrjiwqji*2-70).random().toFloat())
            uwqrhqhrqjwriqw2.snapTo( (250..300).random().toFloat())
            fuhqwiriqjwrjiw.snapTo(0f)
            launch { fuhqwiriqjwrjiw.animateTo(490f, tween(fhiqwrihwjiqrw.value)) }
            
            launch {
                rhuwqhriqrjiw.animateTo(rwuhqriqjrjiwqji.toFloat()-(0..100).random().toFloat(), tween(fhiqwrihwjiqrw.value,0, FastOutSlowInEasing),)
            }
            launch {
                uwqrhqhrqjwriqw2.animateTo( 100f,tween(fhiqwrihwjiqrw.value/2,0, FastOutSlowInEasing))
                uwqrhqhrqjwriqw2.animateTo(rhuwqriwiqjrjiqwrji*0.8f,tween(fhiqwrihwjiqrw.value/2,0,
                    CubicBezierEasing(0.4f, 0.1f, 0.6f, 0.94f)))
            }
            riwjqijqrjiwiq.animateTo(1f, tween(fhiqwrihwjiqrw.value, 0, CubicBezierEasing(0.65f, 0.15f, 0.89f, 0.91f)))
            delay(150)
            if(ifjjiqwrjiqwri.value != 0f){
                jfiwqjriwrjwr.value--
            }
            riwjqijqrjiwiq.snapTo(0f)
        }
    })
        val fhqwjirijwi = remember{
            mutableStateOf(0f)
        }
    val fiqwrjwrjiwqir = remember{
        mutableStateOf(0f)
    }
    LaunchedEffect(key1 = Unit, block = {
        while (fhiqwrihwjiqrw.value>1400)
        {
            delay(fhiqwrihwjiqrw.value.toLong())
            fhiqwrihwjiqrw.intValue= (fhiqwrihwjiqrw.intValue * 0.98f).toInt()
        }
    })
    LaunchedEffect(key1 = jfiwqjriwrjwr.value, block = {
        if(jfiwqjriwrjwr.value == 0)
            navController.navigate("end"){
                launchSingleTop = true
            }
    })
    val fiqwjjriqwjrij = rememberInfiniteTransition()

    val fiwjqirjiwjir = remember{
        mutableStateOf(false)
    }
    val fhuqwirijqwjri = LocalDensity.current.density
        val fuhqwiriqwjri = remember{
            mutableStateOf(false)
        }
    val fjiqwirijqwrji = rememberCoroutineScope()
    LaunchedEffect(key1 = fiwjqirjiwjir.value, block = {
        while(true){
            delay(20)
           if(fhqwjirijwi.value/fhuqwirijqwjri-36<rhuwqhriqrjiw.value+16 && fhqwjirijwi.value/fhuqwirijqwjri-36+100 > rhuwqhriqrjiw.value+74
                && fiqwrjwrjiwqir.value/fhuqwirijqwjri-36<uwqrhqhrqjwriqw2.value+16 && fiqwrjwrjiwqir.value/fhuqwirijqwjri-36+100 > uwqrhqhrqjwriqw2.value+74
                && riwjqijqrjiwiq.value>0.5 && riwjqijqrjiwiq.value<0.75 && fiwjqirjiwjir.value){
                ifjjiqwrjiqwri.value = 0f
                fhijqwirqwjriwi.value++
               fjiqwirijqwrji.launch {
                   fuhqwiriqwjri.value = true
                   delay(2500)
                   fuhqwiriqwjri.value = false
               }
            }
        }


    })



    Box(modifier = Modifier
        .fillMaxSize()
        .pointerInteropFilter {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    fiwjqirjiwjir.value = true
                    fhqwjirijwi.value = it.x
                    fiqwrjwrjiwqir.value = it.y
                }

                MotionEvent.ACTION_MOVE -> {
                    fhqwjirijwi.value = it.x
                    fiqwrjwrjiwqir.value = it.y

                }

                MotionEvent.ACTION_UP -> {
                    fiwjqirjiwjir.value = false
                }

            }
            true
        }, contentAlignment = Alignment.Center
    ) {
        val iqwjirqwiriw = remember{
            Brush.verticalGradient(
                listOf(
                    Color(0xFFECC58D),
                    Color(0xFFC09A61)
                )
            )
        }
        val fijqjwijrqwirqwir = fiqwjjriqwjrij.animateFloat(initialValue = 0.3f, targetValue = 1f, animationSpec = InfiniteRepeatableSpec(
            tween(500,0, LinearEasing), repeatMode = RepeatMode.Reverse
        )
        )
        if(fuhqwiriqwjri.value){
            Text(
                text = "COLLECT!",
                fontFamily = FontFamily(Font(R.font.qwijqrji)),
                fontSize = 30.sp,
                letterSpacing = 3.sp,
                color = Color(0xFFFFFFFF),
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(16.dp)
                    .alpha(fijqjwijrqwirqwir.value)
            )
        }
        Row(modifier = Modifier
            .align(Alignment.BottomStart)
            .padding(16.dp)
            .background(iqwjirqwiriw, RoundedCornerShape(16.dp))
            .border(1.dp, Color(0xFF252525), RoundedCornerShape(16.dp))
            .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically){
            Text(
                text = "Lives:",
                fontFamily = FontFamily(Font(R.font.qwijqrji)),
                fontSize = 18.sp,
                letterSpacing = 2.sp,
                color = Color(0xFF1F1E1E),
                modifier = Modifier

            )
            repeat(jfiwqjriwrjwr.value){
                Image(painter = painterResource(id = R.drawable.ball),
                    contentDescription = "life",
                    modifier = Modifier.size(36.dp))
            }
        }


        Text(
            text = "Score: ${fhijqwirqwjriwi.value}",
            fontFamily = FontFamily(Font(R.font.qwijqrji)),
            fontSize = 30.sp,
            letterSpacing = 3.sp,
            color = Color(0xFF1F1E1E),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .background(iqwjirqwiriw, RoundedCornerShape(16.dp))
                .border(1.dp, Color(0xFF252525), RoundedCornerShape(16.dp))
                .padding(8.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ball),
            contentDescription = "ball",
            modifier = Modifier
                .graphicsLayer {
                    translationX = rhuwqhriqrjiw.value * fhuqwirijqwjri
                    translationY = uwqrhqhrqjwriqw2.value * fhuqwirijqwjri
                }
                .align(Alignment.TopStart)
                .rotate(fuhqwiriqjwrjiw.value)
                .scale(riwjqijqrjiwiq.value)
                .alpha(ifjjiqwrjiqwri.value)
                .size(90.dp)
        )
        if(fiwjqirjiwjir.value){
            Image(
                painter = painterResource(id = R.drawable.jifqwirwq),
                contentDescription = "fqwjrwqriijjiii",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .graphicsLayer {
                        translationX = fhqwjirijwi.value
                        translationY = fiqwrjwrjiwqir.value
                    }
                    .offset(-36.dp, -36.dp)
                    .size(100.dp)
            )
        }


    }


}