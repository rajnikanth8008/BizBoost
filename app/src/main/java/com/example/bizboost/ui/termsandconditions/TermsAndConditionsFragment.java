package com.example.bizboost.ui.termsandconditions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bizboost.R;

public class TermsAndConditionsFragment extends Fragment {

    private TermsAndConditionsViewModel termsAndConditionsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        termsAndConditionsViewModel =
                ViewModelProviders.of(this).get(TermsAndConditionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_terms_and_conditions, container, false);
        final TextView textView = root.findViewById(R.id.text_terms_and_conditions);
        termsAndConditionsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
