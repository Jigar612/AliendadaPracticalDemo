package com.jigar.practicaldemo.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jigar.practicaldemo.BR;

public class ApiRequest extends BaseObservable implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;


    @Bindable
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
    }

    public void readFromParcel(Parcel source) {
        this.id = (Integer) source.readValue(Integer.class.getClassLoader());
    }

    public ApiRequest() {
    }

    protected ApiRequest(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<ApiRequest> CREATOR = new Creator<ApiRequest>() {
        @Override
        public ApiRequest createFromParcel(Parcel source) {
            return new ApiRequest(source);
        }

        @Override
        public ApiRequest[] newArray(int size) {
            return new ApiRequest[size];
        }
    };
}
