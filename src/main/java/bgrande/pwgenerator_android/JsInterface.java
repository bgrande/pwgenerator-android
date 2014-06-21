package bgrande.pwgenerator_android;

import android.webkit.JavascriptInterface;

public class JsInterface
{

    protected AbstractAppActivity activity;

    public JsInterface(AbstractAppActivity activity) {
        this.activity = activity;
    }

    @JavascriptInterface
    public void cancelOptions() {
        _close();
    }

    /**
     * @param options String stringified json object
     */
    @JavascriptInterface
    public void saveOptions(String options) {
        activity.saveOptions(options);
        _close();
    }

    @JavascriptInterface
    public String loadOptions() {
        return activity.loadOptions();
    }

    @JavascriptInterface
    public void copyToClipboard(String word) {
        Generate activity = (Generate) this.activity;
        activity.copyToClipboard(word);
    }

    protected void _close() {
        activity.finish();
    }

}
