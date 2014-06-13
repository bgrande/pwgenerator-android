package bgrande.pwgenerator_android;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.annotation.SuppressLint;
import android.webkit.WebView;

public class Generate extends ActionBarActivity {

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebViewFactory webViewFactory = new WebViewFactory(this);
        WebView webView = webViewFactory.create("index.html");

        setContentView(webView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.generate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(this, Settings.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goBack() {

    }

}
