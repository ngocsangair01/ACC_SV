package truongkaiyvo.pat.com.ecec.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.config.ChatApplication;
import truongkaiyvo.pat.com.ecec.data.Sup;

public class ManHinhChinhActivity extends AppCompatActivity {
    public static SharedPreferences sharedPreferences;
    public static MediaPlayer mediaPlayer = new MediaPlayer();
    public static AudioManager audioManager ;
    public static int maxVolumeValue ;
    public static ImageButton click_shop,click_tuido , click_nhac ,click_giam_am , click_tang_am , click_banbe , click_thongke , click_nangcap , click_user ,
                click_mail , click_diemdanh , click_thongbao , click_gifcode , click_huongdan , click_caidat , click_thoat;
    public static TextView nameingame,id_user,rank,gold,diamond;

    public static Button dau_thuong,dau_hang,dau_tuy_chon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Sup.taotuibotro();
        nameingame=findViewById(R.id.nameingame);
        id_user=findViewById(R.id.id_user);
        rank=findViewById(R.id.rank_user);
        gold=findViewById(R.id.gold);
        diamond=findViewById(R.id.diamond);
        showthongtin();

        dau_hang=findViewById(R.id.dauhang);
        dau_thuong=findViewById(R.id.dauthuong);
        dau_tuy_chon=findViewById(R.id.dautuychon);

        //savedInstanceState = getSharedPreferences("ddd",MODE_PRIVATE);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music_nen);
        sharedPreferences = getSharedPreferences("datamanhinhchinh",MODE_PRIVATE);

        //Dau
        dau_hang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("").setTitle("Đấu hạng")
                        .setPositiveButton("Xác nhận vào", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Sup.daugi=2;
                                startActivity(new Intent(getBaseContext(), TimTranActivity.class));
                            }
                        })
                        .setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });

        dau_thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("").setTitle("Đấu thường")
                        .setPositiveButton("Xác nhận vào", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Sup.daugi=1;
                                startActivity(new Intent(getBaseContext(), TimTranActivity.class));
                            }
                        })
                        .setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });
        dau_tuy_chon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("").setTitle("Đấu tùy chọn")
                        .setPositiveButton("Tạo phòng", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Sup.daugi=3;
                                startActivity(new Intent(getBaseContext(), TaoPhongActivity.class));
                            }
                        })
                        .setNegativeButton("Đấu máy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getBaseContext(), ChonTheDauMayActivity.class));
                            }
                        })
                        .setNeutralButton("Huỷ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });
        Sup.capmay=1;
        //Thong ke
        click_thongke = (ImageButton) findViewById(R.id.thongke);
        click_thongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ThongKe.class));
            }
        });

        // ===========  Shop
        click_shop = (ImageButton) findViewById(R.id.shop);
        click_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Shop.class));
            }
        });

        // ===========  Tui do
        click_tuido = (ImageButton) findViewById(R.id.tuido);
        click_tuido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), TuiDo.class));
            }
        });

        // ===========  Ban be
        click_banbe = (ImageButton) findViewById(R.id.friend);
        click_banbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Frined.class));
            }
        });

        //Nang Cap
        click_nangcap = (ImageButton) findViewById(R.id.nangcap);
        click_nangcap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), NangCap.class));
            }
        });

        //User
        click_user = (ImageButton) findViewById(R.id.user);
        click_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), User.class));
            }
        });

        // Mail
        click_mail = (ImageButton) findViewById(R.id.tinhan);
        click_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Mail.class));
            }
        });

        // Diem Danh
        click_diemdanh = (ImageButton) findViewById(R.id.diemdanh);
        click_diemdanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), DiemDanh.class));
            }
        });

        // Thông báo
        click_thongbao = (ImageButton) findViewById(R.id.thongbao);
        click_thongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ThongBao.class));
            }
        });

        // ===========  Am nhac nen
        click_nhac = (ImageButton) findViewById(R.id.nhacnen);
        click_nhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying())
                    mediaPlayer.pause();
                else {
                    mediaPlayer.start();
                    mediaPlayer.setLooping(true);
                }

            }
        });
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        maxVolumeValue = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        System.out.println(maxVolumeValue);
        click_tang_am = (ImageButton) findViewById(R.id.tangam);
        click_tang_am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolumeValue++, AudioManager.FLAG_SHOW_UI);
                if (maxVolumeValue > 15)
                    maxVolumeValue = 15;
            }
        });

        click_giam_am = (ImageButton) findViewById(R.id.giamam);
        click_giam_am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolumeValue--, AudioManager.FLAG_SHOW_UI);
                if (maxVolumeValue < 0)
                    maxVolumeValue = 0;
            }
        });


        // GifCode
        click_gifcode = (ImageButton) findViewById(R.id.gifcode);
        click_gifcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Gifcode.class));
            }
        });

        // Huong dan
        click_huongdan = (ImageButton) findViewById(R.id.huongdan);
        click_huongdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), HuongDan.class));
            }
        });

        // Cai dat
        click_caidat = (ImageButton) findViewById(R.id.caidat);
        click_caidat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), CaiDat.class));
            }
        });

        // Thoat
        click_thoat = (ImageButton) findViewById(R.id.thoat_game);
        click_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("").setTitle("Thoát game")
                        .setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), ManHinhChinhActivity.class);
                                startActivity(intent);
                                Toast.makeText(ManHinhChinhActivity.this,"Thoát game",Toast.LENGTH_LONG).show();

                                // Tao su kien ket thuc app
                                Intent startMain = new Intent(Intent.ACTION_MAIN);
                                startMain.addCategory(Intent.CATEGORY_HOME);
                                startActivity(startMain);
                                finish();
                            }
                        })
                        .setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });

        {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("accountId",Sup.user_data.getAccountId());
                jsonObject.put("username",Sup.user_data.getUsername());
                jsonObject.put("password",Sup.user_data.getPassword());
                jsonObject.put("avt",Sup.user_data.getAvt());
                jsonObject.put("idFigure",Sup.user_data.getIdFigure());
                jsonObject.put("gold",Sup.user_data.getGold());
                jsonObject.put("diamond",Sup.user_data.getDiamond());
                jsonObject.put("rankPoin",Sup.user_data.getRankPoint());
                jsonObject.put("friend",Sup.user_data.getFriend());
                jsonObject.put("history",Sup.user_data.getHistory());
                jsonObject.put("rank",Sup.user_data.getRank());
                jsonObject.put("nameInGame",Sup.user_data.getNameInGame());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            String strt = jsonObject.toString();

            RequestQueue queue = Volley.newRequestQueue(ManHinhChinhActivity.this);
            StringRequest request = new StringRequest(Request.Method.PATCH, Sup.url_sua_diamond, new Response.Listener<String>() {
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
    }
    public static void showthongtin(){
        nameingame.setText("Name:"+Sup.user_data.getNameInGame());
        id_user.setText("Id:"+String.valueOf(Sup.user_data.getAccountId()));
        rank.setText("Rank:"+Sup.user_data.getRank());
        diamond.setText(String.valueOf(Sup.user_data.getDiamond()));
        gold.setText(String.valueOf(Sup.user_data.getGold()));
        Sup.daugi=0;
    }

    @Override
    public void onBackPressed() {
        AlertDialog alertDialog = new AlertDialog.Builder(ManHinhChinhActivity.this).
                setMessage("").setTitle("Thoát game")
                .setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), ManHinhChinhActivity.class);
                        startActivity(intent);
                        Toast.makeText(ManHinhChinhActivity.this,"Thoát game",Toast.LENGTH_LONG).show();
                        // Tao su kien ket thuc app
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startActivity(startMain);
                        finish();
                    }
                })
                .setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

}
