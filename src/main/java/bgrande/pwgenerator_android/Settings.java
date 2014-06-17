package bgrande.pwgenerator_android;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class Settings extends AbstractAppActivity
{

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _setWebView("options.html");
    }

    public void saveOptions(String options) {
        CharSequence result;
        boolean success;
        int duration = Toast.LENGTH_LONG;

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();
        success = editor.commit();

        if (success) {
            result = "Settings successfully saved!";
        } else {
            result = "Settings could not be saved!";
        }

        Toast toast = Toast.makeText(this, result, duration);
        toast.show();
    }

    public void goBack() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
        } else {
            finish();
        }
    }

}
