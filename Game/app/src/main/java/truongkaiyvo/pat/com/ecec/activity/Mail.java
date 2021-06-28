package truongkaiyvo.pat.com.ecec.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.data.Sup;
import truongkaiyvo.pat.com.ecec.utl.diemdanh.DiemDanhUTL;

public class Mail extends AppCompatActivity {
    Button click_thoat ;
    TextView thangmay;
    public static TextView gold,diamond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail);
        //Tháng mấy
        thangmay = findViewById(R.id.thang_thongbao);
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH) + 1;
        thangmay.setText("Tháng "+month+"");
        gold=findViewById(R.id.gold);
        diamond=findViewById(R.id.diamond);
        showthongtin();


        //Thoát
        click_thoat = findViewById(R.id.thoat_thongbao);
        click_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ManHinhChinhActivity.class));
            }
        });
    }
    public static void showthongtin(){
        diamond.setText(String.valueOf(Sup.user_data.getDiamond()));
        gold.setText(String.valueOf(Sup.user_data.getGold()));
    }
}
