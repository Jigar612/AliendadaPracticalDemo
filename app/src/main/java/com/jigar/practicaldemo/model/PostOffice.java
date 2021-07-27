package com.jigar.practicaldemo.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jigar.practicaldemo.BR;

public class PostOffice extends BaseObservable {
    @SerializedName("Name")
    @Expose
    public String Name;

    @SerializedName("Description")
    @Expose
    public String Description;

    @SerializedName("BranchType")
    @Expose
    public String BranchType;

    @SerializedName("DeliveryStatus")
    @Expose
    public String DeliveryStatus;

    @SerializedName("Circle")
    @Expose
    public String Circle;

    @SerializedName("District")
    @Expose
    public String District;

    @SerializedName("Division")
    @Expose
    public String Division;

    @SerializedName("Region")
    @Expose
    public String Region;

    @SerializedName("Block")
    @Expose
    public String Block;

    @SerializedName("State")
    @Expose
    public String State;

    @SerializedName("Country")
    @Expose
    public String Country;

    @SerializedName("Pincode")
    @Expose
    public String Pincode;

    @Bindable
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getBranchType() {
        return BranchType;
    }

    public void setBranchType(String branchType) {
        BranchType = branchType;
        notifyPropertyChanged(BR.branchType);
    }

    @Bindable
    public String getDeliveryStatus() {
        return DeliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        DeliveryStatus = deliveryStatus;
        notifyPropertyChanged(BR.deliveryStatus);
    }

    @Bindable
    public String getCircle() {
        return Circle;
    }

    public void setCircle(String circle) {
        Circle = circle;
        notifyPropertyChanged(BR.circle);
    }

    @Bindable
    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
        notifyPropertyChanged(BR.district);
    }

    @Bindable
    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
        notifyPropertyChanged(BR.division);
    }

    @Bindable
    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
        notifyPropertyChanged(BR.region);
    }

    @Bindable
    public String getBlock() {
        return Block;
    }

    public void setBlock(String block) {
        Block = block;
        notifyPropertyChanged(BR.block);
    }

    @Bindable
    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
        notifyPropertyChanged(BR.state);
    }

    @Bindable
    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
        notifyPropertyChanged(BR.country);
    }

    @Bindable
    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
        notifyPropertyChanged(BR.pincode);
    }
}
