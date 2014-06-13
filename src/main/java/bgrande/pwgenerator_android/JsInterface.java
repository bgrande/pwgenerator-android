package bgrande.pwgenerator_android;

import android.app.Activity;
import android.content.Context;

import java.lang.reflect.Array;

public class JsInterface
{

    protected Context con;
    protected Activity activity;


    public JsInterface(Activity activity) {
        this.con = activity;
        this.activity = activity;
    }

    public void cancelOptions() {
        this._goBackToGenerator();

    }

    public void saveOptions(Array options) {
        // @todo save options and
        this._goBackToGenerator();
    }

    protected void _goBackToGenerator() {
        if (this.activity instanceof Settings) {
            Settings settings = (Settings) this.activity;
            settings.goBack();
        }
    }

}
