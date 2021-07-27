package com.jigar.practicaldemo.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jigar.practicaldemo.R;
import com.jigar.practicaldemo.adapter.MyBaseAdapter;
import com.jigar.practicaldemo.databinding.ActivityMainBinding;
import com.jigar.practicaldemo.model.PostOffice;
import com.jigar.practicaldemo.network.model.ApiResponse;
import com.jigar.practicaldemo.network.retrofit.ApiClient;
import com.jigar.practicaldemo.network.retrofit.ApiService;
import com.jigar.practicaldemo.utility.AppUtil;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.jigar.practicaldemo.utility.AppUtil.getTag;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = getTag(this.getClass());
    private AppUtil appUtil;
    private final Context mContext = this;
    private ArrayList<PostOffice> postOfficeArrayList = new ArrayList<>();
    private MyBaseAdapter adapter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView((Activity) mContext, R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        appUtil = new AppUtil();

        binding.btnGetData.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGetData:
                String pincode = binding.edPincode.getText().toString().trim();
                if (!TextUtils.isEmpty(pincode)) {
                    callAPI(pincode);
                } else {
                    binding.edPincode.setError("Please enter pincode");
                }
                break;
        }
    }

    //region CALL Pincode API
    private void callAPI(String pincode) {
        try {

            //  PAGE_FROM = PAGE_FROM + 1;
            appUtil.showLoader(mContext);

            ApiService apiService = ApiClient.getClient(ApiService.class);

            Call<ArrayList<ApiResponse<ArrayList<PostOffice>>>> call = apiService.getPincodeList(pincode);
            call.enqueue(new Callback<ArrayList<ApiResponse<ArrayList<PostOffice>>>>() {
                @Override
                public void onResponse(@NotNull Call<ArrayList<ApiResponse<ArrayList<PostOffice>>>> call, Response<ArrayList<ApiResponse<ArrayList<PostOffice>>>> response) {
                    if (response.isSuccessful()) {
                        appUtil.dismissLoader();
                        assert response.body() != null;

                        ApiResponse<ArrayList<PostOffice>> resp = response.body().get(0);

                        if (resp.getStatus().equalsIgnoreCase("Success")) {

                            if (resp.getPostOffice().size() > 0) {
                                postOfficeArrayList = resp.getPostOffice();
                                adapter = new MyBaseAdapter(mContext, postOfficeArrayList, R.layout.item_pincode);
                                binding.rvList.setLayoutManager(new LinearLayoutManager(mContext));
                                binding.rvList.setAdapter(adapter);
                                binding.rvList.setItemAnimator(new DefaultItemAnimator());
                                binding.rvList.setNestedScrollingEnabled(true);

                            }
                        }
                    }
                }

                @Override
                public void onFailure(@NotNull Call<ArrayList<ApiResponse<ArrayList<PostOffice>>>> call, Throwable t) {
                    appUtil.dismissLoader();
                    Log.v(TAG, t.getMessage());
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
            Log.v(TAG, e.getLocalizedMessage());

            appUtil.dismissLoader();
        }
    }


    //endregion
}