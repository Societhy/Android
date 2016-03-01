package com.example.jordan.societhy_android.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jordan.societhy_android.Activity.HomeActivity;
import com.example.jordan.societhy_android.Activity.OrganisationProfileActivity;
import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Constants;
import com.example.jordan.societhy_android.Fragments.ProjectProfileFragment;
import com.example.jordan.societhy_android.Models.NewsModel;
import com.example.jordan.societhy_android.Models.Organisation;

import java.util.List;

/**
 * Created by jordan on 18/02/2016.
 */
public class OrganisationListAdapter extends ArrayAdapter<Organisation> {
    private static LayoutInflater mInflater = null;
    private static List<Organisation> objs;
    private Context context;
    private FragmentActivity activity;
    private TextView tvName;
//private View view;

    public OrganisationListAdapter(Context context, int layout, List<Organisation> objects, FragmentActivity activity) {
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
        final Organisation current = objs.get(position);
        Log.v("in Adapter", "in adapter getView");
        if (convertView == null && mInflater != null) {
            convertView = mInflater.inflate(R.layout.row_news, parent, false);
        }
        tvName = (TextView) convertView.findViewById(R.id.tv_name_orga);
        tvName.setText(current.getName());
        Log.v("in adapter", "orga name = " + current.getName());

        TextView tvNote = (TextView) convertView.findViewById(R.id.tv_news);
        tvNote.setText(current.getDescription());

        RelativeLayout fullRow = (RelativeLayout) convertView.findViewById(R.id.full_row);
        fullRow.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(context, OrganisationProfileActivity.class);
                intent.putExtra(Constants.ORGANISATION_NAME, current.getName());
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
