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
import truongkaiyvo.pat.com.ecec.data.Sup;

public class CaiDat extends AppCompatActivity {
    TabLayout tab;
    ViewPager view;
    TextView gold,diamond;
    Button click_thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caidat);
        CaiDatAdapter a = new CaiDatAdapter(getSupportFragmentManager());
        tab = findViewById(R.id.tab_chuyen_caidat);
        view = findViewById(R.id.view_l_caidat);
        gold=findViewById(R.id.cd_gold);
        diamond=findViewById(R.id.cd_diamond);

        gold.setText(String.valueOf(Sup.user_data.getGold()));
        diamond.setText(String.valueOf(Sup.user_data.getDiamond()));

        view.setAdapter(a);
        tab.setupWithViewPager(view);
        click_thoat = findViewById(R.id.thoat_caidat);

        click_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ManHinhChinhActivity.class));
            }
        });
    }
}
