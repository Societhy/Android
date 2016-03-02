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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.jordan.societhy_android.Adapter.ActivityListAdapter;
import com.example.jordan.societhy_android.Adapter.ProjectListAdapter;
import com.example.jordan.societhy_android.Adapter.RecyclerViewAdapter;
import com.example.jordan.societhy_android.Constants;
import com.example.jordan.societhy_android.Models.OrganisationModel;
import com.example.jordan.societhy_android.Models.ProjectModel;
import com.example.jordan.societhy_android.Models.UserActivityModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    private List<ProjectModel> projects;
    private String[] projectKeys;

    private String organisationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organisation_profile);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        initViews();
        if (bd != null) {
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

        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "a"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "a"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "a"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "a"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994", "a"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "a"));
        svOrga.add(new OrganisationModel("Java", "12/03/1994", "a"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "a"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994", "a"));
        svOrga.add(new OrganisationModel("Java", "12/03/1994", "a"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "a"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994", "a"));

        projects = new ArrayList<ProjectModel>();
        String url = Constants.API_URL + "orga/";
        url += Constants.lastKey;
        Log.v("url : ", "url : " + url);
// Request a string response from the provided URL.
        Log.v("AttemptLogin", "before StringRequestQueue instanciation");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("onResponse", "response : " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray array = jsonObject.getJSONArray("projects");
                            projectKeys = new String[array.length()];
                            for (int n = 0; n < array.length(); n++) {
                                projectKeys[n] = array.getString(n);
                                Log.v("test", array.getString(n));
                            }
                            getProject();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("onError", "error : " + error);
            }
        });
        Constants.queue.add(stringRequest);


        LinearLayoutManager memberlayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rvOrganisationMembers.setLayoutManager(memberlayoutManager);

        orgaAdapter = new RecyclerViewAdapter(svOrga);
        activityAdapter = new ActivityListAdapter(this, R.layout.row_activity, list);

        lvOrgaProfile.setAdapter(activityAdapter);
        rvOrganisationMembers.setAdapter(orgaAdapter);

        rvOrganisationMembers.setItemAnimator(new DefaultItemAnimator());
        //tmp.addView(orgaAdapter.getView(0, null, null));

        //svOrgaUser.addView(userAdapter.getView(1, null, null));
    }

    private void getProject() {

        String url;
        StringRequest stringRequest;
        url = Constants.API_URL + "project/";
        String tmp;
        for (int n = 0; n != projectKeys.length; ++n) {
            tmp = url + projectKeys[n];
            stringRequest = new StringRequest(Request.Method.GET, tmp,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.v("onResponse", "response : " + response);
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String test = jsonObject.getString("name");
                                projects.add(new ProjectModel(test, jsonObject.getString("address")));
                                ((BaseAdapter)lvProjects.getAdapter()).notifyDataSetChanged();
                                Log.v("Name project :", test);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.v("onError", "error : " + error);
                }
            });
            Constants.queue.add(stringRequest);
        }
        projectAdapter = new ProjectListAdapter(getBaseContext(), R.layout.row_organisation_project, projects);
        Log.v("avant", "avant");
        lvProjects.setAdapter(projectAdapter);
        Log.v("apr", "apr");
    }
}
