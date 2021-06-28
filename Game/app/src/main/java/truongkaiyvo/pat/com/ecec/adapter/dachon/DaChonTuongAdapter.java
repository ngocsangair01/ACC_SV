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
import truongkaiyvo.pat.com.ecec.data.Sup;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoTuong;

public class DaChonTuongAdapter extends BaseAdapter {
    List<TuiDoTuong> tuiDoTuongs = new ArrayList<>();

    public DaChonTuongAdapter(List<TuiDoTuong> tuiDoTuongs) {
        this.tuiDoTuongs = tuiDoTuongs;
    }

    @Override
    public int getCount() {
        return tuiDoTuongs.size();
    }

    @Override
    public Object getItem(int position) {
        return tuiDoTuongs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_the_tuong_tui,parent,false);
        TuiDoTuong tuiDoTuong = tuiDoTuongs.get(position);
        ImageView anh;
        TextView name,atk,def;
        anh=view.findViewById(R.id.the_item);
        name=view.findViewById(R.id.the_item_name);
        atk=view.findViewById(R.id.cong_tui);
        def=view.findViewById(R.id.thu_tui);
        name.setText(tuiDoTuong.getName());
        anh.setImageResource(tuiDoTuong.getAnh());
        atk.setText(tuiDoTuong.getAtk()+"");
        def.setText(tuiDoTuong.getDef()+"");
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sup.chonTuongs.add(tuiDoTuong);
                tuiDoTuongs.remove(position);
                ChonTheDauMayActivity.update_chon_dau();
            }
        });
        return view;
    }
}
