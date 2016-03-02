package com.example.jordan.societhy_android.Adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Models.NewsModel;
import com.example.jordan.societhy_android.Models.VoteModel;

import java.util.List;

/**
 * Created by jordan on 01/03/2016.
 */
public class VoteListAdapter extends ArrayAdapter<VoteModel> {
    private static LayoutInflater mInflater = null;
    private static List<VoteModel> objs;
    private Context context;
//private View view;

    public VoteListAdapter(Context context, int layout, List<VoteModel> objects) {
        super(context, layout, objects);
        Log.v("in Adapter", "in adapter begin");
        this.context = context;
        objs = objects;
        if (context != null)
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final VoteModel current = objs.get(position);
        if (convertView == null && mInflater != null) {
            convertView = mInflater.inflate(R.layout.row_project_vote, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_vote_description);
        tvName.setText("Name : " + current.getName() + " Description " + current.getDescription() + " Amount : " + current.getAmount());

        TextView tvLikes = (TextView) convertView.findViewById(R.id.tv_like_number);
        tvLikes.setText("" + current.getLikes());

        TextView tvDislikes = (TextView) convertView.findViewById(R.id.tv_dislike_number);
        tvDislikes.setText("" + current.getDislikes());

        RelativeLayout fullRow = (RelativeLayout) convertView.findViewById(R.id.full_row);
        fullRow.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //TODO Click sur un vote
            }
        });
        return convertView;
    }
}