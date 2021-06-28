package truongkaiyvo.pat.com.ecec.fragment.caidat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

import truongkaiyvo.pat.com.ecec.R;
import truongkaiyvo.pat.com.ecec.databinding.FragmentFanpageBinding;

public class FanpageFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FanpageFragment() {
    }

    public static FanpageFragment newInstance(String param1, String param2) {
        FanpageFragment fragment = new FanpageFragment();
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

    FragmentFanpageBinding binding;
    ImageView face;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFanpageBinding.inflate(inflater, container, false);

        binding.fanpageFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                if (intent != null)
                    startActivity(intent);
                else {
                    Toast.makeText(getContext(), "123", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.fanpageGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                if (intent != null)
                    startActivity(intent);
                else {
                    Toast.makeText(getContext(), "123", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return binding.getRoot();
    }
}