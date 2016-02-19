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
import com.example.jordan.societhy_android.Models.UserActivityModel;

import java.util.List;

/**
 * Created by aureliengiudici on 18/02/2016.
 */
public class ActivityListAdapter extends ArrayAdapter<UserActivityModel> {
    private static LayoutInflater mInflater = null;
    private static List<UserActivityModel> objs;
    private Context context;
    private Activity activity;

    public ActivityListAdapter(Context context, int layout, List<UserActivityModel> objects, Activity activity) {
        super(context, layout, objects);
        this.context = context;
        objs = objects;
        this.activity = activity;
        if (context != null)
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final UserActivityModel current = objs.get(position);
        if (convertView == null && mInflater != null) {
            convertView = mInflater.inflate(R.layout.row_activity, parent, false);
        }
        TextView tvDate = (TextView) convertView.findViewById(R.id.tv_date);
        tvDate.setText(current.getDate());
        TextView tvContent = (TextView) convertView.findViewById(R.id.tv_activityContent);
        tvContent.setText(current.getActivityContent());


        RelativeLayout fullRow = (RelativeLayout) convertView.findViewById(R.id.full_row);
        fullRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Click sur une NEWS
            }
        });
        return convertView;
    }
}
