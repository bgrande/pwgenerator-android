package bgrande.pwgenerator_android;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;
import android.widget.Toast;

abstract public class AbstractAppActivity extends ActionBarActivity
{
    protected static final String PREFS_NAME = "GeneratorOptions";

    protected WebView webView;

    protected void _setWebView(String resource) {
        WebViewFactory webViewFactory = new WebViewFactory(this);
        this.webView = webViewFactory.create(resource);

        setContentView(this.webView);
    }

    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        this.webView.reload();
    }

    public void saveOptions(String options) {
        // do nothing
    }

    public String loadOptions() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, 0);
        String options = preferences.getString("options", "{}");

        return options;
    }

    public void copyToClipboard(String word) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        ClipData clip = ClipData.newPlainText("pw", word);
        clipboard.setPrimaryClip(clip);

        String toastTest = "copied " + word + " to clipboard!";

        Toast toast = Toast.makeText(this, toastTest, Toast.LENGTH_LONG);
        toast.show();
    }
}