package com.example.jordan.societhy_android.Adapter;

/**
 * Created by aureliengiudici on 22/02/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Models.OrganisationModel;
import java.util.List;


public class OrganisationUserListAdapter extends ArrayAdapter<OrganisationModel> {
    private static LayoutInflater mInflater = null;
    private static List<OrganisationModel> objs;
    private Context context;
    private Activity activity;

    public OrganisationUserListAdapter(Context context, int layout, List<OrganisationModel> objects, Activity activity) {
        super(context, layout, objects);
        this.context = context;
        objs = objects;
        this.activity = activity;
        if (context != null)
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final OrganisationModel current = objs.get(position);
        if (convertView == null && mInflater != null) {
            convertView = mInflater.inflate(R.layout.row_organisation_user, parent, false);
        }
        TextView tvDate = (TextView) convertView.findViewById(R.id.tv_user_name);
        tvDate.setText(current.getName());



        RelativeLayout fullRow = (RelativeLayout) convertView.findViewById(R.id.full_row);
        fullRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Click sur une Orga
            }
        });
        return convertView;
    }
}