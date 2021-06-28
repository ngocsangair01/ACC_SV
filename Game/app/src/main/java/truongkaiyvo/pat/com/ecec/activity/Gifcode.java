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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.data.Sup;

public class Gifcode extends AppCompatActivity {
    Button click_thoat ;
    ImageButton click_nhan;
    EditText nhapgif;

    public static TextView gold,diamond,gif_dia,gif_gold;
    String url_sua_diamond = "https://api-game-naruto-dattebayo.herokuapp.com/api/accounts/update";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gifcode);

        gold=findViewById(R.id.gold);
        diamond=findViewById(R.id.diamond);

        gif_dia=findViewById(R.id.gif_diamond);
        gif_gold=findViewById(R.id.gif_gold);
        showthongtin();
        nhapgif=findViewById(R.id.nhap_gif);
        //Nhận
        click_nhan = findViewById(R.id.nhan_gifcode);
        click_nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str;
                str=nhapgif.getText().toString();
                if (str.compareTo(Sup.gifcodeUser.getMagif())==0 && Sup.gifcodeUser.isDungchua()==false){
                    gif_dia.setText(String.valueOf(Sup.gifcodeUser.getDiamond()));
                    gif_gold.setText(String.valueOf(Sup.gifcodeUser.getGold()));
                    Sup.user_data.setDiamond(Sup.user_data.getDiamond()+Sup.gifcodeUser.getDiamond());
                    Sup.user_data.setGold(Sup.user_data.getGold()+Sup.gifcodeUser.getGold());

                    //Sup.gifcodeUser.getDiamond()

                    {
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("username",Sup.user_data.getUsername());
                            jsonObject.put("diamond",Sup.user_data.getDiamond());
                            jsonObject.put("gold",Sup.user_data.getGold());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        String strt = jsonObject.toString();

                        RequestQueue queue = Volley.newRequestQueue(Gifcode.this);
                        StringRequest request = new StringRequest(Request.Method.PATCH, url_sua_diamond, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }){
                            @Override
                            public String getBodyContentType() {
                                return "application/json; charset = utf-8";
                            }

                            @Override
                            public byte[] getBody() throws AuthFailureError {
                                try {
                                    return strt.getBytes("utf-8");
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                    return null;
                                }
                            }
                        };
                        queue.add(request);

                    }



                    Toast.makeText(Gifcode.this,"Nhậnthành công",Toast.LENGTH_LONG).show();
                    showthongtin();
                    Sup.gifcodeUser.setDungchua(true);
                }
                else{
                    gif_dia.setText("0");
                    gif_gold.setText("0");
                    Toast.makeText(Gifcode.this, "Gifcode không hợp hệ hoặc hết hạn. Kiểm tra lại !", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Thoát
        click_thoat = findViewById(R.id.thoat_gifcode);
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
