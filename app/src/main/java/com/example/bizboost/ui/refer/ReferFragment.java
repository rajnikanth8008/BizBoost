package com.example.bizboost.ui.refer;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.bizboost.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Objects;

public class ReferFragment extends Fragment {
    private static final String TAG = "ReferFragment";
    private ReferViewModel referViewModel;
    TextInputEditText et_refer_name_of_bizz, et_refer_name_of_referee, et_refer_contact, et_refer_email;
    TextView tv_relation;
    AppCompatCheckBox chk_refer;
    Button bt_refer_submit;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        referViewModel = ViewModelProviders.of(this).get(ReferViewModel.class);
        View root = inflater.inflate(R.layout.fragment_refer, container, false);
        initializeControls(root);
        tv_relation.setOnClickListener(v -> {
            loadRelations();
        });
        return root;
    }

    private void initializeControls(View root) {
        try {
            et_refer_name_of_bizz = root.findViewById(R.id.et_refer_name_of_bizz);
            et_refer_name_of_referee = root.findViewById(R.id.et_refer_name_of_referee);
            et_refer_contact = root.findViewById(R.id.et_refer_contact);
            et_refer_email = root.findViewById(R.id.et_refer_email);

            tv_relation = root.findViewById(R.id.tv_relation);

            chk_refer = root.findViewById(R.id.chk_refer);

            bt_refer_submit = root.findViewById(R.id.bt_refer_submit);
        } catch (Exception e) {
            Log.e(TAG, "initializeControls: ", e);
        }
    }

    private void loadRelations() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
            LayoutInflater layoutInflater = this.getLayoutInflater();
            View dialogView = layoutInflater.inflate(R.layout.dropdownview, null);
            dialogBuilder.setView(dialogView);
            LinearLayout dropdownlist = dialogView.findViewById(R.id.dropdownlist);
            ArrayList<String> list = relationshipList();
            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();
            for(int i = 0; i < list.size(); i++){
                View view = getLayoutInflater().inflate(R.layout.textview,null);
                AppCompatTextView actv_textview = view.findViewById(R.id.actv_textview);
                actv_textview.setText(list.get(i));
                final int pos = i;
                actv_textview.setOnClickListener(v -> {
                    tv_relation.setText(list.get(pos));
                    alertDialog.dismiss();
                });
                dropdownlist.addView(view);
            }
        } catch (Exception e) {
            Log.e(TAG, "loadRelations: ", e);
        }
    }
    private ArrayList<String> relationshipList() {
        ArrayList<String> relationshipList = new ArrayList<>();
        try{
            relationshipList.add("Mother");
            relationshipList.add("Father");
            relationshipList.add("Brother");
            relationshipList.add("Sister");
            relationshipList.add("Spouse");
            relationshipList.add("Others");
        }catch (Exception e){
            Log.e(TAG, "instance initializer: ", e);
        }return relationshipList;
    }
}