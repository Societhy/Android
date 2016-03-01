package com.example.jordan.societhy_android.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jordan.societhy_android.Activity.HomeActivity;
import com.example.jordan.societhy_android.Activity.ProjectActivity;
import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Constants;
import com.example.jordan.societhy_android.Fragments.ProjectProfileFragment;
import com.example.jordan.societhy_android.Models.ProjectModel;

import java.util.List;

/**
 * Created by jordan on 29/02/2016.
 */
public class ProjectListAdapter extends ArrayAdapter<ProjectModel> {
    private static LayoutInflater mInflater = null;
    private static List<ProjectModel> objs;
    private Context context;
    private FragmentActivity activity;
//private View view;

    public ProjectListAdapter(Context context, int layout, List<ProjectModel> objects) {
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
        final ProjectModel current = objs.get(position);
        if (convertView == null && mInflater != null) {
            convertView = mInflater.inflate(R.layout.row_organisation_project, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_project_name);
        tvName.setText(current.getName());

        FrameLayout fullRow = (FrameLayout) convertView.findViewById(R.id.full_row);
        fullRow.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(context, ProjectActivity.class);
                intent.putExtra(Constants.PROJECT_NAME, current.getName());
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}