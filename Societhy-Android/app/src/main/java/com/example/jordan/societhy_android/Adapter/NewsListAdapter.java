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
import android.support.v7.app.WindowDecorActionBar;

import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Models.NewsModel;

import java.util.List;

/**
 * Created by jordan on 17/02/2016.
 */
public class NewsListAdapter extends ArrayAdapter<NewsModel> {
private static LayoutInflater mInflater = null;
private static List<NewsModel> objs;
private Context context;
private Activity activity;
//private View view;

public NewsListAdapter(Context context, int layout, List<NewsModel> objects, Activity activity) {
            super(context, layout, objects);
            Log.v("in Adapter", "in adapter begin");
            this.context = context;
            objs = objects;
            this.activity = activity;
            if (context != null)
                mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            Log.v("in Adapter", "in adapter end");
        }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final NewsModel current = objs.get(position);
        Log.v("in Adapter", "in adapter getView");
        if (convertView == null && mInflater != null) {
            convertView = mInflater.inflate(R.layout.row_news, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name_orga);
        tvName.setText(current.getOrganizationName());
        Log.v("in adapter", "orga name = " + current.getOrganizationName());

        TextView tvDate = (TextView) convertView.findViewById(R.id.tv_date);
        tvDate.setText(current.getDate());

        TextView tvNote = (TextView) convertView.findViewById(R.id.tv_news);
        tvNote.setText(current.getNewsContent());

        RelativeLayout fullRow = (RelativeLayout) convertView.findViewById(R.id.full_row);
        fullRow.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //TODO Click sur une NEWS
            }
        });
        return convertView;
    }
}