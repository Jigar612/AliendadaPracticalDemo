package com.jigar.practicaldemo.adapter;

import android.annotation.SuppressLint;
import android.text.Html;
import android.text.TextUtils;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.BindingAdapter;

public class ViewBindingAdapter {

    @SuppressLint("SetTextI18n")
    @BindingAdapter("setText")
    public static void setText(AppCompatTextView appCompatTextView, String value) {

        if (!TextUtils.isEmpty(value)) {
            appCompatTextView.setText(Html.fromHtml(value));

        } else {
            appCompatTextView.setText("-");
        }
    }
}
