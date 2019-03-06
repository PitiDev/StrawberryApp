package pitidev.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class PopupLogout extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button btnLogout;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_logout);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void LogoutApp(View view) {

    }

    public void CancelLogout(View view) {

    }
}
