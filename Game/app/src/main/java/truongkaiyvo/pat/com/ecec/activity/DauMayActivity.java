package truongkaiyvo.pat.com.ecec.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.adapter.dau.DauBoTroAdapter;
import truongkaiyvo.pat.com.ecec.adapter.dau.DauTuongAdapter;
import truongkaiyvo.pat.com.ecec.data.Sup;

public class DauMayActivity extends AppCompatActivity {
    public static TextView name_may,name_acc,mau_may,mau_acc;
    public static int click_chon = 0;
    public static Button bt_tuong,bt_botro,bt_vao,thoat_bt;
    public static ListView lv_show_dau;
    public static ImageButton dau_hang;

    public static View vi_13 ,vi_23,vi_33,vi_43,vi_53;
    public static View vi_14,vi_24,vi_34,vi_44,vi_54;
    Calendar calendar = new GregorianCalendar();
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dau_may);

        name_may=findViewById(R.id.show_may_name);
        name_acc=findViewById(R.id.show_acc_name);
        name_may.setText("Máy cấp "+String.valueOf(Sup.capmay));
        name_acc.setText(Sup.user_data.getNameInGame());
        mau_acc=findViewById(R.id.show_acc_mau);
        mau_may=findViewById(R.id.show_may_mau);
        bt_tuong=findViewById(R.id.button_tuong);
        bt_botro=findViewById(R.id.button_botro);
        lv_show_dau=findViewById(R.id.lv_show_tran_co);
        dau_hang=findViewById(R.id.dauhang);
        click_chon = 1;
        vi_13=findViewById(R.id.view_13);
        mau();
        DauTuongAdapter dauTuongAdapter = new DauTuongAdapter(Sup.daChonTuongs);
        lv_show_dau.setAdapter(dauTuongAdapter);

        update_dau();

        bt_tuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click_chon=1;mau();
                DauTuongAdapter dauTuongAdapter = new DauTuongAdapter(Sup.daChonTuongs);
                lv_show_dau.setAdapter(dauTuongAdapter);
            }
        });
        bt_botro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click_chon=2;mau();
                DauBoTroAdapter dauBoTroAdapter = new DauBoTroAdapter(Sup.daChonBoTros);
                lv_show_dau.setAdapter(dauBoTroAdapter);
            }
        });

        dau_hang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(DauMayActivity.this).
                        setMessage("Thoát bạn sẽ thua").setTitle("Thoát")
                        .setPositiveButton("Xác nhận thoát", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Sup.d_mau_acc=-1;
                                update_dau();
                            }
                        })
                        .setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });

    }

    public void update_dau(){
        mau_may.setText(Sup.d_mau_may+"");
        mau_acc.setText(Sup.d_mau_acc+"");
        if (Sup.d_mau_may <= 0 ){
            AlertDialog alertDialog = new AlertDialog.Builder(DauMayActivity.this).
                    setMessage("Rank point công : 0 point").setTitle("Win")
                    .setPositiveButton("Về màn hình chính", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Sup.user_data.setHistory("Win - May cap "+String.valueOf(Sup.capmay)+"  ----ngay"+String.valueOf(day+"/"+month+"/"+year)+"+"+Sup.user_data.getHistory());
                            update_his();
                            startActivity(new Intent(getBaseContext(), ManHinhChinhActivity.class));
                        }
                    })
                    .setNeutralButton("Chơi tiếp", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Sup.user_data.setHistory("Win - May cap "+String.valueOf(Sup.capmay)+"  ----ngay"+String.valueOf(day+"/"+month+"/"+year)+"+"+Sup.user_data.getHistory());
                            update_his();
                            startActivity(new Intent(getBaseContext(), ChonTheDauMayActivity.class));
                        }
                    }).show();
        }
        if (Sup.d_mau_acc <= 0 ){
            AlertDialog alertDialog = new AlertDialog.Builder(DauMayActivity.this).
                    setMessage("Rank point công : 0 point").setTitle("Thua")
                    .setPositiveButton("Về màn hình chính", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Sup.user_data.setHistory("Loss - May cap "+String.valueOf(Sup.capmay)+"  ----ngay"+String.valueOf(day+"/"+month+"/"+year)+"+"+Sup.user_data.getHistory());
                            update_his();
                            startActivity(new Intent(getBaseContext(), ManHinhChinhActivity.class));
                        }
                    })
                    .setNeutralButton("Chơi lại", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Sup.user_data.setHistory("Loss - May cap "+String.valueOf(Sup.capmay)+"  ----ngay"+String.valueOf(day+"/"+month+"/"+year)+"+"+Sup.user_data.getHistory());
                            update_his();
                            startActivity(new Intent(getBaseContext(), ChonTheDauMayActivity.class));
                        }
                    }).show();
        }

    }

    public static void mau(){
        if (click_chon == 1 ){
            bt_tuong.setBackgroundResource(R.drawable.vienxanh);
            bt_botro.setBackgroundResource(R.drawable.vientab);
        }
        else{
            if (click_chon == 2 ){
                bt_botro.setBackgroundResource(R.drawable.vienxanh);
                bt_tuong.setBackgroundResource(R.drawable.vientab);
            }
        }
    }

    public  static  void  update_his(){
        Sup.stringList.clear();
        Sup.stringList = new ArrayList<>();
        String str = Sup.user_data.getHistory();//ten_tuong+ten_tuong+
        String tmp="";
        for (int i=0;i< str.length();i++){
            if (str.charAt(i) == '+'){
                Sup.stringList.add(tmp);
                tmp="";
            }
            else
                tmp+=str.charAt(i);
        }
    }
    public static void vie_13(){

    }

}