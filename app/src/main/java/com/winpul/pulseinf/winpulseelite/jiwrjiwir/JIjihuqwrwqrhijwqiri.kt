package com.winpul.pulseinf.winpulseelite.jiwrjiwir

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.PermissionRequest
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.winpul.pulseinf.winpulseelite.databinding.ActivityGameBonusBinding

class JIjihuqwrwqrhijwqiri : AppCompatActivity() {
    private var qwijrjiqwjirqwr: ValueCallback<Array<Uri>>? = null
    private var iqwjriqwrqwrjiwh2: ActivityResultLauncher<Intent>? = null

    lateinit var jfqworjuqwjri: ActivityGameBonusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jfqworjuqwjri = ActivityGameBonusBinding.inflate(layoutInflater)
        setContentView(jfqworjuqwjri.root)
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(jfqworjuqwjri.gameBonus,true)
        ijqwrqwiriiqwiriwj2()
        qwjirjiqwrijwqirji()
        megasutijqwi(this)
        qwiru82urjaiwriajirji()
        intent.getStringExtra("url")?.let { jfqworjuqwjri.gameBonus.loadUrl(it) }

    }

    override fun onBackPressed() {
        if (jfqworjuqwjri.gameBonus.canGoBack())
            jfqworjuqwjri.gameBonus.goBack()
        else
            super.onBackPressed()
    }
   fun ijqwrqwiriiqwiriwj2(){
       jfqworjuqwjri.gameBonus.settings.apply {
           javaScriptEnabled=true
           domStorageEnabled=true
           javaScriptCanOpenWindowsAutomatically=true
           useWideViewPort = true
           databaseEnabled = true
           loadWithOverviewMode = true
           builtInZoomControls = true
           displayZoomControls = false
           allowFileAccess = true
           allowContentAccess = true
       }
   }
    fun qwjirjiqwrijwqirji(){
        CookieManager.allowFileSchemeCookies()
        CookieManager.getInstance().acceptThirdPartyCookies(jfqworjuqwjri.gameBonus)
        jfqworjuqwjri.gameBonus.webViewClient= object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                jfqworjuqwjri.gameBonus.visibility = View.VISIBLE
                CookieManager.getInstance().flush()
            }

            override fun shouldOverrideUrlLoading(
                qwijrhqwriqwrij: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                val url = request?.url.toString()
                if (url.startsWith("http")) {
                    qwijrhqwriqwrij?.loadUrl(url)
                } else {
                    try {
                        if (ContextCompat.checkSelfPermission(
                                this@JIjihuqwrwqrhijwqiri.applicationContext,
                                android.Manifest.permission.CAMERA
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {
                            ActivityCompat.requestPermissions(
                                this@JIjihuqwrwqrhijwqiri,
                                arrayOf(android.Manifest.permission.CAMERA),
                                201
                            )
                        } else {
                            try {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                this@JIjihuqwrwqrhijwqiri.startActivity(intent)
                            } catch (e: ActivityNotFoundException) {
                                val intent = Intent(Intent.ACTION_GET_CONTENT,Uri.parse(url))
                                intent.addCategory(Intent.CATEGORY_OPENABLE)
                                intent.type = "*/*"
                                this@JIjihuqwrwqrhijwqiri.startActivity(intent)
                            }

                        }


                    } catch (e: Exception) {

                    }

                }
                return true
            }
        }
    }
    private fun megasutijqwi(appCompatActivity: AppCompatActivity) {
        iqwjriqwrqwrjiwh2 = appCompatActivity.activityResultRegistry.register(
            "UploadFile",
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                if (result.data != null) {
                    val uri: Uri? = result.data?.data
                    if (uri != null && qwijrjiqwjirqwr != null) {
                        qwijrjiqwjirqwr?.onReceiveValue(arrayOf(uri))
                        qwijrjiqwjirqwr = null
                    }
                }
            }
            else
            {
                qwijrjiqwjirqwr?.onReceiveValue(null)
                qwijrjiqwjirqwr = null
            }
        }
    }
    fun qwiru82urjaiwriajirji(){
        jfqworjuqwjri.gameBonus.webChromeClient = object : WebChromeClient() {
            override fun onPermissionRequest(request: PermissionRequest?) {
                if (request?.resources?.contains("android.permission.CAMERA") == true || request?.resources?.contains(
                        "android.webkit.resource.VIDEO_CAPTURE"
                    ) == true
                ) {
                    if (ContextCompat.checkSelfPermission(
                            this@JIjihuqwrwqrhijwqiri,
                            Manifest.permission.CAMERA
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(
                            this@JIjihuqwrwqrhijwqiri,
                            arrayOf(Manifest.permission.CAMERA),
                            201
                        )
                    } else {
                        request.grant(request.resources)
                    }
                } else {
                    super.onPermissionRequest(request)
                }
            }
            override fun onShowFileChooser(
                webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    val zaresheniegkdfgkdfgjdf = ContextCompat.checkSelfPermission(
                        this@JIjihuqwrwqrhijwqiri,
                        android.Manifest.permission.READ_MEDIA_IMAGES
                    )
                    if (zaresheniegkdfgkdfgjdf != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(
                            this@JIjihuqwrwqrhijwqiri, arrayOf(android.Manifest.permission.READ_MEDIA_IMAGES), 300
                        )
                    }
                    else
                    {
                        if (qwijrjiqwjirqwr != null) {
                            qwijrjiqwjirqwr?.onReceiveValue(null)
                            qwijrjiqwjirqwr = null
                        }
                        qwijrjiqwjirqwr = filePathCallback
                        val intent = Intent(Intent.ACTION_GET_CONTENT)
                        intent.addCategory(Intent.CATEGORY_OPENABLE)
                        intent.type = "*/*"
                        iqwjriqwrqwrjiwh2?.launch(Intent.createChooser(intent, "File Browser"))
                        return true
                    }
                } else {
                    val qhwurijiqwrwjirji2 =
                        ContextCompat.checkSelfPermission(
                            this@JIjihuqwrwqrhijwqiri,
                            android.Manifest.permission.READ_EXTERNAL_STORAGE
                        )
                    if (qhwurijiqwrwjirji2 != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(
                            this@JIjihuqwrwqrhijwqiri, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                            200
                        )
                    }
                    else
                    {
                        if (qwijrjiqwjirqwr != null) {
                            qwijrjiqwjirqwr?.onReceiveValue(null)
                            qwijrjiqwjirqwr = null
                        }
                        qwijrjiqwjirqwr = filePathCallback
                        val qiwrjqwrijiqwrjiqwr2 = Intent(Intent.ACTION_GET_CONTENT)
                        qiwrjqwrijiqwrjiqwr2.addCategory(Intent.CATEGORY_OPENABLE)
                        qiwrjqwrijiqwrjiqwr2.type = "*/*"
                        iqwjriqwrqwrjiwh2?.launch(Intent.createChooser(qiwrjqwrijiqwrjiqwr2, "File Browser"))
                        return true
                    }

                }
                return false

            }
        }
    }
}