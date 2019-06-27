package pitidev.com;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    private TextView tvtoobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        tvtoobar = (TextView) findViewById(R.id.tvtoobar);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "laop.ttf");
        tvtoobar.setTypeface(typeface);
    }

    public void BackHome(View view) {
        onBackPressed();
    }
}
