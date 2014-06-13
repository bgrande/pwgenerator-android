package bgrande.pwgenerator_android;

import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewFactory
{

    protected WebView webView;
    protected JsInterface jsInterface;

    public WebViewFactory(Activity activity) {
        this.webView = new WebView(activity);

        this.webView.setClickable(true);
        WebSettings wSettings = webView.getSettings();

        wSettings.setJavaScriptEnabled(true);
        wSettings.setDomStorageEnabled(true);

        /**
         * <b> Support Classes For WebView </b>
         */
        WebClientClass webViewClient = new WebClientClass(activity);
        this.webView.setWebViewClient(webViewClient);

        WebChromeClient webChromeClient = new WebChromeClient();
        this.webView.setWebChromeClient(webChromeClient);

        this.jsInterface = new JsInterface(activity);

    }

    public WebView create(String assetName) {
        /** Now Added Java Interface Class */
        this.webView.addJavascriptInterface(this.jsInterface, "Android");
        /** Load Our Custom JS Inside WebView */
        webView.loadUrl("file:///android_asset/" + assetName);

        return this.webView;
    }

}
