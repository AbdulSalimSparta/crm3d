package com.example.crm3d.ui.gallery;

import android.app.Activity;
import android.content.Intent;
import android.hardware.camera2.params.RecommendedStreamConfigurationMap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.crm3d.R;
import com.example.crm3d.databinding.FragmentGalleryBinding;
import com.example.crm3d.databinding.FragmentHomeBinding;
import com.example.crm3d.addstaff;

public class GalleryFragment extends Fragment {




    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button crt_product_btn = (Button) root.findViewById(R.id.staffcreate);

        crt_product_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect = new Intent(GalleryFragment.this.getActivity(), addstaff.class);
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