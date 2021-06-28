package truongkaiyvo.pat.com.ecec.adapter.friend;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import org.jetbrains.annotations.NotNull;

import truongkaiyvo.pat.com.ecec.fragment.friend.FriendFragment;
import truongkaiyvo.pat.com.ecec.fragment.friend.LoiMoiFragment;
import truongkaiyvo.pat.com.ecec.fragment.friend.TimKiemFragment;
import truongkaiyvo.pat.com.ecec.fragment.shop.ShopBoTroFragment;
import truongkaiyvo.pat.com.ecec.fragment.shop.ShopDaFragment;
import truongkaiyvo.pat.com.ecec.fragment.shop.ShopTuongFragment;

public class BanBeAdapter extends FragmentStatePagerAdapter {

    public BanBeAdapter(@NonNull @org.jetbrains.annotations.NotNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FriendFragment();
            case 1:
                return new LoiMoiFragment();
            case 2:
                return new TimKiemFragment();
            default: return new FriendFragment();
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
                titi="Bạn bè";
                break;
            case 1:
                titi="Mời mời";
                break;
            case 2:
                titi="Tìm kiếm";
                break;
            default: titi="Bạn bè";
                break;
        }
        return titi;
    }
}

