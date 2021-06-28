package truongkaiyvo.pat.com.ecec.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import truongkaiyvo.pat.com.ecec.fragment.friend.FriendFragment;
import truongkaiyvo.pat.com.ecec.fragment.friend.LoiMoiFragment;
import truongkaiyvo.pat.com.ecec.fragment.friend.TimKiemFragment;
import truongkaiyvo.pat.com.ecec.fragment.nangcap.NangBoTroFragment;
import truongkaiyvo.pat.com.ecec.fragment.nangcap.NangTuongFragment;

public class NangCapAdapter extends FragmentStatePagerAdapter {

    public NangCapAdapter(@NonNull @org.jetbrains.annotations.NotNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NangTuongFragment();
            case 1:
                return new NangBoTroFragment();
            default: return new NangTuongFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String titi = null;
        switch (position){
            case 0:
                titi="Nâng cấp tướng";
                break;
            case 1:
                titi="Nâng cấp bổ trợ";
                break;
            default: titi="Nâng cấp tướng";
                break;
        }
        return titi;
    }
}
