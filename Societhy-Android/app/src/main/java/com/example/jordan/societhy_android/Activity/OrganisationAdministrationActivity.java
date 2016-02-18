package com.example.jordan.societhy_android.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OrganisationAdministrationActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_organisation_name)
    TextView tvOrganisationName;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organisation_administration);
        ButterKnife.bind(this);

        initViews();

        Bundle extras = getIntent().getExtras();
        String userName;

        userName = extras.getString("name");

        tvOrganisationName.setText(userName);
        setSupportActionBar(toolbar);
    }

    private void initViews() {
        //toolbar.setLogo(R.drawable.office_list);
    }
}
