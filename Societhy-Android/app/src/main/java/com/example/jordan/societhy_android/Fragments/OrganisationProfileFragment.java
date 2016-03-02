package com.example.jordan.societhy_android.Fragments;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Adapter.ActivityListAdapter;
import com.example.jordan.societhy_android.Adapter.NewsListAdapter;
import com.example.jordan.societhy_android.Adapter.OrganisationUserListAdapter;
import com.example.jordan.societhy_android.Adapter.ProjectListAdapter;
import com.example.jordan.societhy_android.Adapter.RecyclerViewAdapter;
import com.example.jordan.societhy_android.Models.OrganisationModel;
import com.example.jordan.societhy_android.Models.ProjectModel;
import com.example.jordan.societhy_android.Models.UserActivityModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OrganisationProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrganisationProfileFragment extends Fragment {
    @Bind(R.id.iv_orga_profile)
    ImageView ivOrgaProfile;
    @Bind(R.id.tv_orga_name)
    TextView tvOrgaProfile;
    @Bind(R.id.lv_orga_profile)
    ListView lvOrgaProfile;
    @Bind(R.id.tv_Description)
    TextView tvDescription;
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

    private View view;
    private NewsListAdapter newsAdapter;
    private OrganisationUserListAdapter userAdapter;
    private OnFragmentInteractionListener mListener;
    private ActivityListAdapter activityAdapter;
    private RecyclerViewAdapter orgaAdapter;
    private ProjectListAdapter projectAdapter;

    public static OrganisationProfileFragment newInstance(String param1, String param2) {
        OrganisationProfileFragment fragment = new OrganisationProfileFragment();
        return fragment;
    }

    public OrganisationProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_organisation_profile, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        tvOrgaProfile.setText("Jean Michel Truelle Corp");
        tvOrgaProfile.setTextSize(14);
        tvOrgaProfile.setTextColor(Color.GRAY);
        tvDescription.setText("Jean Michel Truelle présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme s'insurge du pouvoir arbitraire exercé par les enseignants, et est donc souvent dépeint comme un mauvais élément très étourdi par ces derniers. Il éprouve jusque tard dans son enfance des difficultés pour s'exprimer" +
                "Jean Michel Truelle présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme " +
                "Jean Michel Truelle présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme " +
                "Jean Michel Truelle présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme" +
                "Jean Michel Truelle présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme ");
        tvDescription.setTextSize(10);
        tvOrgaProfile.setTextColor(Color.GRAY);
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

        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("Java", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("Java", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("JeanMich", "12/03/1994", "aa"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994", "aa"));

        List<ProjectModel> projects = new ArrayList<ProjectModel>();
        /*
        projects.add(new ProjectModel("Uncharted 4"));
        projects.add(new ProjectModel("Uncharted 5"));
        projects.add(new ProjectModel("BloodBorne"));
        projects.add(new ProjectModel("BloodBorne 2"));
    */
        LinearLayoutManager memberlayoutManager
                = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);

        rvOrganisationMembers.setLayoutManager(memberlayoutManager);

        orgaAdapter = new RecyclerViewAdapter(svOrga);
        activityAdapter = new ActivityListAdapter(getContext(), R.layout.row_activity, list);
        projectAdapter = new ProjectListAdapter(getContext(), R.layout.row_organisation_project, projects);

        lvOrgaProfile.setAdapter(activityAdapter);
        rvOrganisationMembers.setAdapter(orgaAdapter);
        lvProjects.setAdapter(projectAdapter);

        rvOrganisationMembers.setItemAnimator(new DefaultItemAnimator());
        //tmp.addView(orgaAdapter.getView(0, null, null));

        //svOrgaUser.addView(userAdapter.getView(1, null, null));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
}
