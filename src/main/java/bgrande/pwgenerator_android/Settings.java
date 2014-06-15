package bgrande.pwgenerator_android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class Settings extends Activity
{

    protected WebView webView;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebViewFactory webViewFactory = new WebViewFactory(this);
        this.webView = webViewFactory.create("options.html");

        setContentView(this.webView);
    }

    public void goBack() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
        } else {
            finish();
        }
    }

}
