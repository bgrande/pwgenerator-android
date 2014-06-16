package bgrande.pwgenerator_android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebView;

public class Settings extends Activity
{
    protected static final String PREFS_NAME = "GeneratorOptions";

    protected WebView webView;

    public void saveOptions(String options) {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.commit();
    }

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebViewFactory webViewFactory = new WebViewFactory(this);
        this.webView = webViewFactory.create("options.html");

        setContentView(this.webView);
    }

    public String loadOptions() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, 0);
        String settings = preferences.getString("settings", "{}");

        return settings;
    }

    public void goBack() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
        } else {
            finish();
        }
    }

}
