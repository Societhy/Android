package com.example.jordan.societhy_android.Fragments;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Adapter.ActivityListAdapter;
import com.example.jordan.societhy_android.Models.UserActivityModel;

import java.util.List;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by aureliengiudici on 18/02/2016.
 */
public class UserProfileFragment extends Fragment {
    @Bind(R.id.iv_user_profile)
    ImageView ivUserProfile;
    @Bind(R.id.tv_user_profile)
    TextView tvUserProfile;
    @Bind(R.id.lv_user_profile)
    ListView lvUserProfile;
    @Bind(R.id.sv_user_orga)
    ScrollView svUserOrga;

    private View view;
    private ActivityListAdapter adapter;

    private OnFragmentInteractionListener mListener;


    public static UserProfileFragment newInstance(String param1, String param2) {
        UserProfileFragment fragment = new UserProfileFragment();
        return fragment;
    }

    public UserProfileFragment() {
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
        view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        tvUserProfile.setText("Aurélien Giudici, 14/04/1995 12 passage carnot J'aime les pattates et les pommes");
        tvUserProfile.setTextSize(14);
        tvUserProfile.setTextColor(Color.BLACK);
        List<UserActivityModel> list = new ArrayList<UserActivityModel>();
        list.add(new UserActivityModel("14/02/2016", "Whesh les biatchs ça beigne"));
        list.add(new UserActivityModel("14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new UserActivityModel("14/02/2016", "OKKKKLM"));

        adapter = new ActivityListAdapter(getContext(), R.layout.row_activity, list, this.getActivity());
        lvUserProfile.setAdapter(adapter);
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

