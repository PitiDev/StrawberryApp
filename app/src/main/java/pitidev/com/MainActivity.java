package pitidev.com;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private ImageView logout1;
    private TextView temin;
    private TextView temout;
    private  TextView sun;
    private TextView control;
    private TextView dashboard;
    private TextView setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        logout1 = (ImageView) findViewById(R.id.logout1);
        temin = (TextView) findViewById(R.id.temin);
        temout = (TextView) findViewById(R.id.temout);
        sun = (TextView) findViewById(R.id.sun);
        control = (TextView) findViewById(R.id.control);
        dashboard = (TextView) findViewById(R.id.dashboard);
        setting = (TextView) findViewById(R.id.setting);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"laop.ttf");
        temin.setTypeface(typeface);
        temout.setTypeface(typeface);
        sun.setTypeface(typeface);
        control.setTypeface(typeface);
        dashboard.setTypeface(typeface);
        setting.setTypeface(typeface);

        logout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                Toast.makeText(MainActivity.this, "ອອກຈາກລະບົບສຳເລັດ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

    }

    public void Logout(View view) {

        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activity_popup_logout,null);

        int wdith = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        Boolean focusable = true; // lets taps outside the popup also dismiss it
        final  PopupWindow popupWindow = new PopupWindow(popupView, wdith, height, focusable);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }

        });

    }

    public void TemIn(View view) {
        Intent intent = new Intent(this, TemInActivity.class);
        startActivity(intent);
    }

    public void TemOut(View view) {
        Intent intent = new Intent(this, TemOutActivity.class);
        startActivity(intent);
    }

    public void Ldr(View view) {
        Intent intent = new Intent(this, StatusActivity.class);
        startActivity(intent);
    }

    public void Control(View view) {
        Intent intent = new Intent(this, ControlActivity.class);
        startActivity(intent);
    }

    public void Dashboard(View view) {
        Intent intent = new Intent(this, DashbourdActivity.class);
        startActivity(intent);
    }

    public void Setting(View view) {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }

    public void User(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

}
