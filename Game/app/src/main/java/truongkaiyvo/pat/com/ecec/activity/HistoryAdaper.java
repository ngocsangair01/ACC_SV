package truongkaiyvo.pat.com.ecec.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoTuong;

public class HistoryAdaper extends BaseAdapter {
    List<String> stringList = new ArrayList<>();

    public HistoryAdaper(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_history,parent,false);
        String str = stringList.get(position);
        TextView vie;
        vie=view.findViewById(R.id.show_his);
        vie.setText(str);
        return view;
    }
}
