package truongkaiyvo.pat.com.ecec.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.adapter.chontuong.ChonBoTroAdapter;
import truongkaiyvo.pat.com.ecec.adapter.chontuong.ChonTuongAdapter;
import truongkaiyvo.pat.com.ecec.adapter.dachon.DaChonBoTroAdapter;
import truongkaiyvo.pat.com.ecec.adapter.dachon.DaChonTuongAdapter;
import truongkaiyvo.pat.com.ecec.data.Sup;

public class ChonTheDauMayActivity extends AppCompatActivity {

    public static ListView lv_show_co_show,lv_tuong_dachon,lv_botro_dachon;
    public static Button bt_tuong,bt_botro,bt_vao,thoat_bt;
    public static TextView tv_chon_gi,capmay;
    public static int click_chon = 0;
    public static ImageButton len_lv,xuong_lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_the_dau_may);
        tv_chon_gi=findViewById(R.id.tv_chon_gi);
        bt_tuong=findViewById(R.id.bt_truong);
        bt_botro=findViewById(R.id.bt_botro);
        bt_vao=findViewById(R.id.bt_vao);
        lv_tuong_dachon=findViewById(R.id.show_chon_tuong);
        lv_botro_dachon=findViewById(R.id.show_chon_botro);
        thoat_bt=findViewById(R.id.button_thoat);
        Sup.khoitaotran();
        show_da_chon();
        click_chon = 1;
        Sup.capmay=1;
        capmay=findViewById(R.id.capmay_show);
        len_lv=findViewById(R.id.up_lv_may);
        xuong_lv=findViewById(R.id.down_lv_may);
        capmay.setText("Máy cấp:\n"+String.valueOf(Sup.capmay));

        len_lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sup.capmay++;
                if (Sup.capmay >10 )
                    Sup.capmay=10;
                capmay.setText("Máy cấp:\n"+String.valueOf(Sup.capmay));
            }
        });

        xuong_lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sup.capmay--;
                if (Sup.capmay <1 )
                    Sup.capmay=1;
                capmay.setText("Máy cấp:\n"+String.valueOf(Sup.capmay));
            }
        });



        mau();
        lv_show_co_show=findViewById(R.id.lv_show_co_chon);

        ChonTuongAdapter chonTuongAdapter =new ChonTuongAdapter(Sup.chonTuongs);
        lv_show_co_show.setAdapter(chonTuongAdapter);
        bt_tuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click_chon = 1;
                mau();
                ChonTuongAdapter chonTuongAdapter =new ChonTuongAdapter(Sup.chonTuongs);
                lv_show_co_show.setAdapter(chonTuongAdapter);
            }
        });

        bt_botro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click_chon = 2;
                mau();
                ChonBoTroAdapter chonBoTroAdapter = new ChonBoTroAdapter(Sup.chonBotros);
                lv_show_co_show.setAdapter(chonBoTroAdapter);
            }
        });

        bt_vao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sup.d_mau_acc=20;
                Sup.d_mau_may=20;
                startActivity(new Intent(getBaseContext(), DauMayActivity.class));
            }
        });

        thoat_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ManHinhChinhActivity.class));
            }
        });

    }

    public static void mau(){
        if (click_chon == 1 ){
            bt_tuong.setBackgroundResource(R.drawable.vienxanh);
            bt_botro.setBackgroundResource(R.drawable.vientab);
            tv_chon_gi.setText("Tướng");
        }
        else{
            if (click_chon == 2 ){
                bt_botro.setBackgroundResource(R.drawable.vienxanh);
                bt_tuong.setBackgroundResource(R.drawable.vientab);
                tv_chon_gi.setText("Bổ trợ");
            }
        }
    }


    public static void show_da_chon(){
        DaChonTuongAdapter daChonTuongAdapter = new DaChonTuongAdapter(Sup.daChonTuongs);
        lv_tuong_dachon.setAdapter(daChonTuongAdapter);

        DaChonBoTroAdapter daChonBoTroAdapter = new DaChonBoTroAdapter(Sup.daChonBoTros);
        lv_botro_dachon.setAdapter(daChonBoTroAdapter);
    }


    public static void update_chon_dau(){
        if (click_chon == 2 ){
            ChonBoTroAdapter chonBoTroAdapter = new ChonBoTroAdapter(Sup.chonBotros);
            lv_show_co_show.setAdapter(chonBoTroAdapter);
        }
        else{
            ChonTuongAdapter chonTuongAdapter =new ChonTuongAdapter(Sup.chonTuongs);
            lv_show_co_show.setAdapter(chonTuongAdapter);
        }
        ChonTheDauMayActivity.show_da_chon();
    }
}