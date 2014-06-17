package bgrande.pwgenerator_android;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Settings extends AbstractAppActivity
{

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _setWebView("options.html");
    }

    public void saveOptions(String options) {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.commit();
    }

    public void goBack() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
        } else {
            finish();
        }
    }

}
