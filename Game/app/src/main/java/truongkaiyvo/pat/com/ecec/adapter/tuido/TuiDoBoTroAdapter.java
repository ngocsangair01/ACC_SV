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
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoBoTro;

public class TuiDoBoTroAdapter extends RecyclerView.Adapter<TuiDoBoTroAdapter.ViewHolder> {

    List<TuiDoBoTro> tuiDoBoTros = new ArrayList<>();
    Context context;

    public TuiDoBoTroAdapter(List<TuiDoBoTro> tuiDoBoTros, Context context) {
        this.tuiDoBoTros = tuiDoBoTros;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_the_da_va_botro_tui, parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TuiDoBoTro tuiDoBoTro = tuiDoBoTros.get(position);
        holder.imv.setImageResource(tuiDoBoTro.getAnh());
        holder.name.setText(tuiDoBoTro.getName());
    }

    @Override
    public int getItemCount() {
        return tuiDoBoTros.size();
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


