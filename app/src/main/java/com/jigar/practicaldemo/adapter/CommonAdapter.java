package com.jigar.practicaldemo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.jigar.practicaldemo.listener.CommonActionListener;


public abstract class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.MyViewHolder> {

    private Context mContext;
    private String endPoint;

    private CommonActionListener commonActionListener;

    public CommonAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public CommonAdapter(Context mContext, String endPoint) {
        this.mContext = mContext;
        this.endPoint = endPoint;
    }

    public CommonAdapter(Context mContext, CommonActionListener commonActionListener) {
        this.mContext = mContext;
        this.commonActionListener = commonActionListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), getLayoutIdForType(viewType), parent, false);
        return new MyViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        mContext = holder.binding.getRoot().getContext();
        holder.setBinding(getDataAtPosition(position));

       /* if (holder.binding instanceof ItemAuctionListBinding) {
            ((ItemAuctionListBinding) holder.binding).tvSrNO.setText("#" + (position + 1) + ".");

        }*/

    }

    public abstract Object getDataAtPosition(int position);

    public abstract int getLayoutIdForType(int viewType);

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ViewDataBinding binding;

        @SuppressLint("SetTextI18n")
        MyViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                //case R.id.text_input_password_toggle:
                   /* if (binding instanceof ItemAuctionCarListBinding) {
                        auctionClickListener.onAuctionClick(getLayoutPosition(), countDown.getMillisInFuture());
                    } else {
                        commonActionListener.onViewClick(getLayoutPosition());
                    }*/
                //  break;
            }
        }

        public void setBinding(Object obj) {
            //  binding.setVariable(BR.data, obj);
            binding.executePendingBindings();

        }
    }
}
