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
import truongkaiyvo.pat.com.ecec.utl.shop.ShopTuong;

public class ShopTuongAdapter extends RecyclerView.Adapter<ShopTuongAdapter.ViewHolder> {

    List<ShopTuong> shopTuongs = new ArrayList<>();
    Context context;

    public ShopTuongAdapter(List<ShopTuong> shopTuongs, Context context) {
        this.shopTuongs = shopTuongs;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_the_shop_tuong, parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ShopTuongAdapter.ViewHolder holder, int position) {
        ShopTuong shopTuong = shopTuongs.get(position);
        holder.imv.setImageResource(shopTuong.getAnh());
        holder.vang.setText(shopTuong.getGia_vang()+"");
        holder.kc.setText(shopTuong.getGia_kc()+"");
        holder.atk.setText(String.valueOf(shopTuong.getAtk()));
        holder.def.setText(String.valueOf(shopTuong.getDef()));
        holder.imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).
                        setMessage("Mô tả\n"+shopTuong.getMota()).setTitle(shopTuong.getName())
                        .setPositiveButton("Mua bằng vàng", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (shopTuong.getGia_vang() > Sup.user_data.getGold())
                                {
                                    Toast.makeText(context, "Vàng không đủ", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Sup.user_data.setGold(Sup.user_data.getGold()-shopTuong.getGia_vang());
                                    Sup.user_data.setIdFigure(Sup.user_data.getIdFigure()+shopTuong.getId()+"+");
                                    Shop.showthongtin();
                                    Toast.makeText(context, "Mua thành công", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("Mua bằng kim cương", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (shopTuong.getGia_kc() > Sup.user_data.getDiamond())
                                {
                                    Toast.makeText(context, "kim cương không đủ", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Sup.user_data.setDiamond(Sup.user_data.getDiamond()-shopTuong.getGia_kc());
                                    Sup.user_data.setIdFigure(Sup.user_data.getIdFigure()+shopTuong.getId()+"+");
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
        return shopTuongs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imv;
        TextView vang,kc,atk,def;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imv = itemView.findViewById(R.id.the_item);
            vang = itemView.findViewById(R.id.shopvang);
            kc = itemView.findViewById(R.id.shopkc);
            atk= itemView.findViewById(R.id.cong_shop);
            def= itemView.findViewById(R.id.thu_shop);
        }
    }
}
