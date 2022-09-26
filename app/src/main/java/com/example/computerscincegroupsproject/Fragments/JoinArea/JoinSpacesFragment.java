package com.example.computerscincegroupsproject.Fragments.JoinArea;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.computerscincegroupsproject.R;
import com.example.computerscincegroupsproject.databinding.FrgamentJoinSpaceBinding;
import com.google.android.material.textfield.TextInputLayout;

public class JoinSpacesFragment extends Fragment {

    private FrgamentJoinSpaceBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FrgamentJoinSpaceBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        binding.textInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("TAG", "beforeTextChanged: i: " + i+  " i1: "+ i1 + " i2:" + i2
                        + "   size: " + charSequence.length());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("TAG", "onTextChanged: i: " + i+  " i1: "+ i1 + " i2:" + i2
                 + "   size: " + charSequence.length());
                if ( charSequence.length() > 6){
                    binding.textInputLayout.setError("code must be 6 characters");
                    binding.textInputLayout.setErrorEnabled(true);
                }else if (charSequence.length() == 6){
                    binding.textInputLayout.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
                    binding.textInputLayout.setErrorEnabled(false);
                    binding.textInputLayout.setEndIconOnClickListener(view1 -> {
                        Navigation.findNavController(view1).navigate(R.id.action_SecondFragment_to_FirstFragment);
                    });
                }else{
                    binding.textInputLayout.setEndIconMode(TextInputLayout.END_ICON_NONE);
                    binding.textInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}