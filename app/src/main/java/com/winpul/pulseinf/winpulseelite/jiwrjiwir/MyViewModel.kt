package com.winpul.pulseinf.winpulseelite.jiwrjiwir

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    val someValue = ""
    val appsfSignalAppId = "JDt69d7fVFM33F6KuWHh5A"
    lateinit var advertisingId: String

    fun initializeAppsFlyer(context: Context,result: (MutableMap<String,Any>?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            advertisingId = getAdvertisingId(context) ?: ""

        }
        val conversionDataListener = object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(data: MutableMap<String, Any>) {
                result.invoke(data)
            }

            override fun onConversionDataFail(error: String?) {
                result.invoke(null)
            }

            override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
            }

            override fun onAttributionFailure(error: String?) {
            }
        }
        AppsFlyerLib.getInstance().init(appsfSignalAppId, conversionDataListener, context.applicationContext)
        AppsFlyerLib.getInstance().start(context)

    }

    fun buildFinalLink(baseLink: String, path: String, queryParams: Map<String, String>): String {
        val finalLinkBuilder = StringBuilder(baseLink)

        if (path.isNotEmpty() && !path.startsWith("/")) {
            finalLinkBuilder.append('/')
        }

        finalLinkBuilder.append(path)

        if (queryParams.isNotEmpty()) {
            finalLinkBuilder.append('?')

            for ((key, value) in queryParams) {
                finalLinkBuilder.append(encodeParameter(key))
                finalLinkBuilder.append('=')
                finalLinkBuilder.append(encodeParameter(value))
                finalLinkBuilder.append('&')
            }

            finalLinkBuilder.deleteCharAt(finalLinkBuilder.length - 1)
        }

        return finalLinkBuilder.toString()
    }

    private fun encodeParameter(parameter: String): String {
        return java.net.URLEncoder.encode(parameter, "UTF-8")
    }

    private fun getAdvertisingId(context: Context): String? {
        return try {
            AdvertisingIdClient.getAdvertisingIdInfo(context).id
        } catch (e: Exception) {
            null
        }
    }
}
