package truongkaiyvo.pat.com.ecec.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.activity.MainActivity;

public class SingInQuen extends AppCompatActivity {
    Button click_laymk,click_thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singin_quen);

        click_laymk = (Button) findViewById(R.id.singinquen_laymk);

        click_laymk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });
        click_thoat = (Button) findViewById(R.id.singinquen_thoat);

        click_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        });
    }
}
