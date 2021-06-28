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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.activity.Shop;
import truongkaiyvo.pat.com.ecec.data.Sup;
import truongkaiyvo.pat.com.ecec.utl.shop.ShopDa;

public class ShopDaAdapter extends RecyclerView.Adapter<ShopDaAdapter.ViewHolder> {

    List<ShopDa> shopDas = new ArrayList<>();
    Context context;

    public ShopDaAdapter(List<ShopDa> shopDas, Context context) {
        this.shopDas = shopDas;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ShopDaAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_the_shop, parent , false);
        return new ShopDaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ShopDaAdapter.ViewHolder holder, int position) {
        ShopDa shopDa = shopDas.get(position);
        holder.imv.setImageResource(shopDa.getAnh());
        holder.vang.setText(shopDa.getGia_vang()+"");
        holder.kc.setText(shopDa.getGia_kc()+"");
        holder.imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("Mô tả\n"+shopDa.getMota()).setTitle(shopDa.getName())
                        .setPositiveButton("Mua bằng vàng", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (shopDa.getGia_vang() > Sup.user_data.getGold())
                                {
                                    Toast.makeText(context, "Vàng không đủ", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Sup.user_data.setGold(Sup.user_data.getGold()-shopDa.getGia_vang());
                                    Sup.user_data.setIdFigure(Sup.user_data.getIdFigure()+shopDa.getId()+"+");
                                    Shop.showthongtin();
                                    Toast.makeText(context, "Mua thành công", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("Mua bằng kim cương", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (shopDa.getGia_kc() > Sup.user_data.getDiamond())
                                {
                                    Toast.makeText(context, "kim cương không đủ", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Sup.user_data.setDiamond(Sup.user_data.getDiamond()-shopDa.getGia_kc());
                                    Sup.user_data.setIdFigure(Sup.user_data.getIdFigure()+shopDa.getId()+"+");
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
        return shopDas.size();
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
