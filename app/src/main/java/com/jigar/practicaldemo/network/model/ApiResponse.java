package com.jigar.practicaldemo.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jigar.practicaldemo.BR;

public class ApiResponse<T> extends BaseObservable implements Parcelable {

    @SerializedName(value = "Message")
    @Expose
    private String message;


    @SerializedName(value = "Status")
    @Expose
    private String status;

    @SerializedName(value = "PostOffice")
    @Expose
    private T postOffice;

    protected ApiResponse(Parcel in) {
        message = in.readString();
        status = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeString(status);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ApiResponse> CREATOR = new Creator<ApiResponse>() {
        @Override
        public ApiResponse createFromParcel(Parcel in) {
            return new ApiResponse(in);
        }

        @Override
        public ApiResponse[] newArray(int size) {
            return new ApiResponse[size];
        }
    };

    @Bindable
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyPropertyChanged(BR.message);
    }

    @Bindable
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyPropertyChanged(BR.status);
    }

    @Bindable
    public T getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(T postOffice) {
        this.postOffice = postOffice;
        notifyPropertyChanged(BR.postOffice);
    }
}
