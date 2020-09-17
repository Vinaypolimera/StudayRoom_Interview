package com.poli.studayroominterview.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.poli.studayroominterview.R;
import com.poli.studayroominterview.beans.ItemObject;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.RecyclerViewHolder> {

    List<ItemObject> mItemsArray;
    private Context mContext;

    public ListAdapter(Context context, List<ItemObject> arrayList) {
        mContext = context;
        mItemsArray = arrayList;
    }

    public void updateList(List<ItemObject> itemsArrayList) {
        mItemsArray = itemsArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.list_item, parent, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.RecyclerViewHolder viewHolder, int position) {
        ItemObject itemObject = mItemsArray.get(position);

        if(itemObject != null)
        {
            Glide.with(mContext).load(itemObject.getOwnerProfileImage()).placeholder(R.drawable.ic_user_profile).into(viewHolder.mProfileImage);
            viewHolder.mTitle.setText(itemObject.getTitle());
            viewHolder.mTags.setText(itemObject.getTagstoStrings());
        }
    }

    @Override
    public int getItemCount() {
        return mItemsArray.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView mProfileImage;
        TextView mTags;
        TextView mTitle;

        public RecyclerViewHolder(View view) {
            super(view);

            mProfileImage = view.findViewById(R.id.profile_image);
            mTitle = view.findViewById(R.id.title);
            mTags = view.findViewById(R.id.tags);
        }
    }
}
