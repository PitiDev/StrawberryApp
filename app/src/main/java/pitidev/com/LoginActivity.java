package pitidev.com;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    private EditText edtUsername, edtPassword;
    private Button btnSignIn;
    private FirebaseAuth firebaseAuth;
    private TextView tvlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Find View ID
        tvlogin = (TextView) findViewById(R.id.tvlogin);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        Typeface typeface = Typeface.createFromAsset(getAssets(),"laop.ttf");
        tvlogin.setTypeface(typeface);
        edtUsername.setTypeface(typeface);
        edtPassword.setTypeface(typeface);
        btnSignIn.setTypeface(typeface);

        if (user != null){
            finish();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    //Upload To Database
                    String user_email = edtUsername.getText().toString();
                    String user_password = edtPassword.getText().toString();

                    firebaseAuth.signInWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "ເຂົ້າສູ່ລະບົບໄດ້", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            } else {
                                Toast.makeText(LoginActivity.this, "!! ບໍ່ສາມາດເຂົ້າສູ່ລະບົບໄດ້ !!",
                                        Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
    }

    private boolean validate() {
        boolean result = false;
        String email = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if (email.isEmpty() && password.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "ກະລຸນາຕື່ມຂໍ້ມູນໃຫ້ຖືກຕ້ອງ", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }
}
