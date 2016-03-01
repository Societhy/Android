package com.example.jordan.societhy_android.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jordan.societhy_android.Adapter.ActivityListAdapter;
import com.example.jordan.societhy_android.Adapter.ProjectListAdapter;
import com.example.jordan.societhy_android.Adapter.RecyclerViewAdapter;
import com.example.jordan.societhy_android.Constants;
import com.example.jordan.societhy_android.Models.OrganisationModel;
import com.example.jordan.societhy_android.Models.ProjectModel;
import com.example.jordan.societhy_android.Models.UserActivityModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OrganisationProfileActivity extends AppCompatActivity {

    @Bind(R.id.iv_orga_profile)
    ImageView ivOrgaProfile;
    @Bind(R.id.tv_orga_name)
    TextView tvOrgaName;
    @Bind(R.id.tv_Description)
    TextView tvDescription;
    @Bind(R.id.lv_orga_profile)
    ListView lvOrgaProfile;
    @Bind(R.id.rv_organisation_members)
    RecyclerView rvOrganisationMembers;
    @Bind(R.id.tv_organisation_projects)
    TextView tvOrganisationProjects;
    @Bind(R.id.lv_projects)
    ListView lvProjects;
    @Bind(R.id.nav_view_filter)
    NavigationView navViewFilter;
    @Bind(R.id.drawer_layout_filter)
    DrawerLayout drawerLayoutFilter;

    private ActivityListAdapter activityAdapter;
    private RecyclerViewAdapter orgaAdapter;
    private ProjectListAdapter projectAdapter;

    private String organisationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organisation_profile);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        initViews();
        if(bd != null)
        {
            organisationName = (String) bd.get(Constants.ORGANISATION_NAME);
            Log.v("orgaName :", "" + organisationName);
            tvOrgaName.setText(organisationName);
        }
    }

    private void initViews() {
        tvDescription.setText("Jean Michel Truelle présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme s'insurge du pouvoir arbitraire exercé par les enseignants, et est donc souvent dépeint comme un mauvais élément très étourdi par ces derniers. Il éprouve jusque tard dans son enfance des difficultés pour s'exprimer" +
                "Jean Michel Truelle présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme " +
                "Jean Michel Truelle présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme " +
                "Jean Michel Truelle présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme" +
                "Jean Michel Truelle présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme ");
        tvDescription.setTextSize(10);
        List<UserActivityModel> list = new ArrayList<UserActivityModel>();
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content vActivity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content Activity Content"));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));
        list.add(new UserActivityModel("14/02/2016", "Activity Content Activity Content "));


        List<OrganisationModel> svOrga = new ArrayList<OrganisationModel>();

        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994"));
        svOrga.add(new OrganisationModel("Java", "12/03/1994"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994"));
        svOrga.add(new OrganisationModel("Java", "12/03/1994"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994"));

        List<ProjectModel> projects = new ArrayList<ProjectModel>();
        projects.add(new ProjectModel("Uncharted 4"));
        projects.add(new ProjectModel("Uncharted 5"));
        projects.add(new ProjectModel("BloodBorne"));
        projects.add(new ProjectModel("BloodBorne 2"));

        LinearLayoutManager memberlayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rvOrganisationMembers.setLayoutManager(memberlayoutManager);

        orgaAdapter = new RecyclerViewAdapter(svOrga);
        activityAdapter = new ActivityListAdapter(this, R.layout.row_activity, list);
        projectAdapter = new ProjectListAdapter(this, R.layout.row_organisation_project, projects);

        lvOrgaProfile.setAdapter(activityAdapter);
        rvOrganisationMembers.setAdapter(orgaAdapter);
        lvProjects.setAdapter(projectAdapter);

        rvOrganisationMembers.setItemAnimator(new DefaultItemAnimator());
        //tmp.addView(orgaAdapter.getView(0, null, null));

        //svOrgaUser.addView(userAdapter.getView(1, null, null));
    }
}
