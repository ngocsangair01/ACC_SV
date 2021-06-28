package truongkaiyvo.pat.com.ecec.activity;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import truongkaiyvo.pat.com.ecec.activity.MainActivity;

public class SingUp extends AppCompatActivity {
    Button click_dangky,click_thoat;
    EditText taikhoan,matkhau,xnmatkhau;
    String url = "https://api-game-naruto-dattebayo.herokuapp.com/api/accounts/body";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singup);

        click_dangky = (Button) findViewById(R.id.singup_dangky);
        taikhoan = findViewById(R.id.dk_taikhoan);
        matkhau = findViewById(R.id.dk_matkhau);
        xnmatkhau = findViewById(R.id.dk_xnmatkhau);

        click_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk,mk,xnmk;
                Integer gold=5000,diamond=500;
                tk=taikhoan.getText().toString();
                mk=matkhau.getText().toString();
                xnmk=xnmatkhau.getText().toString();
                if (mk.compareTo(xnmk)!=0){
                    Toast.makeText(SingUp.this,"Xác nhận mật khẩu không giống",Toast.LENGTH_LONG).show();
                }
                else{
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("username",tk);
                        jsonObject.put("password",mk);
                        jsonObject.put("avt","0000");
                        jsonObject.put("idFigure","+");
                        jsonObject.put("gold",5000);
                        jsonObject.put("diamond",diamond);
                        jsonObject.put("rankPoint",1);
                        jsonObject.put("friend","+");
                        jsonObject.put("history","+");
                        jsonObject.put("rank","Emty");
                        jsonObject.put("nameInGame",tk);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    String str = jsonObject.toString();

                    RequestQueue queue = Volley.newRequestQueue(SingUp.this);
                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
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
                                return str.getBytes("utf-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    };

                    queue.add(request);
                    Toast.makeText(SingUp.this,"Đăng ký thành công",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getBaseContext(), MainActivity.class));
                }

            }
        });
        click_thoat = (Button) findViewById(R.id.singup_thoat);

        click_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        });
    }
}
