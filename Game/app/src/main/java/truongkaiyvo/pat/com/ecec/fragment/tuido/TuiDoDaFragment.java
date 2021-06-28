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
import truongkaiyvo.pat.com.ecec.adapter.tuido.TuiDoDaAdapter;
import truongkaiyvo.pat.com.ecec.data.Sup;
import truongkaiyvo.pat.com.ecec.databinding.FragmentTuiDoDaBinding;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoDa;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoTuong;

public class TuiDoDaFragment extends Fragment {

    FragmentTuiDoDaBinding binding;
    List<TuiDoDa> tuiDoDas = new ArrayList<>();
    public static TuiDoDaFragment newInstance(String param1, String param2) {
        TuiDoDaFragment fragment = new TuiDoDaFragment();
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
        binding = FragmentTuiDoDaBinding.inflate(inflater, container, false);

        Sup.taoda();
        String str = Sup.user_data.getIdFigure();//ten_tuong+ten_tuong+
        String tmp="";
        for (int i=0;i< str.length();i++){
            if (str.charAt(i) == '+'){
                aa:for (TuiDoDa j : Sup.tuiDoDas){
                    if (tmp.compareTo(j.getId())==0){
                        tuiDoDas.add(j);
                        break aa;
                    }
                }
                tmp="";
            }
            else
                tmp+=str.charAt(i);
        }

        GridLayoutManager manager = new GridLayoutManager(getContext(),5, RecyclerView.VERTICAL,false);
        binding.showtuida.setLayoutManager(manager);
        TuiDoDaAdapter tuiDoDaAdapter = new TuiDoDaAdapter(tuiDoDas,getContext());
        binding.showtuida.setAdapter(tuiDoDaAdapter);
        return binding.getRoot();
    }
}