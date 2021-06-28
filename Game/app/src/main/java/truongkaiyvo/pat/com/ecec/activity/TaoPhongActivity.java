package truongkaiyvo.pat.com.ecec.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.config.ChatApplication;
import truongkaiyvo.pat.com.ecec.data.Sup;

public class TaoPhongActivity extends AppCompatActivity {

    public static TextView name_nv,name_dich;
    public static Button sansang,thoat,search;
    private Socket mSocket;

    public static EditText id_phong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_phong);
        thoat=findViewById(R.id.taophong_thoat);
        Sup.sansangchua=0;
        name_nv=findViewById(R.id.tv_name_nv);
        name_dich=findViewById(R.id.tv_name_dich);
        sansang=findViewById(R.id.taophong_sansang);
        name_dich.setText(" ");
        name_nv.setText(Sup.user_data.getNameInGame());
        id_phong=findViewById(R.id.taophong_idphong);
        search=findViewById(R.id.taophong_search);
        chuyen();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSocket.emit("client-send-room",id_phong.getText().toString());
            }
        });



        ChatApplication chatApplication = (ChatApplication) getApplication();
        mSocket=chatApplication.getSocket();
        //
        String strtest = "";
//        mSocket.emit("client-send-message", Sup.user_data.getNameInGame());
//        mSocket.on("reply-client",onreply);




        sansang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (Sup.sansangchua==1 ){
//                    sansang.setBackgroundResource(R.drawable.viennull);
//                    Sup.sansangchua=0;
//                }
                mSocket.emit("client-send-room","Helo Sang");

            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ManHinhChinhActivity.class));
            }
        });
    }

    private Emitter.Listener onreply = args -> runOnUiThread(() -> {
        String str = (String) args[0];
        System.out.println(str);
    });


    public static void chuyen(){
        String str = name_dich.getText().toString();
        if (str.equals(" ")) {
            sansang.setBackgroundResource(R.drawable.viennull);

        }
        else {
            sansang.setBackgroundResource(R.drawable.vienkhongnul);
            Sup.sansangchua=1;
        }
    }


}