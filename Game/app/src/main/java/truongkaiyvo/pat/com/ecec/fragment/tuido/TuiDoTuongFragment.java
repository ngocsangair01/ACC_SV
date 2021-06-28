package truongkaiyvo.pat.com.ecec.fragment.tuido;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.adapter.tuido.TuiDoTuongAdapter;
import truongkaiyvo.pat.com.ecec.data.Sup;
import truongkaiyvo.pat.com.ecec.databinding.FragmentTuiDoTuongBinding;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoBoTro;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoTuong;

public class TuiDoTuongFragment extends Fragment {

    FragmentTuiDoTuongBinding binding;
    List<TuiDoTuong> tuiDoTuongs = new ArrayList<>();
    public static TuiDoTuongFragment newInstance(String param1, String param2) {
        TuiDoTuongFragment fragment = new TuiDoTuongFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTuiDoTuongBinding.inflate(inflater, container, false);

        Sup.taotuong();
        String str = Sup.user_data.getIdFigure();//ten_tuong+ten_tuong+
        String tmp="";
        for (int i=0;i< str.length();i++){
            if (str.charAt(i) == '+'){
                aa:for (TuiDoTuong j : Sup.tuiDoTuongs){
                    if (tmp.compareTo(j.getId())==0){
                        tuiDoTuongs.add(j);
                        break aa;
                    }
                }
                tmp="";
            }
            else
                tmp+=str.charAt(i);
        }


        GridLayoutManager manager = new GridLayoutManager(getContext(),5, RecyclerView.VERTICAL,false);
        binding.showtuituong.setLayoutManager(manager);
        TuiDoTuongAdapter tuiDoTuongAdapter = new TuiDoTuongAdapter(tuiDoTuongs,getContext());
        binding.showtuituong.setAdapter(tuiDoTuongAdapter);

        return binding.getRoot();
    }
}