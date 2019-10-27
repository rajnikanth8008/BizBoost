package com.example.bizboost.ui.help;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.bizboost.R;
import com.google.android.material.textfield.TextInputEditText;

public class HelpFragment extends Fragment {
    private static final String TAG = "HelpFragment";
    private HelpViewModel helpViewModel;
    TextView tv_help_explore;
    TextInputEditText et_help_application_no, et_help_issue;
    Button bt_help_submit;
    LinearLayout ll_help_explore;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        helpViewModel = ViewModelProviders.of(this).get(HelpViewModel.class);
        View root = inflater.inflate(R.layout.fragment_help, container, false);
        initializeControls(root);
        tv_help_explore.setText("+");
        ll_help_explore.setVisibility(View.GONE);
        tv_help_explore.setOnClickListener(v -> {
            tv_help_explore.setText(tv_help_explore.getText().toString().equals("+") ? "-" : "+");
            boolean plus = tv_help_explore.getText().toString().equals("+");
            ll_help_explore.setVisibility(plus ? View.GONE : View.VISIBLE);
        });
        return root;
    }

    private void initializeControls(View root) {
        try {
            tv_help_explore = root.findViewById(R.id.tv_help_explore);
            et_help_application_no = root.findViewById(R.id.et_help_application_no);
            et_help_issue = root.findViewById(R.id.et_help_issue);
            bt_help_submit = root.findViewById(R.id.bt_help_submit);
            ll_help_explore = root.findViewById(R.id.ll_help_explore);
        } catch (Exception e) {
            Log.e(TAG, "initializeControls: ", e);
        }
    }
}