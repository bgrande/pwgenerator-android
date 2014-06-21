package bgrande.pwgenerator_android;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.annotation.SuppressLint;

public class Generate extends AbstractAppActivity
{

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _setWebView("index.html");
    }

    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();

        // clear clipboard on Resume only after settings had been started before!
        if (hasBeenStarted) {
            _resetClip();
            webView.reload();
        }
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
            hasBeenStarted = true;
            startActivity(new Intent(this, Settings.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void resetForm() {
        _resetClip();
    }

    protected void _resetClip() {
        _setClip("");
        _printToast("cleaned up clipboard!");
    }

    public void copyToClipboard(String word) {
        _setClip(word);
        _printToast("copied password to clipboard!");
    }

    protected ClipboardManager _getClipboard() {
        return (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
    }

    protected void _setClip(String word) {
        ClipboardManager clipboard = _getClipboard();

        ClipData clip = ClipData.newPlainText("pw", word);
        clipboard.setPrimaryClip(clip);
    }

}
