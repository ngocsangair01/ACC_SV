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
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoDa;

public class TuiDoDaAdapter extends RecyclerView.Adapter<TuiDoDaAdapter.ViewHolder> {

    List<TuiDoDa> tuiDoDas = new ArrayList<>();
    Context context;

    public TuiDoDaAdapter(List<TuiDoDa> tuiDoDas, Context context) {
        this.tuiDoDas = tuiDoDas;
        this.context = context;
    }

    @NonNull
    @Override
    public TuiDoDaAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_the_da_va_botro_tui, parent , false);
        return new TuiDoDaAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull TuiDoDaAdapter.ViewHolder holder, int position) {
        TuiDoDa tuiDoDa = tuiDoDas.get(position);
        holder.imv.setImageResource(tuiDoDa.getAnh());
        holder.name.setText(tuiDoDa.getName());
    }

    @Override
    public int getItemCount() {
        return tuiDoDas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imv;
        TextView name;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imv = itemView.findViewById(R.id.the_item);
            name = itemView.findViewById(R.id.the_item_name);
        }
    }
}

