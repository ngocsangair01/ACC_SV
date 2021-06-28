package truongkaiyvo.pat.com.ecec.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.adapter.tuido.TuiDoAdapter;
import truongkaiyvo.pat.com.ecec.data.Sup;

public class TuiDo extends AppCompatActivity {
    TabLayout tab;
    ViewPager view;
    Button click_thoat;
    public static TextView gold,diamond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuido);
        gold=findViewById(R.id.gold);
        diamond=findViewById(R.id.diamond);
        showthongtin();
        TuiDoAdapter a = new TuiDoAdapter(getSupportFragmentManager());
        tab = findViewById(R.id.tab_chuyen_tuido);
        view = findViewById(R.id.view_l_tuido);
        view.setAdapter(a);
        tab.setupWithViewPager(view);
        click_thoat = findViewById(R.id.thoat_tuido);

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
