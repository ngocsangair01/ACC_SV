package truongkaiyvo.pat.com.ecec.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import truongkaiyvo.pat.com.ecec.fragment.caidat.FanpageFragment;
import truongkaiyvo.pat.com.ecec.fragment.caidat.HoTroFragment;
import truongkaiyvo.pat.com.ecec.fragment.caidat.NgonNguFragment;
import truongkaiyvo.pat.com.ecec.fragment.shop.ShopBoTroFragment;
import truongkaiyvo.pat.com.ecec.fragment.shop.ShopDaFragment;
import truongkaiyvo.pat.com.ecec.fragment.shop.ShopTuongFragment;

public class CaiDatAdapter extends FragmentStatePagerAdapter {

    public CaiDatAdapter(@NonNull @org.jetbrains.annotations.NotNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NgonNguFragment();
            case 1:
                return new FanpageFragment();
            case 2:
                return new HoTroFragment();
            default: return new NgonNguFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String titi = null;
        switch (position){
            case 0:
                titi="Ngôn ngữ";
                break;
            case 1:
                titi="Fanpage";
                break;
            case 2:
                titi="Hộ Trợ";
                break;
            default: titi="Ngôn Ngữ";
                break;
        }
        return titi;
    }
}

