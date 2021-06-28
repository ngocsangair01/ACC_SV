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
import truongkaiyvo.pat.com.ecec.adapter.shop.ShopDaAdapter;
import truongkaiyvo.pat.com.ecec.databinding.FragmentShopDaBinding;
import truongkaiyvo.pat.com.ecec.utl.shop.ShopDa;


public class ShopDaFragment extends Fragment {
    FragmentShopDaBinding binding;
    List<ShopDa> shopDaList = new ArrayList<>();
    public static ShopDaFragment newInstance(String param1, String param2) {
        ShopDaFragment fragment = new ShopDaFragment();
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
        binding = FragmentShopDaBinding.inflate(inflater, container, false);

        shopDaList.add(new ShopDa("da_01","Bí kíp kỹ năng", R.mipmap.da_02,1500,150,"Dùng để nâng cấp tường"));
        shopDaList.add(new ShopDa("da_02","Bí kíp bổ trợ",R.mipmap.da_01,1500,150,"Dùng để nâng cấp bổ trợ"));

        GridLayoutManager manager = new GridLayoutManager(getContext(),5, RecyclerView.VERTICAL,false);
        binding.showshopda.setLayoutManager(manager);
        ShopDaAdapter shopDa_adapter = new ShopDaAdapter(shopDaList,getContext());
        binding.showshopda.setAdapter(shopDa_adapter);



        return binding.getRoot();
    }
}