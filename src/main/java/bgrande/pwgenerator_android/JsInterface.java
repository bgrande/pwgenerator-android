package bgrande.pwgenerator_android;

import android.app.Activity;
import android.util.JsonReader;
import android.webkit.JavascriptInterface;

public class JsInterface
{

    protected AbstractAppActivity activity;

    public JsInterface(AbstractAppActivity activity) {
        this.activity = activity;
    }

    @JavascriptInterface
    public void cancelOptions() {
        this._goBackToGenerator();
    }

    /**
     * @param options String stringified json object
     */
    @JavascriptInterface
    public void saveOptions(String options) {
        activity.saveOptions(options);
        this._goBackToGenerator();
    }

    @JavascriptInterface
    public String loadOptions() {
        return activity.loadOptions();
    }

    protected void _goBackToGenerator() {
        if (this.activity instanceof Settings) {
            Settings settings = (Settings) this.activity;
            settings.goBack();
        }
    }

}
