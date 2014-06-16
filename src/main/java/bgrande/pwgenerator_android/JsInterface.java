package bgrande.pwgenerator_android;

import android.app.Activity;
import android.webkit.JavascriptInterface;

public class JsInterface
{

    protected Activity activity;

    public JsInterface(Activity activity) {
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
        Settings activity = this._getActivity();

        activity.saveOptions(options);
        this._goBackToGenerator();
    }

    @JavascriptInterface
    public void loadOptions() {
        Settings activity = this._getActivity();

        activity.loadOptions();
    }

    protected Settings _getActivity() {
        return (Settings) this.activity;
    }

    protected void _goBackToGenerator() {
        if (this.activity instanceof Settings) {
            Settings settings = (Settings) this.activity;
            settings.goBack();
        }
    }

}
