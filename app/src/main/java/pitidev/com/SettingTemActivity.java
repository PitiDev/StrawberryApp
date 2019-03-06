package pitidev.com;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SettingTemActivity extends AppCompatActivity {
    private TextView tvtoobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_tem);

        tvtoobar = (TextView) findViewById(R.id.tvtoobar);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"laop.ttf");
        tvtoobar.setTypeface(typeface);
    }

    public void BackHome(View view) {
        onBackPressed();
    }
}
