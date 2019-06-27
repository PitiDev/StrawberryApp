package pitidev.com;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingTemActivity extends AppCompatActivity {

    private TextView tvtoobar;
    private EditText TemHigh;
    private EditText TemLow;
    private EditText HumHigh;
    private EditText HumLow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_tem);

        tvtoobar = (TextView) findViewById(R.id.tvtoobar);
        TemHigh = (EditText) findViewById(R.id.temHigh);
        TemLow = (EditText) findViewById(R.id.temLow);
        HumHigh = (EditText) findViewById(R.id.humHigh);
        HumLow = (EditText) findViewById(R.id.humLow);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"laop.ttf");
        tvtoobar.setTypeface(typeface);
        TemHigh.setTypeface(typeface);
        TemLow.setTypeface(typeface);
        HumHigh.setTypeface(typeface);
        HumLow.setTypeface(typeface);
    }

    public void BackHome(View view) {
        onBackPressed();
    }

    public void UpdateTem(View view){
        Toast.makeText(SettingTemActivity.this, "!! Update Tem Success !!", Toast.LENGTH_SHORT).show();
    }

}
