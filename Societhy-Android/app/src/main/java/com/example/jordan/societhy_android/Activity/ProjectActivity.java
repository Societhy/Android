package com.example.jordan.societhy_android.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.jordan.societhy_android.Adapter.ActivityListAdapter;
import com.example.jordan.societhy_android.Adapter.RecyclerViewAdapter;
import com.example.jordan.societhy_android.Adapter.VoteListAdapter;
import com.example.jordan.societhy_android.Constants;
import com.example.jordan.societhy_android.Models.OrganisationModel;
import com.example.jordan.societhy_android.Models.ProjectModel;
import com.example.jordan.societhy_android.Models.UserActivityModel;
import com.example.jordan.societhy_android.Models.VoteModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProjectActivity extends AppCompatActivity {

    @Bind(R.id.iv_project_profile)
    ImageView ivProjectProfile;
    @Bind(R.id.tv_project_name)
    TextView tvProjectName;
    @Bind(R.id.tv_project_description)
    TextView tvDescription;
    @Bind(R.id.btn_news)
    Button btnNews;
    @Bind(R.id.btn_vote)
    Button btnVote;
    @Bind(R.id.btn_fundraising)
    Button btnFundraising;
    @Bind(R.id.fl_project_info)
    FrameLayout flProjectInfo;
    @Bind(R.id.rv_last_donation)
    RecyclerView rvLastDonation;

    private ActivityListAdapter adapter;
    private RecyclerViewAdapter orgaAdapter;
    private VoteListAdapter voteListAdapter;
    private String projectName;
    private ListView lvProjectNews;
    private int NEWS_PAGE_SELECTED = 1;
    private int VOTE_PAGE_SELECTED = 2;
    private int FOUNDRAISING_PAGE_SELECTED = 3;
    private LayoutInflater inflater;
    private List<VoteModel> voteList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_profile);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        initViews();
        if (bd != null) {
            projectName = (String) bd.get(Constants.PROJECT_NAME);
            tvProjectName.setText(projectName);
        }
        initMembers();
    }

    private void initViews() {
        tvDescription.setText("Super content, c'est trop bien");
        tvDescription.setTextSize(10);
        List<UserActivityModel> list = new ArrayList<UserActivityModel>();
        list.add(new UserActivityModel("14/02/2016", "This project is begin"));
        list.add(new UserActivityModel("14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new UserActivityModel("14/02/2016", "OKKKKLM"));
        list.add(new UserActivityModel("14/02/2016", "Whesh les biatchs ça beigne"));
        list.add(new UserActivityModel("14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new UserActivityModel("14/02/2016", "OKKKKLM"));
        list.add(new UserActivityModel("14/02/2016", "Whesh les biatchs ça beigne"));
        list.add(new UserActivityModel("14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new UserActivityModel("14/02/2016", "OKKKKLM"));
        list.add(new UserActivityModel("14/02/2016", "Whesh les biatchs ça beigne"));
        list.add(new UserActivityModel("14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new UserActivityModel("14/02/2016", "OKKKKLM"));
        list.add(new UserActivityModel("14/02/2016", "Whesh les biatchs ça beigne"));
        list.add(new UserActivityModel("14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new UserActivityModel("14/02/2016", "OKKKKLM"));
        list.add(new UserActivityModel("14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new UserActivityModel("14/02/2016", "OKKKKLM"));


        List<OrganisationModel> svOrga = new ArrayList<OrganisationModel>();

        svOrga.add(new OrganisationModel("Jean jaques", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("Java", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("Java", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("Java", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994", "aa"));

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rvLastDonation.setLayoutManager(layoutManager);

        orgaAdapter = new RecyclerViewAdapter(svOrga);
        adapter = new ActivityListAdapter(this, R.layout.row_activity, list);

        //lvProjectProfile.setAdapter(adapter);
        rvLastDonation.setAdapter(orgaAdapter);
        rvLastDonation.setItemAnimator(new DefaultItemAnimator());

        inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //flProjectInfo = inflater.inflate(R.layout.news_project_pager, null);
        updateViews(NEWS_PAGE_SELECTED);
    }

    private void initMembers() {
        /*stub.setLayoutResource(R.layout.whatever_layout_you_want);
        View inflated = stub.inflate();*/
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateViews(NEWS_PAGE_SELECTED);
            }
        });
        btnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("bntVoteClick", "s");
                updateViews(VOTE_PAGE_SELECTED);
            }
        });
        btnFundraising.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateViews(FOUNDRAISING_PAGE_SELECTED);
            }
        });
    }

    private void updateViews(int pager) {
        if (pager == NEWS_PAGE_SELECTED /* && current != */) {
            Log.v("in news page", "s");
            btnNews.setBackgroundResource(R.drawable.dashboard_button_selected_shape);
            btnVote.setBackgroundResource(R.drawable.dashboard_button_unselected_shape);
            btnFundraising.setBackgroundResource(R.drawable.dashboard_button_unselected_shape);
            //flProjectInfo = inflater.inflate(R.layout.news_project_pager, null);
            flProjectInfo.removeAllViews();
            flProjectInfo.addView(View.inflate(this, R.layout.news_project_pager, null));
            initNewsPage();
        } else if (pager == VOTE_PAGE_SELECTED) {
            Log.v("in vote page", "s");
            btnNews.setBackgroundResource(R.drawable.dashboard_button_unselected_shape);
            btnVote.setBackgroundResource(R.drawable.dashboard_button_selected_shape);
            btnFundraising.setBackgroundResource(R.drawable.dashboard_button_unselected_shape);
            flProjectInfo.removeAllViews();
            flProjectInfo.addView(View.inflate(this, R.layout.vote_project_pager, null));
            initVotePage();
        } else {
            Log.v("in fundraise page", "s");
            btnNews.setBackgroundResource(R.drawable.dashboard_button_unselected_shape);
            btnVote.setBackgroundResource(R.drawable.dashboard_button_unselected_shape);
            btnFundraising.setBackgroundResource(R.drawable.dashboard_button_selected_shape);
            flProjectInfo.removeAllViews();
            flProjectInfo.addView(View.inflate(this, R.layout.fundraise_project_pager, null));
        }
    }

    private void initNewsPage() {
        Log.v("in initnewspage", "s");
        ListView lv = (ListView) flProjectInfo.findViewById(R.id.lv_project_news);
        lv.setAdapter(adapter);
    }

    private void initVotePage() {
        Log.v("in initvotepage", "s");
        voteList = new ArrayList<VoteModel>();

        /*
        voteList.add(new VoteModel(15, 10, "proposition proposition proposition proposition proposition proposition proposition  proposition"));
        voteList.add(new VoteModel(25, 50, "proposition proposition proposition proposition proposition proposition proposition proposition proposition proposition proposition proposition"));
        voteList.add(new VoteModel(15, 700, "proposition proposition proposition proposition proposition proposition proposition proposition proposition proposition"));
        voteList.add(new VoteModel(805, 10, "proposition proposition proposition proposition proposition proposition proposition proposition proposition proposition proposition proposition"));
        voteList.add(new VoteModel(15, 10, "proposition proposition proposition proposition proposition "));
        voteList.add(new VoteModel(120, 10, "proposition proposition proposition proposition proposition proposition proposition proposition proposition proposition proposition proposition"));
        voteList.add(new VoteModel(15, 10, "proposition proposition proposition proposition proposition proposition proposition proposition "));
        */

        String url;
        StringRequest stringRequest;
        url = Constants.API_URL + "project/" + Constants.lastKey;
            stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.v("onResponse", "response : " + response);
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                JSONArray jsonArray = jsonObject.getJSONArray("proposalList");
                                for (int n = 0; n != jsonArray.length(); ++n)
                                {
                                    voteList.add(new VoteModel(jsonArray.getJSONObject(n).getInt("voteFor"),
                                            jsonArray.getJSONObject(n).getInt("voteAgainst"),
                                            jsonArray.getJSONObject(n).getString("name"),
                                            jsonArray.getJSONObject(n).getDouble("amount"),
                                            jsonArray.getJSONObject(n).getString("description")));
                                    //int likes, int dislikes, String name, double amount, String description
                                }
                                ((BaseAdapter)voteListAdapter).notifyDataSetChanged();
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

        voteListAdapter = new VoteListAdapter(this, R.layout.row_project_vote, voteList);
        ListView lv = (ListView) flProjectInfo.findViewById(R.id.lv_project_vote);
        lv.setAdapter(voteListAdapter);
    }
}
