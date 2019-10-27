package com.example.bizboost.ui.account;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.bizboost.R;
import com.google.android.material.textfield.TextInputEditText;

public class AccountFragment extends Fragment {
    private static final String TAG = "AccountFragment";
    private AccountViewModel accountViewModel;
    TextInputEditText et_acc_id, et_acc_name, et_acc_registered_date, et_acc_contact, et_acc_email;
    TextView tv_acc_reg_bizz_explore;
    LinearLayout ll_acc_reg_bizz_explore;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModel =
                ViewModelProviders.of(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_account, container, false);
        initializeControls(root);
        tv_acc_reg_bizz_explore.setText("+");
        ll_acc_reg_bizz_explore.setVisibility(View.GONE);
        tv_acc_reg_bizz_explore.setOnClickListener(v -> {
            tv_acc_reg_bizz_explore.setText(tv_acc_reg_bizz_explore.getText().toString().equals("+") ? "-" : "+");
            boolean plus = tv_acc_reg_bizz_explore.getText().toString().equals("+");
            ll_acc_reg_bizz_explore.setVisibility(plus ? View.GONE : View.VISIBLE);
        });
        return root;
    }

    private void initializeControls(View root) {
        try {
            et_acc_id = root.findViewById(R.id.et_acc_id);
            et_acc_name = root.findViewById(R.id.et_acc_name);
            et_acc_registered_date = root.findViewById(R.id.et_acc_registered_date);
            et_acc_contact = root.findViewById(R.id.et_acc_contact);
            et_acc_email = root.findViewById(R.id.et_acc_email);

            tv_acc_reg_bizz_explore = root.findViewById(R.id.tv_acc_reg_bizz_explore);
            ll_acc_reg_bizz_explore = root.findViewById(R.id.ll_acc_reg_bizz_explore);
        } catch (Exception e) {
            Log.e(TAG, "initializeControls: ", e);
        }
    }
}