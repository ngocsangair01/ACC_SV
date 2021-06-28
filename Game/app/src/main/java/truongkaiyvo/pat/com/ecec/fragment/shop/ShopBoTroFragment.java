package truongkaiyvo.pat.com.ecec.fragment.shop;

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
import truongkaiyvo.pat.com.ecec.databinding.FragmentShopBotroBinding;
import truongkaiyvo.pat.com.ecec.utl.shop.ShopBoTro;


public class ShopBoTroFragment extends Fragment {

    FragmentShopBotroBinding binding;
    List<ShopBoTro> botroList = new ArrayList<>();
    public static ShopBoTroFragment newInstance(String param1, String param2) {
        ShopBoTroFragment fragment = new ShopBoTroFragment();
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
        binding = FragmentShopBotroBinding.inflate(inflater, container, false);

        botroList.add(new ShopBoTro("botro_01","Cứu trợ từ Rin",R.mipmap.botro_rin,800,80,"BUFF_HP_1_2",""));
        botroList.add(new ShopBoTro("botro_02","Cứu trợ từ Sakura",R.mipmap.botro_sakura,800,80,"BUFF_HP_all_2",""));
        botroList.add(new ShopBoTro("botro_03","Cứu trợ từ Tsunade",R.mipmap.botro_tsunade,800,80,"BUFF_HP_1_2",""));

        botroList.add(new ShopBoTro("botro_04","Cứu trợ từ Bát vĩ",R.mipmap.botro_nhatvi,800,80,"BUFF_HP_1_2",""));
        botroList.add(new ShopBoTro("botro_05","Cứu trợ từ Bát vĩ",R.mipmap.botro_nhivi,800,80,"BUFF_HP_1_2",""));
        botroList.add(new ShopBoTro("botro_06","Cứu trợ từ Bát vĩ",R.mipmap.botro_tamvi,800,80,"BUFF_HP_1_2",""));
        botroList.add(new ShopBoTro("botro_07","Cứu trợ từ Bát vĩ",R.mipmap.botro_tuvi,800,80,"BUFF_HP_1_2",""));
        botroList.add(new ShopBoTro("botro_08","Cứu trợ từ Bát vĩ",R.mipmap.botro_nguvi,800,80,"BUFF_HP_1_2",""));
        botroList.add(new ShopBoTro("botro_09","Cứu trợ từ Bát vĩ",R.mipmap.botro_lucvi,800,80,"BUFF_HP_1_2",""));
        botroList.add(new ShopBoTro("botro_10","Cứu trợ từ Bát vĩ",R.mipmap.botro_thatvi,800,80,"BUFF_HP_1_2",""));
        botroList.add(new ShopBoTro("botro_11","Cứu trợ từ Bát vĩ",R.mipmap.botro_batvi,800,80,"BUFF_HP_1_2",""));
        botroList.add(new ShopBoTro("botro_12","Cứu trợ từ Bát vĩ",R.mipmap.botro_cuuvi,800,80,"BUFF_HP_1_2",""));

        GridLayoutManager manager = new GridLayoutManager(getContext(),5, RecyclerView.VERTICAL,false);
        binding.showshopbotro.setLayoutManager(manager);
        truongkaiyvo.pat.com.ecec.adapter.shop.ShopBoTroAdapter shopBoTro_adapter = new truongkaiyvo.pat.com.ecec.adapter.shop.ShopBoTroAdapter(botroList,getContext());
        binding.showshopbotro.setAdapter(shopBoTro_adapter);

        return binding.getRoot();
    }
}