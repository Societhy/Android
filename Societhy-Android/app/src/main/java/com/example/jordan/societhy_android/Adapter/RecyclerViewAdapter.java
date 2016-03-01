package com.example.jordan.societhy_android.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jordan.societhy_android.Activity.OrganisationProfileActivity;
import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Constants;
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
        public LinearLayout fullRow;
        private Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            image = (ImageView) itemView.findViewById(R.id.iv_row_orga_picture);
            text = (TextView) itemView.findViewById(R.id.tv_row_orga_name);
            fullRow = (LinearLayout) itemView.findViewById(R.id.full_row);
            fullRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, OrganisationProfileActivity.class);
                    intent.putExtra(Constants.ORGANISATION_NAME, text.getText());
                    context.startActivity(intent);
                }
            });
        }
    }
}