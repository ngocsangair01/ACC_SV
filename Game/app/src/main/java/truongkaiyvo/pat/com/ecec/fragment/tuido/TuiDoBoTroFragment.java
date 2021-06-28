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
import truongkaiyvo.pat.com.ecec.adapter.tuido.TuiDoAdapter;
import truongkaiyvo.pat.com.ecec.adapter.tuido.TuiDoBoTroAdapter;
import truongkaiyvo.pat.com.ecec.adapter.tuido.TuiDoDaAdapter;
import truongkaiyvo.pat.com.ecec.data.Sup;
import truongkaiyvo.pat.com.ecec.databinding.FragmentTuiDoBoTroBinding;
import truongkaiyvo.pat.com.ecec.databinding.FragmentTuiDoDaBinding;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoBoTro;
import truongkaiyvo.pat.com.ecec.utl.tuido.TuiDoDa;

public class TuiDoBoTroFragment extends Fragment {

    FragmentTuiDoBoTroBinding binding;
    List<TuiDoBoTro> tuiDoBoTros = new ArrayList<>();
    public static TuiDoBoTroFragment newInstance(String param1, String param2) {
        TuiDoBoTroFragment fragment = new TuiDoBoTroFragment();
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
        binding = FragmentTuiDoBoTroBinding.inflate(inflater, container, false);
        Sup.taotuibotro();
        String str = Sup.user_data.getIdFigure();//ten_tuong+ten_tuong+
        String tmp="";
        for (int i=0;i< str.length();i++){
            if (str.charAt(i) == '+'){
                aa:for (TuiDoBoTro j : Sup.tuiDoBoTros){
                    if (tmp.compareTo(j.getId())==0){
                        tuiDoBoTros.add(j);
                        break aa;
                    }
                }
                tmp="";
            }
            else
                tmp+=str.charAt(i);
        }

        GridLayoutManager manager = new GridLayoutManager(getContext(),5, RecyclerView.VERTICAL,false);
        binding.showtuibotro.setLayoutManager(manager);
        TuiDoBoTroAdapter tuiDoBoTroAdapter = new TuiDoBoTroAdapter(tuiDoBoTros,getContext());
        binding.showtuibotro.setAdapter(tuiDoBoTroAdapter);

        return binding.getRoot();
    }
}