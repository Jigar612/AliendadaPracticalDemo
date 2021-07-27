package com.jigar.practicaldemo.network.retrofit;

import com.jigar.practicaldemo.model.PostOffice;
import com.jigar.practicaldemo.network.model.ApiResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    //region API for Pincode
    @GET("{pincode}")
    Call<ArrayList<ApiResponse<ArrayList<PostOffice>>>> getPincodeList(@Path("pincode") String postcode);

}
