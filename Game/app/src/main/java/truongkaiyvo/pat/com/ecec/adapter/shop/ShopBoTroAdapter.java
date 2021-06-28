package truongkaiyvo.pat.com.ecec.adapter.shop;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.activity.Gifcode;
import truongkaiyvo.pat.com.ecec.activity.Shop;
import truongkaiyvo.pat.com.ecec.data.Sup;
import truongkaiyvo.pat.com.ecec.utl.shop.ShopBoTro;

public class ShopBoTroAdapter extends RecyclerView.Adapter<ShopBoTroAdapter.ViewHolder> {

    List<ShopBoTro> list_Shop_BoTro = new ArrayList<>();
    Context context;

    public ShopBoTroAdapter(List<ShopBoTro> list_Shop_BoTro, Context context) {
        this.list_Shop_BoTro = list_Shop_BoTro;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ShopBoTroAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_the_shop, parent, false);
        return new ShopBoTroAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ShopBoTroAdapter.ViewHolder holder, int position) {
        ShopBoTro shopBoTro = list_Shop_BoTro.get(position);
        holder.imv.setImageResource(shopBoTro.getAnh());
        holder.vang.setText(shopBoTro.getGia_vang()+"");
        holder.kc.setText(shopBoTro.getGia_kc()+"");
        holder.imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("Mô tả\n"+shopBoTro.getMota()).setTitle(shopBoTro.getName())
                        .setPositiveButton("Mua bằng vàng", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (shopBoTro.getGia_vang() > Sup.user_data.getGold())
                                {
                                    Toast.makeText(context, "Vàng không đủ", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Sup.user_data.setGold(Sup.user_data.getGold()-shopBoTro.getGia_vang());
                                    Sup.user_data.setIdFigure(Sup.user_data.getIdFigure()+shopBoTro.getId()+"+");
                                    Shop.showthongtin();
                                    Toast.makeText(context, "Mua thành công", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("Mua bằng kim cương", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (shopBoTro.getGia_kc() > Sup.user_data.getDiamond())
                                {
                                    Toast.makeText(context, "kim cương không đủ", Toast.LENGTH_SHORT).show();
                                    Sup.user_data.setIdFigure(Sup.user_data.getIdFigure()+"+"+shopBoTro.getId());
                                }
                                else{
                                    Sup.user_data.setDiamond(Sup.user_data.getDiamond()-shopBoTro.getGia_kc());
                                    Sup.user_data.setIdFigure(Sup.user_data.getIdFigure()+shopBoTro.getId()+"+");
                                    Shop.showthongtin();
                                    Toast.makeText(context, "Mua thành công", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNeutralButton("Huỷ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return list_Shop_BoTro.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imv;
        TextView vang,kc;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imv = itemView.findViewById(R.id.the_item);
            vang = itemView.findViewById(R.id.shopvang);
            kc = itemView.findViewById(R.id.shopkc);
        }
    }

}
