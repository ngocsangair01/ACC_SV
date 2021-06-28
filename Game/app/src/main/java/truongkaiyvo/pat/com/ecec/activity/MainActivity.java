package truongkaiyvo.pat.com.ecec.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    Button click_sing_in,click_sing_up,click_thoat;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sing);

        click_sing_in = (Button) findViewById(R.id.sing_singin);

        click_sing_up = (Button) findViewById(R.id.sing_singup);

        click_thoat = (Button) findViewById(R.id.sing_thoat);

        click_sing_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SingIn.class));
                finish();
            }
        });

        click_sing_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SingUp.class));
                finish();
            }
        });

        click_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    // Tao su kien ket thuc app
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startActivity(startMain);
                    finish();
                }
            }
        });
    }
}