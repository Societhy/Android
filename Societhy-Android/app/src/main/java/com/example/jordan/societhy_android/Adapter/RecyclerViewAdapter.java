package com.example.jordan.societhy_android.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Models.OrganisationModel;

import java.util.List;

/**
 * Created by jordan on 23/02/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<OrganisationModel> items;

    public RecyclerViewAdapter(List<OrganisationModel> items) {
        this.items = items;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user_organisation, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        OrganisationModel item = items.get(position);
        holder.text.setText(item.getName());
        //holder.itemView.setTag(item);
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.iv_row_orga_picture);
            text = (TextView) itemView.findViewById(R.id.tv_row_orga_name);
        }
    }
}