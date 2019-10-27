package com.example.bizboost.ui.businessforms;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.bizboost.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class BusinessFormsFragment extends Fragment {
    private static final String TAG = "BusinessFormsFragment";
    private BusinessFormsViewModel businessFormsViewModel;
    TextView tv_bizz_payment, tv_bizz_payment_pdf_view,tv_bizz_gst, tv_bizz_gst_pdf_view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        businessFormsViewModel =
                ViewModelProviders.of(this).get(BusinessFormsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_businessforms, container, false);
        initializeControls(root);
        tv_bizz_payment.setText("+");
        tv_bizz_payment_pdf_view.setVisibility(View.GONE);
        tv_bizz_payment.setOnClickListener(v -> {
            tv_bizz_payment.setText(tv_bizz_payment.getText().toString().equals("+") ? "-" : "+");
            boolean plus = tv_bizz_payment.getText().toString().equals("+");
            tv_bizz_payment_pdf_view.setVisibility(plus ? View.GONE : View.VISIBLE);
        });
        tv_bizz_payment_pdf_view.setOnClickListener(v -> {
            pdfView("blank-receipt.pdf");
        });

        tv_bizz_gst.setText("+");
        tv_bizz_gst_pdf_view.setVisibility(View.GONE);
        tv_bizz_gst.setOnClickListener(v -> {
            tv_bizz_gst.setText(tv_bizz_gst.getText().toString().equals("+") ? "-" : "+");
            boolean plus = tv_bizz_gst.getText().toString().equals("+");
            tv_bizz_gst_pdf_view.setVisibility(plus ? View.GONE : View.VISIBLE);
        });
        tv_bizz_gst_pdf_view.setOnClickListener(v -> {
            pdfView("gst_invoice.pdf");
        });
        return root;
    }

    private void initializeControls(View root) {
        try {
            tv_bizz_payment = root.findViewById(R.id.tv_bizz_payment);
            tv_bizz_payment_pdf_view = root.findViewById(R.id.tv_bizz_payment_pdf_view);

            tv_bizz_gst = root.findViewById(R.id.tv_bizz_gst);
            tv_bizz_gst_pdf_view = root.findViewById(R.id.tv_bizz_gst_pdf_view);
        } catch (Exception e) {
            Log.e(TAG, "initializeControls: ", e);
        }
    }
    public void pdfView(String pdfFileName){
        try{
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
            LayoutInflater layoutInflater = this.getLayoutInflater();
            View dialogView = layoutInflater.inflate(R.layout.pdf_viewer, null);
            dialogBuilder.setView(dialogView);
            PDFView pdfv = dialogView.findViewById(R.id.pdfView);
            pdfv.fromAsset(pdfFileName)
                    .load();
            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();
        }catch (Exception e){
            Log.e(TAG, "pdfView: ", e);
        }
    }
}