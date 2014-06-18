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

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("options", options);
        success = editor.commit();

        if (success) {
            result = "Settings successfully saved!";
        } else {
            result = "Settings could not be saved!";
        }

        Toast toast = Toast.makeText(this, result, Toast.LENGTH_LONG);
        toast.show();
    }

}
