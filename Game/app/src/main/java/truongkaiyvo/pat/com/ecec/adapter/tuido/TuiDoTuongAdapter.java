package truongkaiyvo.pat.com.ecec.adapter.tuido;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoTuong;

public class TuiDoTuongAdapter extends RecyclerView.Adapter<TuiDoTuongAdapter.ViewHolder> {

    List<TuiDoTuong> tuiDoTuongs = new ArrayList<>();
    Context context;

    public TuiDoTuongAdapter(List<TuiDoTuong> tuiDoTuongs, Context context) {
        this.tuiDoTuongs = tuiDoTuongs;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public TuiDoTuongAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_the_tuong_tui, parent , false);
        return new TuiDoTuongAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TuiDoTuongAdapter.ViewHolder holder, int position) {
        TuiDoTuong tuiDoTuong = tuiDoTuongs.get(position);
        holder.imv.setImageResource(tuiDoTuong.getAnh());
        holder.name.setText(tuiDoTuong.getName());
        holder.atk.setText(tuiDoTuong.getAtk()+"");
        holder.def.setText(tuiDoTuong.getDef()+"");
    }

    @Override
    public int getItemCount() {
        return tuiDoTuongs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imv;
        TextView name,atk,def;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imv = itemView.findViewById(R.id.the_item);
            name = itemView.findViewById(R.id.the_item_name);
            atk = itemView.findViewById(R.id.cong_tui);
            def = itemView.findViewById(R.id.thu_tui);
        }
    }
}

