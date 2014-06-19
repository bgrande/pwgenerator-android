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
        String resultMessage;
        boolean success;

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("options", options);
        success = editor.commit();

        if (success) {
            resultMessage = "Settings successfully saved!";
        } else {
            resultMessage = "Settings could not be saved!";
        }

        _printToast(resultMessage);
    }

}
