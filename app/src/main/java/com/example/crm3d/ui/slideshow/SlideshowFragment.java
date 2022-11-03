package com.example.crm3d.ui.slideshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.crm3d.R;
import com.example.crm3d.addstaff;
import com.example.crm3d.databinding.FragmentSlideshowBinding;
import com.example.crm3d.ui.gallery.GalleryFragment;
import com.example.crm3d.newproduct;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button crt_product_btn = (Button) root.findViewById(R.id.productcreate);

        crt_product_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect = new Intent(SlideshowFragment.this.getActivity(),newproduct.class);
                startActivity(redirect);
            }});

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}