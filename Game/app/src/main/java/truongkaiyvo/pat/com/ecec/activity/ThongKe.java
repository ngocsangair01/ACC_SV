package truongkaiyvo.pat.com.ecec.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.data.Sup;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoBoTro;

public class ThongKe extends AppCompatActivity {
    public static Button thoat;
    public static ListView lv_show_his;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongke);
        thoat=findViewById(R.id.thoat_thongke);
        lv_show_his=findViewById(R.id.lv_thongke);

        DauMayActivity.update_his();
        HistoryAdaper historyAdaper = new HistoryAdaper(Sup.stringList);
        lv_show_his.setAdapter(historyAdaper);



        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ManHinhChinhActivity.class));
            }
        });
    }
}
