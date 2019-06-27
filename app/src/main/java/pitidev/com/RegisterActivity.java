package pitidev.com;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText userName, userPassword, userEmail;
    private Button regButton;
    private FirebaseAuth firebaseAuth;
    private TextView tvregister;
    private TextView tvtoobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupUIViewa();

        firebaseAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    //Upload To Database
                    String user_email = userEmail.getText().toString();
                    String user_password = userPassword.getText().toString();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "ລົງທະບຽນສຳເລັດແລ້ວ", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                            } else {
                                Toast.makeText(RegisterActivity.this, "!! ລົງທະບຽນບໍ່ສຳເລັດແລ້ວ !!", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
    }

    public void BackSetting(View view) {
        onBackPressed();
    }

    private void setupUIViewa() {

        tvtoobar = (TextView) findViewById(R.id.tvtoobar);
        tvregister = (TextView) findViewById(R.id.tvregister);
        userName = (EditText) findViewById(R.id.etUsername);
        userEmail = (EditText) findViewById(R.id.etEmail);
        userPassword = (EditText) findViewById(R.id.etPassword);
        regButton = (Button) findViewById(R.id.btnRegister);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"laop.ttf");
        tvtoobar.setTypeface(typeface);
        tvregister.setTypeface(typeface);
        userName.setTypeface(typeface);
        userEmail.setTypeface(typeface);
        userPassword.setTypeface(typeface);
        regButton.setTypeface(typeface);
    }

    private boolean validate() {
        boolean result = false;
        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if (name.isEmpty() && password.isEmpty() && email.isEmpty()) {
            Toast.makeText(this, "ກະລຸນາຕື່ມຂໍ້ມູນໃຫ້ຖືກຕ້ອງ", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }
}
