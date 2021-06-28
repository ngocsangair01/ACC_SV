package truongkaiyvo.pat.com.ecec.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.activity.DiemDanh;
import truongkaiyvo.pat.com.ecec.adapter.shop.ShopTuongAdapter;
import truongkaiyvo.pat.com.ecec.data.Sup;
import truongkaiyvo.pat.com.ecec.utl.diemdanh.DiemDanhUTL;
import truongkaiyvo.pat.com.ecec.utl.shop.ShopTuong;

public class DiemDanhAdapter extends RecyclerView.Adapter<DiemDanhAdapter.ViewHolder> {

    List<DiemDanhUTL> diemDanhUTLS = new ArrayList<>();
    Context context;

    public DiemDanhAdapter(List<DiemDanhUTL> diemDanhUTLS, Context context) {
        this.diemDanhUTLS = diemDanhUTLS;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public DiemDanhAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diemdanh, parent, false);
        return new DiemDanhAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DiemDanhAdapter.ViewHolder holder, int position) {
        DiemDanhUTL diemDanhUTL = diemDanhUTLS.get(position);
        if (diemDanhUTL.getNhan() == 0) {
            holder.a.setBackgroundResource(R.drawable.vienmo);
        }
        if (diemDanhUTL.getNhan() == 1) {
            holder.a.setBackgroundResource(R.drawable.vien);
        }
        if (diemDanhUTL.getNhan() == -1) {
            holder.a.setBackgroundResource(R.drawable.vienmo1);
        }
        holder.imv.setImageResource(diemDanhUTL.getAnh());
        holder.sl.setText(diemDanhUTL.getSoluong() + "");
        holder.imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (diemDanhUTL.getNhan() == -1) {
                    Toast.makeText(context, "Đã nhận rồi", Toast.LENGTH_SHORT).show();
                }
                if (diemDanhUTL.getNhan() == 0) {
                    Sup.user_data.setDiamond(Sup.user_data.getDiamond()+50);
                    DiemDanh.showthongtin();
                    Toast.makeText(context, "Nhận thành công", Toast.LENGTH_SHORT).show();
                    diemDanhUTL.setNhan(-1);
                    holder.a.setBackgroundResource(R.drawable.vienmo1);
                }
                if (diemDanhUTL.getNhan() == 1) {
                    Toast.makeText(context, "Quay lại vào ngày mai", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return diemDanhUTLS.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imv;
        TextView sl;
        LinearLayout a;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imv = itemView.findViewById(R.id.anh_diemdanh);
            sl = itemView.findViewById(R.id.sl_diemdanh);
            a = itemView.findViewById(R.id.mau);
        }
    }
}
