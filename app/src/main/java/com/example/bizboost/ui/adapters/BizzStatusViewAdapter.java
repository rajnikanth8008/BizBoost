package com.example.bizboost.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bizboost.R;
import com.example.bizboost.StepperIndicator;
import com.example.bizboost.ui.home.HomeViewModel;

import java.util.List;

public class BizzStatusViewAdapter extends RecyclerView.Adapter<BizzStatusViewAdapter.BizzStatusList> {
    private List<HomeViewModel> homeViewModelList;
    private Context mCtx;

    public BizzStatusViewAdapter(Context mCtx, List<HomeViewModel> homeViewModelList) {
        this.homeViewModelList = homeViewModelList;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public BizzStatusViewAdapter.BizzStatusList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.registered_bizz_status_view, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new BizzStatusViewAdapter.BizzStatusList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BizzStatusList holder, int position) {
        //getting the product of the specified position
        HomeViewModel homeViewModel = homeViewModelList.get(position);

        //binding the data with the viewholder views
        holder.tv_bizz_name.setText(homeViewModel.getNameOfBusiness());
        holder.tv_bizz_category.setText(homeViewModel.getBusinessCategory());
        holder.tv_bizz_location.setText(homeViewModel.getBusinessLocation());
        holder.tv_bizz_app_status.setText(homeViewModel.getApplicationStatus());
        holder.bizz_status_stepper_indicator.setCurrentStep(homeViewModel.getApplicationStatusPosition());
    }

    @Override
    public int getItemCount() {
        return homeViewModelList.size();
    }

    public class BizzStatusList extends RecyclerView.ViewHolder {
        TextView tv_bizz_name, tv_bizz_category, tv_bizz_location, tv_bizz_app_status;
        StepperIndicator bizz_status_stepper_indicator;

        public BizzStatusList(View itemView) {
            super(itemView);
            tv_bizz_name = itemView.findViewById(R.id.tv_bizz_name);
            tv_bizz_category = itemView.findViewById(R.id.tv_bizz_category);
            tv_bizz_location = itemView.findViewById(R.id.tv_bizz_location);
            tv_bizz_app_status = itemView.findViewById(R.id.tv_bizz_app_status);
            bizz_status_stepper_indicator = itemView.findViewById(R.id.bizz_status_stepper_indicator);

        }
    }
}