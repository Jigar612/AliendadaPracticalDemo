package com.jigar.practicaldemo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.jigar.practicaldemo.databinding.ItemPincodeBinding;
import com.jigar.practicaldemo.listener.CommonActionListener;
import com.jigar.practicaldemo.model.PostOffice;

import java.util.ArrayList;

import static com.jigar.practicaldemo.utility.AppUtil.toStr;

public class MyBaseAdapter extends RecyclerView.Adapter<MyBaseAdapter.MyViewHolder> {

    private final Context mContext;
    private final int rawLayoutId;
    // private final AppUtil appUtil;
    private ArrayList<?> itemsArrayList;
    private CommonActionListener commonActionListener;

    public MyBaseAdapter(Context mContext, ArrayList<?> itemsArrayList, int rawLayoutId) {
        this.mContext = mContext;
        this.itemsArrayList = itemsArrayList;
        this.rawLayoutId = rawLayoutId;
        //  appUtil = new AppUtil();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), rawLayoutId, parent, false);
        return new MyViewHolder(binding);

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Object object = itemsArrayList.get(position);
        holder.setBinding(object);
    }

    @Override
    public int getItemCount() {
        return itemsArrayList != null ? itemsArrayList.size() : 0;
    }

    public void filterList(ArrayList<?> itemsArrayList) {
        this.itemsArrayList = itemsArrayList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ViewDataBinding binding;

        public MyViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            /*if (binding instanceof ItemLrListBinding) {

                commonActionListener = (CommonActionListener) mContext;
                ((ItemLrListBinding) binding).btnView.setOnClickListener(this);
                ((ItemLrListBinding) binding).btnEdit.setOnClickListener(this);
                ((ItemLrListBinding) binding).btnDelete.setOnClickListener(this);


            }*/
        }

        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

 /*               case R.id.btnView:
                    commonActionListener.onViewClick(getLayoutPosition());
                    break;*/
            }
        }

        @SuppressLint("SetTextI18n")
        public void setBinding(Object object) {
            if (binding instanceof ItemPincodeBinding) {

                PostOffice postOffice = (PostOffice) object;

                ((ItemPincodeBinding) binding).setData(postOffice);

                ((ItemPincodeBinding) binding).tvSrNOValue.setText("#" + (getLayoutPosition() + 1) + ".");

            }
        }
    }
}
