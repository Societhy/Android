package com.example.jordan.societhy_android.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OrganisationAdministrationActivity extends AppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.iv_orga_picture)
    ImageView ivOrgaPicture;
    @Bind(R.id.tv_organisation_name)
    TextView tvOrganisationName;
    private TextView organisationName;
    //private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organisation_profile);
        ButterKnife.bind(this);

        initViews();

        Bundle extras = getIntent().getExtras();
        String userName;

        userName = extras.getString("name");

        //toolbar = (Toolbar) findViewById(R.id.toolbar);

        organisationName = (TextView) findViewById(R.id.tv_organisation_name);
        organisationName.setText("Admin" + userName);
        TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        /*tvOrganisationName.setText(userName);*/
        setSupportActionBar(toolbar);
    }

    private void initViews() {
        //toolbar.setLogo(R.drawable.office_list);
    }
}
