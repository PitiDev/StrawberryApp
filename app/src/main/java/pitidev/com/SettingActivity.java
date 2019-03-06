package pitidev.com;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SettingActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase ;
    private DatabaseReference mRef;
    private TextView textView;
    private TextView temset;
    private TextView userset;
    private TextView about;
    private TextView tvtoobar;
    private TextView tvdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        temset = (TextView) findViewById(R.id.temset);
        userset = (TextView) findViewById(R.id.userset);
        about = (TextView) findViewById(R.id.about);
        tvtoobar = (TextView) findViewById(R.id.tvtoobar);
        tvdate = (TextView) findViewById(R.id.tvDate);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"laop.ttf");
        temset.setTypeface(typeface);
        userset.setTypeface(typeface);
        about.setTypeface(typeface);
        tvtoobar.setTypeface(typeface);
        tvdate.setTypeface(typeface);

//        textView = (TextView) findViewById(R.id.tvDate);
//        mRef  = FirebaseDatabase.getInstance().getReference("date").child("date");
//
//        mRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String date = dataSnapshot.getValue(String.class);
//                textView.setText(date);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

    }

    public void BackHome(View view) {
          onBackPressed();
    }

    public  void SettingTem(View view){
        Intent intent = new Intent(this, SettingTemActivity.class);
        startActivity(intent);
    }

    public void Register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void About(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}
