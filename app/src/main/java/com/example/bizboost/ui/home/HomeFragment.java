package com.example.bizboost.ui.home;

import android.graphics.Color;
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
import com.example.bizboost.StepperIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private static final String TAG = "HomeFragment";
    private HomeViewModel homeViewModel;
    TextView tv_reg_bizz_explore, tv_new_bizz_explore;
    LinearLayout ll_reg_bizz_explore, ll_add_new_bizz;
    TextInputEditText et_name_of_bizz, et_name_of_applicant, et_bizz_location, et_contact, et_email;
    Button bt_date, bt_time;
    private DatePickerDialog dpd;
    private TimePickerDialog tpd;
    StepperIndicator stepper_indicator_one, stepper_indicator_two;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initializeControls(root);

        tv_reg_bizz_explore.setText("+");
        ll_reg_bizz_explore.setVisibility(View.GONE);

        tv_new_bizz_explore.setText("-");
        ll_add_new_bizz.setVisibility(View.VISIBLE);

        tv_reg_bizz_explore.setOnClickListener(v -> {
            tv_reg_bizz_explore.setText(tv_reg_bizz_explore.getText().toString().equals("+") ? "-" : "+");
            boolean plus = tv_reg_bizz_explore.getText().toString().equals("+");
            ll_reg_bizz_explore.setVisibility(plus ? View.GONE : View.VISIBLE);
        });

        tv_new_bizz_explore.setOnClickListener(v -> {
            tv_new_bizz_explore.setText(tv_new_bizz_explore.getText().toString().equals("+") ? "-" : "+");
            boolean plus = tv_new_bizz_explore.getText().toString().equals("+");
            ll_add_new_bizz.setVisibility(plus ? View.GONE : View.VISIBLE);
            if (plus) {
                clear();
            }
        });

        bt_date.setOnClickListener(v -> {
            Calendar now = Calendar.getInstance();
            if (dpd == null) {
                dpd = DatePickerDialog.newInstance(
                        HomeFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
            } else {
                dpd.initialize(
                        HomeFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
            }
            dpd.vibrate(true);
            dpd.setAccentColor(Color.parseColor("#9C27B0"));
            /*limited days*/
            Calendar[] days = new Calendar[13];
            for (int i = -6; i < 7; i++) {
                Calendar day = Calendar.getInstance();
                day.add(Calendar.DAY_OF_MONTH, i * 2);
                days[i + 6] = day;
            }
            dpd.setSelectableDays(days);
//                if (dpd.getVersion() == DatePickerDialog.Version.VERSION_1) {
            dpd.setScrollOrientation(DatePickerDialog.ScrollOrientation.HORIZONTAL);
//                } else {
//                    dpd.setScrollOrientation(DatePickerDialog.ScrollOrientation.VERTICAL);
//                }
            dpd.setOnCancelListener(dialog -> {
                Log.d(TAG, "Dialog was cancelled");
                dpd = null;
            });
            dpd.show(requireFragmentManager(), "Datepickerdialog");
        });

        bt_time.setOnClickListener(v -> {
            Calendar now = Calendar.getInstance();
            if (tpd == null) {
                tpd = TimePickerDialog.newInstance(
                        HomeFragment.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        false
                );
            } else {
                tpd.initialize(
                        HomeFragment.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        now.get(Calendar.SECOND),
                        false
                );
            }
            tpd.vibrate(true);
            tpd.setAccentColor(Color.parseColor("#9C27B0"));
            //            tpd.enableSeconds(true);
            /*limited time*/
//            if (enableSeconds.isChecked()) {
//                tpd.setTimeInterval(3, 5, 10);
//            } else {
            tpd.setTimeInterval(1, 30, 60);
//            }
            tpd.setOnCancelListener(dialogInterface -> {
                Log.d(TAG, "Dialog was cancelled");
                tpd = null;
            });
            tpd.show(requireFragmentManager(), "Timepickerdialog");
        });
        return root;
    }

    private void initializeControls(View root) {
        try {
            tv_reg_bizz_explore = root.findViewById(R.id.tv_reg_bizz_explore);
            tv_new_bizz_explore = root.findViewById(R.id.tv_new_bizz_explore);

            ll_reg_bizz_explore = root.findViewById(R.id.ll_reg_bizz_explore);
            ll_add_new_bizz = root.findViewById(R.id.ll_add_new_bizz);

            stepper_indicator_one = root.findViewById(R.id.stepper_indicator_one);
            stepper_indicator_one.setCurrentStep(2);
            stepper_indicator_two = root.findViewById(R.id.stepper_indicator_two);
            stepper_indicator_two.setCurrentStep(4);

            et_name_of_bizz = root.findViewById(R.id.et_name_of_bizz);
            et_name_of_applicant = root.findViewById(R.id.et_name_of_applicant);
            et_bizz_location = root.findViewById(R.id.et_bizz_location);
            et_contact = root.findViewById(R.id.et_contact);
            et_email = root.findViewById(R.id.et_email);
            bt_date = root.findViewById(R.id.bt_date);
            bt_time = root.findViewById(R.id.bt_time);
        } catch (Exception e) {
            Log.e(TAG, "initializeControls: ", e);
        }
    }

    private void clear() {
        et_name_of_bizz.setText("");
        et_name_of_applicant.setText("");
        et_bizz_location.setText("");
        et_contact.setText("");
        et_email.setText("");
        bt_date.setText("Date");
        bt_time.setText("Time");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        try {
            Log.d(TAG, "onDateSet() called with: view = [" + view + "], year = [" + year + "], monthOfYear = [" + monthOfYear + "], dayOfMonth = [" + dayOfMonth + "]");
            String date = /*"You picked the following date: "*/+dayOfMonth + "/" + (++monthOfYear) + "/" + year;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date dt = sdf.parse(date);
            sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
            bt_date.setText(sdf.format(dt));
            dpd = null;
        } catch (Exception e) {
            Log.e(TAG, "onDateSet: ", e);
        }
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        try {
            Log.d(TAG, "onTimeSet() called with: view = [" + view + "], hourOfDay = [" + hourOfDay + "], minute = [" + minute + "], second = [" + second + "]");
            String amOrPm = "AM";
            if (hourOfDay > 12) {
                hourOfDay = hourOfDay - 12;
                amOrPm = "PM";
            }
            String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
            String minuteString = minute < 10 ? "0" + minute : "" + minute;
            String secondString = second < 10 ? "0" + second : "" + second;
            String time = /*"You picked the following time: "+*/hourString + ":" + minuteString + " " + amOrPm/* + "m" + secondString + "s"*/;
            bt_time.setText(time);
            tpd = null;
        } catch (Exception e) {
            Log.e(TAG, "onTimeSet: ", e);
        }
    }
}