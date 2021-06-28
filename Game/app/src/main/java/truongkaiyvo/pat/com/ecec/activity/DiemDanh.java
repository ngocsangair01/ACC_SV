package truongkaiyvo.pat.com.ecec.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.adapter.DiemDanhAdapter;
import truongkaiyvo.pat.com.ecec.data.Sup;
import truongkaiyvo.pat.com.ecec.utl.diemdanh.DiemDanhUTL;

public class DiemDanh extends AppCompatActivity {
    RecyclerView a;
    DiemDanhAdapter diemDanhAdapter;
    Button click_thoat ;
    TextView thangmay;
    public static TextView gold,diamond;
    ArrayList<DiemDanhUTL> diemDanhUTLList = new ArrayList<>();
    //ArrayList<DiemDanhUTL> diemDanhUTLList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diemdanh);
        gold=findViewById(R.id.gold);
        diamond=findViewById(R.id.diamond);
        //Tháng mấy
        thangmay = findViewById(R.id.thang_diemdanh);
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH) + 1;
        thangmay.setText("Tháng "+month+"");

        showthongtin();
        // taoj
        diemDanhUTLList.add(new DiemDanhUTL("diemdanh_02", R.drawable.tuido, 0, 50));
        a = findViewById(R.id.showdiemdanh);
        diemDanhAdapter=new DiemDanhAdapter(diemDanhUTLList,getApplicationContext());
        a.setAdapter(diemDanhAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),7 ,RecyclerView.VERTICAL ,false);
        a.setLayoutManager(gridLayoutManager);
        //Thoát
        click_thoat = findViewById(R.id.thoat_diemdanh);
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
