package truongkaiyvo.pat.com.ecec.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.data.Sup;

public class User extends AppCompatActivity {
    Button thoat;
    TextView id_nv,tk_nv,gold_nv,diamond_nv,rank_nv,rank_ponit_nv;
    EditText name_nv,password_nv;
    ImageButton sua_ten,sua_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        id_nv = findViewById(R.id.user_id);
        tk_nv= findViewById(R.id.user_tk);
        gold_nv= findViewById(R.id.user_gold);
        diamond_nv= findViewById(R.id.user_diamond);
        rank_nv= findViewById(R.id.user_rank);
        rank_ponit_nv= findViewById(R.id.user_rank_point);
        name_nv=findViewById(R.id.user_name);
        password_nv=findViewById(R.id.user_pass);
        sua_ten=findViewById(R.id.sua_name);
        sua_pass=findViewById(R.id.sua_mk);

        //khoitaoa();
        name_nv.setText(Sup.user_data.getNameInGame());
        password_nv.setText(Sup.user_data.getPassword());
        id_nv.setText(String.valueOf(Sup.user_data.getAccountId()));
        tk_nv.setText(Sup.user_data.getUsername());
        gold_nv.setText(String.valueOf(Sup.user_data.getGold()));
        diamond_nv.setText(String.valueOf(Sup.user_data.getDiamond()));
        rank_nv.setText(Sup.user_data.getRank());
        rank_ponit_nv.setText(String.valueOf(Sup.user_data.getRankPoint()));

        sua_ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = name_nv.getText().toString();
                if (str==""){
                    Toast.makeText(User.this,"Tên mới không hợp lệ",Toast.LENGTH_LONG).show();
                }
                else{
                    Sup.user_data.setNameInGame(str);
                    Toast.makeText(User.this,"Sửa tên thành công",Toast.LENGTH_LONG).show();
                    name_nv.setText(Sup.user_data.getNameInGame());
                }
            }
        });

        sua_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = password_nv.getText().toString();
                if (str==""){
                    Toast.makeText(User.this,"Mật khẩu mới không hợp lệ",Toast.LENGTH_LONG).show();
                }
                else{
                    Sup.user_data.setPassword(str);
                    Toast.makeText(User.this,"Sửa mật khẩu thành công",Toast.LENGTH_LONG).show();
                    password_nv.setText(Sup.user_data.getPassword());
                }
            }
        });


        thoat=findViewById(R.id.thoat_user);
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ManHinhChinhActivity.class));
            }
        });
    }

}
