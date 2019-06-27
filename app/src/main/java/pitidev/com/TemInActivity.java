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

public class TemInActivity extends AppCompatActivity {

    private WebView webView;
    private TextView tvtoobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tem_in);

        tvtoobar = (TextView) findViewById(R.id.tvtoobar);
        webView = (WebView) findViewById(R.id.TemIn);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"laop.ttf");
        tvtoobar.setTypeface(typeface);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://lao-strawberry.firebaseapp.com/");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
    public void BackHome(View view) {
        onBackPressed();
    }
}
