package com.jigar.practicaldemo.network.retrofit;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.jigar.practicaldemo.utility.AppConfig.API_BASE_URL;


public class ApiClient {
    private static final Retrofit retrofit = null;

    private static final OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(15, TimeUnit.MINUTES)
            .readTimeout(15, TimeUnit.MINUTES)
            .writeTimeout(15, TimeUnit.MINUTES)
            .build();

    private static final OkHttpClient.Builder httpClient = new OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.MINUTES)
            .writeTimeout(15, TimeUnit.MINUTES)
            .connectTimeout(15, TimeUnit.MINUTES);

    private static final Retrofit.Builder builder = new Retrofit.Builder()

            .baseUrl(API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create());

    public static <S> S getClient(Class<S> serviceClass) {
        return getClient(serviceClass, null, null);
    }

    private static <S> S getClient(Class<S> serviceClass, String username, String password) {

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {

            String authToken = Credentials.basic(username, password);
            return getClient(serviceClass, authToken);
        }

        return getClient(serviceClass, null);
    }

    private static <S> S getClient(Class<S> serviceClass, @Nullable String authToken) {


        if (!TextUtils.isEmpty(authToken)) {

            AuthenticationInterceptor authenticationInterceptor = new AuthenticationInterceptor(authToken);

            if (!httpClient.interceptors().contains(authenticationInterceptor)) {
                httpClient.interceptors().add(authenticationInterceptor);
            }
        }
        builder.client(httpClient.build());
        Retrofit retrofit = builder.build();

        return retrofit.create(serviceClass);
    }
}
