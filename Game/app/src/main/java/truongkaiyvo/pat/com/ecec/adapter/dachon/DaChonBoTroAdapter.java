package truongkaiyvo.pat.com.ecec.adapter.dachon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.activity.ChonTheDauMayActivity;
import truongkaiyvo.pat.com.ecec.adapter.chontuong.ChonBoTroAdapter;
import truongkaiyvo.pat.com.ecec.data.Sup;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoBoTro;

public class DaChonBoTroAdapter extends BaseAdapter {
    List<TuiDoBoTro> tuiDoBoTros = new ArrayList<>();

    public DaChonBoTroAdapter(List<TuiDoBoTro> tuiDoBoTros) {
        this.tuiDoBoTros = tuiDoBoTros;
    }

    @Override
    public int getCount() {
        return tuiDoBoTros.size();
    }

    @Override
    public Object getItem(int position) {
        return tuiDoBoTros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_the_da_va_botro_tui,parent,false);
        TuiDoBoTro tuiDoBoTro = tuiDoBoTros.get(position);
        ImageView anh;
        TextView name;
        anh=view.findViewById(R.id.the_item);
        name=view.findViewById(R.id.the_item_name);

        name.setText(tuiDoBoTro.getName());
        anh.setImageResource(tuiDoBoTro.getAnh());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sup.chonBotros.add(tuiDoBoTro);
                tuiDoBoTros.remove(position);
                ChonTheDauMayActivity.update_chon_dau();
            }
        });
        return view;
    }
}
