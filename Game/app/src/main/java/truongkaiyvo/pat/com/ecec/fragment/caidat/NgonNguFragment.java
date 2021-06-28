package truongkaiyvo.pat.com.ecec.fragment.caidat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.databinding.FragmentFanpageBinding;
import truongkaiyvo.pat.com.ecec.databinding.FragmentNgonNguBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NgonNguFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NgonNguFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NgonNguFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NgonNguFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NgonNguFragment newInstance(String param1, String param2) {
        NgonNguFragment fragment = new NgonNguFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    SharedPreferences sharedPreferences;
    FragmentNgonNguBinding binding;
    ImageView face;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNgonNguBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        sharedPreferences = getActivity().getPreferences(getContext().MODE_PRIVATE);
        binding.ngonnguDangchon.setText(sharedPreferences.getString("dangchonngonngu","Tiếng Việt"));
        String s = sharedPreferences.getString("key", "");
        binding.ngonnguTienganh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ngonnguDangchon.setText("English");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("dangchonngonngu","English");
                editor.commit();
            }
        });
        binding.ngonnguViet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ngonnguDangchon.setText("Tiếng Việt");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("dangchonngonngu","Tiếng Việt");
                editor.commit();
            }
        });
        return binding.getRoot();
    }
}