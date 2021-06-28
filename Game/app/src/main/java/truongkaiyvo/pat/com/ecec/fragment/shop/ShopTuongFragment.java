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
import truongkaiyvo.pat.com.ecec.adapter.shop.ShopTuongAdapter;
import truongkaiyvo.pat.com.ecec.databinding.FragmentShopTuongBinding;
import truongkaiyvo.pat.com.ecec.utl.shop.ShopBoTro;
import truongkaiyvo.pat.com.ecec.utl.shop.ShopTuong;

public class ShopTuongFragment extends Fragment {
    FragmentShopTuongBinding binding;
    List<ShopTuong> shopTuongList = new ArrayList<>();
    public static ShopTuongFragment newInstance(String param1, String param2) {
        ShopTuongFragment fragment = new ShopTuongFragment();
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
        binding = truongkaiyvo.pat.com.ecec.databinding.FragmentShopTuongBinding.inflate(inflater, container, false);

        shopTuongList.add(new ShopTuong("tuong_sin_01", "Asuma",R.mipmap.sin_akatsuchi_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_02", "Bruto",R.mipmap.sin_asuma_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_03", "Jraiya",R.mipmap.sin_bee_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_04", "Kurrosuchi",R.mipmap.sin_boruto_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_05", "Zabuza",R.mipmap.sin_danzo_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_05", "Bruto",R.mipmap.sin_darui_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_06", "Jraiya",R.mipmap.sin_deidara_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_07", "Kurrosuchi",R.mipmap.sin_haku_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_08", "Zabuza",R.mipmap.sin_hiruzen_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_09", "Asuma",R.mipmap.sin_jraiya_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_10", "Bruto",R.mipmap.sin_jugo_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_11", "Jraiya",R.mipmap.sin_kakashi_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_12", "Kurrosuchi",R.mipmap.sin_kisame_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_13", "Zabuza",R.mipmap.sin_konohamaru_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_14", "Asuma",R.mipmap.sin_korosuchi_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_15", "Bruto",R.mipmap.sin_korosuki_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_16", "Jraiya",R.mipmap.sin_mirai_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_17", "Kurrosuchi",R.mipmap.sin_orochimaru_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_18", "Zabuza",R.mipmap.sin_rand_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_19", "Asuma",R.mipmap.sin_shy_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_20", "Jraiya",R.mipmap.sin_suigetsu_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_21", "Kurrosuchi",R.mipmap.sin_temari_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_22", "Zabuza",R.mipmap.sin_yamato_1,1200,120,5,4,"[Tướng sịn]\n"));
        shopTuongList.add(new ShopTuong("tuong_sin_23", "Asuma",R.mipmap.sin_zabuza_1,1200,120,5,4,"[Tướng sịn]\n"));

//      ==================================  Thường =====================================

        shopTuongList.add(new ShopTuong("tuong_thuong_01", "Asuma",R.mipmap.thuong_akatsuchi_1,600,60,3,2,"[Tướng thường]\n"));
        shopTuongList.add(new ShopTuong("tuong_thuong_02", "Asuma",R.mipmap.thuong_akatsuchi_2,600,60,3,2,"[Tướng thường]\n"));
        shopTuongList.add(new ShopTuong("tuong_thuong_03", "Asuma",R.mipmap.thuong_akatsuchi_3,600,60,3,2,"[Tướng thường]\n"));

        shopTuongList.add(new ShopTuong("tuong_thuong_04", "Asuma",R.mipmap.thuong_darui_1,600,60,3,2,"[Tướng thường]\n"));
        shopTuongList.add(new ShopTuong("tuong_thuong_05", "Asuma",R.mipmap.thuong_darui_2,600,60,3,2,"[Tướng thường]\n"));
        shopTuongList.add(new ShopTuong("tuong_thuong_06", "Asuma",R.mipmap.thuong_darui_3,600,60,3,2,"[Tướng thường]\n"));

        shopTuongList.add(new ShopTuong("tuong_thuong_07", "Asuma",R.mipmap.thuong_kakashi_1,600,60,3,2,"[Tướng thường]\n"));
        shopTuongList.add(new ShopTuong("tuong_thuong_08", "Asuma",R.mipmap.thuong_kakashi_2,600,60,3,2,"[Tướng thường]\n"));
        shopTuongList.add(new ShopTuong("tuong_thuong_09", "Asuma",R.mipmap.thuong_kakashi_3,600,60,3,2,"[Tướng thường]\n"));

        shopTuongList.add(new ShopTuong("tuong_thuong_10", "Asuma",R.mipmap.thuong_danzo_1,600,60,3,2,"[Tướng thường]\n"));
        shopTuongList.add(new ShopTuong("tuong_thuong_11", "Asuma",R.mipmap.thuong_danzo_2,600,60,3,2,"[Tướng thường]\n"));
        shopTuongList.add(new ShopTuong("tuong_thuong_12", "Asuma",R.mipmap.thuong_danzo_3,600,60,3,2,"[Tướng thường]\n"));

        shopTuongList.add(new ShopTuong("tuong_thuong_13", "Asuma",R.mipmap.thuong_zabuza_1,600,60,3,2,"[Tướng thường]\n"));
        shopTuongList.add(new ShopTuong("tuong_thuong_14", "Asuma",R.mipmap.thuong_zabuza_2,600,60,3,2,"[Tướng thường]\n"));
        shopTuongList.add(new ShopTuong("tuong_thuong_15", "Asuma",R.mipmap.thuong_zabuza_3,600,60,3,2,"[Tướng thường]\n"));


        GridLayoutManager manager = new GridLayoutManager(getContext(),5,RecyclerView.VERTICAL,false);
        binding.showshoptuong.setLayoutManager(manager);
        ShopTuongAdapter shopTuong_adapter = new ShopTuongAdapter(shopTuongList,getContext());
        binding.showshoptuong.setAdapter(shopTuong_adapter);



        return binding.getRoot();
    }
}