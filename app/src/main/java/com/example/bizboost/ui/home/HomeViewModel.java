package com.example.bizboost.ui.home;

import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private String nameOfBusiness;
    private String nameOfApplicant;
    private String businessLocation;
    private String contactNumber;
    private String eMail;
    private String appointmentDate;
    private String appointmentTime;
    private String businessCategory;
    private String applicationStatus;
    private int applicationStatusPosition;

    public int getApplicationStatusPosition() {
        return applicationStatusPosition;
    }

    public void setApplicationStatusPosition(int applicationStatusPosition) {
        this.applicationStatusPosition = applicationStatusPosition;
    }

    private boolean isAgreedToTerms;

    public HomeViewModel(String nameOfBusiness, String businessLocation, String businessCategory, String applicationStatus, int applicationStatusPosition) {
        this.nameOfBusiness = nameOfBusiness;
        this.businessLocation = businessLocation;
        this.businessCategory = businessCategory;
        this.applicationStatus = applicationStatus;
        this.applicationStatusPosition = applicationStatusPosition;
    }

    public HomeViewModel(String nameOfBusiness, String nameOfApplicant, String businessLocation, String contactNumber, String eMail, String appointmentDate, String appointmentTime, boolean isAgreedToTerms) {
        this.nameOfBusiness = nameOfBusiness;
        this.nameOfApplicant = nameOfApplicant;
        this.businessLocation = businessLocation;
        this.contactNumber = contactNumber;
        this.eMail = eMail;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.isAgreedToTerms = isAgreedToTerms;
    }


    public String getNameOfBusiness() {
        return nameOfBusiness;
    }

    public void setNameOfBusiness(String nameOfBusiness) {
        this.nameOfBusiness = nameOfBusiness;
    }

    public String getNameOfApplicant() {
        return nameOfApplicant;
    }

    public void setNameOfApplicant(String nameOfApplicant) {
        this.nameOfApplicant = nameOfApplicant;
    }

    public String getBusinessLocation() {
        return businessLocation;
    }

    public void setBusinessLocation(String businessLocation) {
        this.businessLocation = businessLocation;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public boolean isAgreedToTerms() {
        return isAgreedToTerms;
    }

    public void setAgreedToTerms(boolean agreedToTerms) {
        isAgreedToTerms = agreedToTerms;
    }
}