package plurish.mobile.app

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import plurish.mobile.app.ui.theme.PlurishMobileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            WebViewScreen(url = "https://dev-capp-plurish-web.orangefield-901588cd.eastus.azurecontainerapps.io")
        }
    }
}

@Composable
fun WebViewScreen(url: String) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                webViewClient = object : WebViewClient() {
                    override fun onPageFinished(view: WebView?, url: String?) {
                        view?.scrollTo(0, 0)
                    }
                }
                settings.javaScriptEnabled = true;
                settings.cacheMode = WebSettings.LOAD_DEFAULT
                settings.useWideViewPort = true;
                settings.setSupportZoom(false)
                settings.loadWithOverviewMode = true
                loadUrl(url)
            }
        }
    )
}

@Preview
@Composable
fun WebViewScreenPreview() {
    PlurishMobileAppTheme {
        WebViewScreen(url = "https://dev-capp-plurish-web.orangefield-901588cd.eastus.azurecontainerapps.io")
    }
}