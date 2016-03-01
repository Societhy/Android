package com.example.jordan.societhy_android.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jordan.societhy_android.Adapter.ActivityListAdapter;
import com.example.jordan.societhy_android.Adapter.RecyclerViewAdapter;
import com.example.jordan.societhy_android.Models.OrganisationModel;
import com.example.jordan.societhy_android.Models.UserActivityModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProjectActivity extends AppCompatActivity {

    @Bind(R.id.iv_project_profile)
    ImageView ivProjectProfile;
    @Bind(R.id.tv_project_profile)
    TextView tvProjectProfile;
    @Bind(R.id.lv_project_profile)
    ListView lvProjectProfile;
    @Bind(R.id.tv_project_description)
    TextView tvDescription;
    @Bind(R.id.rv_project_user)
    RecyclerView rvProjectOrganisation;

    private View view;
    private ActivityListAdapter adapter;
    private RecyclerViewAdapter orgaAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_profile);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        tvProjectProfile.setText("Project POPOP, 14/04/1995\nUn projet cool et plein de vie");
        tvProjectProfile.setTextSize(14);
        tvProjectProfile.setTextColor(Color.GRAY);
        tvDescription.setText("Super content, c'est trop bien");
        tvDescription.setTextSize(10);
        tvProjectProfile.setTextColor(Color.GRAY);
        List<UserActivityModel> list = new ArrayList<UserActivityModel>();
        list.add(new UserActivityModel("14/02/2016", "This project is begin"));
        list.add(new UserActivityModel("14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new UserActivityModel("14/02/2016", "OKKKKLM"));
        list.add(new UserActivityModel("14/02/2016", "Whesh les biatchs ça beigne"));
        list.add(new UserActivityModel("14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new UserActivityModel("14/02/2016", "OKKKKLM"));list.add(new UserActivityModel("14/02/2016", "Whesh les biatchs ça beigne"));
        list.add(new UserActivityModel("14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new UserActivityModel("14/02/2016", "OKKKKLM"));list.add(new UserActivityModel("14/02/2016", "Whesh les biatchs ça beigne"));
        list.add(new UserActivityModel("14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new UserActivityModel("14/02/2016", "OKKKKLM"));list.add(new UserActivityModel("14/02/2016", "Whesh les biatchs ça beigne"));
        list.add(new UserActivityModel("14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new UserActivityModel("14/02/2016", "OKKKKLM"));
        list.add(new UserActivityModel("14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new UserActivityModel("14/02/2016", "OKKKKLM"));



        List<OrganisationModel> svOrga = new ArrayList<OrganisationModel>();

        svOrga.add(new OrganisationModel("Java", "12/03/1994"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994"));svOrga.add(new OrganisationModel("Java", "12/03/1994"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994"));svOrga.add(new OrganisationModel("Java", "12/03/1994"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994"));svOrga.add(new OrganisationModel("Java", "12/03/1994"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994"));

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rvProjectOrganisation.setLayoutManager(layoutManager);

        orgaAdapter = new RecyclerViewAdapter(svOrga);
        adapter = new ActivityListAdapter(this, R.layout.row_activity, list);

        lvProjectProfile.setAdapter(adapter);
        rvProjectOrganisation.setAdapter(orgaAdapter);
        rvProjectOrganisation.setItemAnimator(new DefaultItemAnimator());
    }
}
