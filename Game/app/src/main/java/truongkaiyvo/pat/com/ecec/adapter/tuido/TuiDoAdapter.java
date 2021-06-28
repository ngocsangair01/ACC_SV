package truongkaiyvo.pat.com.ecec.adapter.tuido;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import truongkaiyvo.pat.com.ecec.fragment.tuido.TuiDoBoTroFragment;
import truongkaiyvo.pat.com.ecec.fragment.tuido.TuiDoDaFragment;
import truongkaiyvo.pat.com.ecec.fragment.tuido.TuiDoTuongFragment;

public class TuiDoAdapter extends FragmentStatePagerAdapter {

    public TuiDoAdapter(@NonNull @org.jetbrains.annotations.NotNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TuiDoTuongFragment();
            case 1:
                return new TuiDoBoTroFragment();
            case 2:
                return new TuiDoDaFragment();
            default: return new TuiDoTuongFragment();
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
                titi="Tướng";
                break;
            case 1:
                titi="Bổ trợ";
                break;
            case 2:
                titi="Đá";
                break;
            default: titi="Tướng";
                break;
        }
        return titi;
    }
}

