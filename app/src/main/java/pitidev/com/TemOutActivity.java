package pitidev.com;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class TemOutActivity extends AppCompatActivity {

    private TextView tvtoobar;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tem_out);

        tvtoobar = (TextView) findViewById(R.id.tvtoobar);
        webView = (WebView) findViewById(R.id.TemOut);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"laop.ttf");
        tvtoobar.setTypeface(typeface);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://pitiiot.firebaseapp.com/temout.html");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    public void BackHome(View view) {
        onBackPressed();
    }
}
