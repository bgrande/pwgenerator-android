package bgrande.pwgenerator_android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebClientClass extends WebViewClient
{

    protected ProgressDialog pd = null;
    protected Activity generator;

    public WebClientClass(Activity generator) {
        this.generator = generator;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        pd = new ProgressDialog(this.generator);
        pd.setTitle("Please wait");
        pd.setMessage("Loading...");
        pd.show();
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        pd.dismiss();
    }

}