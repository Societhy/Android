package com.example.jordan.societhy_android.Fragments;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Adapter.ActivityListAdapter;
import com.example.jordan.societhy_android.Adapter.RecyclerViewAdapter;
import com.example.jordan.societhy_android.Models.OrganisationModel;
import com.example.jordan.societhy_android.Models.UserActivityModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProjectProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProjectProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProjectProfileFragment extends Fragment {
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
    private LinearLayout tmp;
    private OnFragmentInteractionListener mListener;
    private LinearLayout li;

    public static UserProfileFragment newInstance(String param1, String param2) {
        UserProfileFragment fragment = new UserProfileFragment();
        return fragment;
    }

    public ProjectProfileFragment() {
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
        view = inflater.inflate(R.layout.activity_project_profile, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
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
                = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);

        rvProjectOrganisation.setLayoutManager(layoutManager);

        orgaAdapter = new RecyclerViewAdapter(svOrga);
        adapter = new ActivityListAdapter(getContext(), R.layout.row_activity, list);

        lvProjectProfile.setAdapter(adapter);
        rvProjectOrganisation.setAdapter(orgaAdapter);
        rvProjectOrganisation.setItemAnimator(new DefaultItemAnimator());
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

