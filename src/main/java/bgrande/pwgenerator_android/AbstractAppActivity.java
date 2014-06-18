package bgrande.pwgenerator_android;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;

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

}