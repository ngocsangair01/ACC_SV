package truongkaiyvo.pat.com.ecec.activity;

import android.accounts.Account;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.data.Sup;
import truongkaiyvo.pat.com.ecec.utl.user.User_data;

public class SingIn extends AppCompatActivity {
    Button click_dangnhap,click_quenmk,click_thoat;
    EditText taikhoan,matkhau;
    CheckBox luumk;
    SharedPreferences sharedPreferences;
    static int gold,diamond;
    static String name_game,idthe,history,rank,friend,avt;
    static  Integer acc_id,rankpoint;
    int dem=0;
    String url = "https://api-game-naruto-dattebayo.herokuapp.com/api/accounts";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singin);

        click_dangnhap = (Button) findViewById(R.id.singin_dangnhap);
        taikhoan = findViewById(R.id.taikhoan);
        matkhau = findViewById(R.id.matkhau);
        luumk = findViewById(R.id.singin_luumk);
        sharedPreferences = getSharedPreferences("dataSingin",MODE_PRIVATE);
        taikhoan.setText(sharedPreferences.getString("Taikhoan",""));
        matkhau.setText(sharedPreferences.getString("Matkhau",""));
        luumk.setChecked(sharedPreferences.getBoolean("LuuMK",false));
        RequestQueue requestQueue = Volley.newRequestQueue(SingIn.this);

        click_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk = taikhoan.getText().toString().trim();
                String mk = matkhau.getText().toString().trim();
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i=0;i<jsonArray.length();i++){

                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                                String username1 = jsonObject1.getString("username");
                                String passsword1 = jsonObject1.getString("password");
                                avt = jsonObject1.getString("avt");
                                gold = jsonObject1.getInt("gold");
                                diamond = jsonObject1.getInt("diamond");
                                rankpoint = jsonObject1.getInt("rankPoint");

                                rank = jsonObject1.getString("rank");

                                acc_id = jsonObject1.getInt("accountId");

                                idthe = jsonObject1.getString("idFigure");

                                friend = jsonObject1.getString("friend");
                                history = jsonObject1.getString("history");
                                name_game = jsonObject1.getString("nameInGame");

                                if (tk.equals(username1) && mk.equals(passsword1)){
                                    Sup.user_data.setGold(gold);
                                    Sup.user_data.setDiamond(diamond);
                                    Sup.user_data.setNameInGame(name_game);
                                    Sup.user_data.setRank(rank);
                                    Sup.user_data.setRankPoint(rankpoint);
                                    Sup.user_data.setAccountId(acc_id);
                                    Sup.user_data.setIdFigure(idthe);
                                    Sup.user_data.setFriend(friend);
                                    Sup.user_data.setHistory(history);
                                    Sup.user_data.setAvt(avt);
                                    Sup.user_data.setUsername(username1);
                                    Sup.user_data.setPassword(passsword1);
                                    dem =1;
                                    if (luumk.isChecked()){
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString("Taikhoan",username1);
                                        editor.putString("Matkhau",passsword1);
                                        editor.putBoolean("LuuMK",true);
                                        editor.commit();
                                    }
                                    else{
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString("Taikhoan",username1);
                                        editor.remove("Matkhau");
                                        editor.remove("LuuMK");
                                        editor.commit();
                                    }

                                    startActivity(new Intent(getBaseContext(), ManHinhChinhActivity.class));
                                    finish();
                                }

                            }
                            if (dem==0) {
                                Toast.makeText(SingIn.this, "Thông tin sai", Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(SingIn.this, "Chào mừng vào game", Toast.LENGTH_LONG).show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, error -> {
                    Toast.makeText(SingIn.this,"Lỗi" , Toast.LENGTH_LONG).show();
                });
                    requestQueue.add(stringRequest);
                }
        });

        click_quenmk = (Button) findViewById(R.id.singin_quenmk);

        click_quenmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SingInQuen.class));
            }
        });
        click_thoat = (Button) findViewById(R.id.singin_thoat);

        click_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        });
    }
}
