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
import truongkaiyvo.pat.com.ecec.adapter.friend.BanBeAdapter;
import truongkaiyvo.pat.com.ecec.adapter.shop.ShopAdapter;
import truongkaiyvo.pat.com.ecec.data.Sup;

public class Frined extends AppCompatActivity {
    TabLayout tab;
    ViewPager view;
    Button click_thoat;
    public static TextView gold,diamond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend);
        gold=findViewById(R.id.gold);
        diamond=findViewById(R.id.diamond);
        showthongtin();
        BanBeAdapter a = new BanBeAdapter(getSupportFragmentManager());
        tab = findViewById(R.id.tab_chuyen_friend);
        view = findViewById(R.id.view_l_friend);

        view.setAdapter(a);
        tab.setupWithViewPager(view);
        click_thoat = findViewById(R.id.thoat_friend);

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
