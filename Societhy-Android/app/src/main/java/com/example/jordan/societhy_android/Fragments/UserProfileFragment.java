package com.example.jordan.societhy_android.Fragments;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Adapter.ActivityListAdapter;
import com.example.jordan.societhy_android.Adapter.RecyclerViewAdapter;
import com.example.jordan.societhy_android.Adapter.UserOrganisationListAdapter;
import com.example.jordan.societhy_android.Constants;
import com.example.jordan.societhy_android.Models.OrganisationModel;
import com.example.jordan.societhy_android.Models.UserActivityModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
    @Bind(R.id.tv_Description)
    TextView tvDescription;
    @Bind(R.id.rv_user_organisation)
    RecyclerView rvUserOrganisation;

    private View view;
    private ActivityListAdapter adapter;
    private RecyclerViewAdapter orgaAdapter;
    private LinearLayout tmp;
    private OnFragmentInteractionListener mListener;
    private LinearLayout li;
    private List<OrganisationModel> svOrga;

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
        tvUserProfile.setText("Aurélien Giudici, 14/04/1995");
        tvUserProfile.setTextSize(14);
        tvUserProfile.setTextColor(Color.GRAY);
        tvDescription.setText("Einstein présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme s'insurge du pouvoir arbitraire exercé par les enseignants, et est donc souvent dépeint comme un mauvais élément très étourdi par ces derniers. Il éprouve jusque tard dans son enfance des difficultés pour s'exprimer" +
                "Einstein présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme s'insurge du pouvoir arbitraire exercé par les enseignants, et est donc souvent dépeint comme un mauvais élément très étourdi par ces derniers. Il éprouve jusque tard dans son enfance des difficultés pour s'exprimer" +
                "Einstein présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme s'insurge du pouvoir arbitraire exercé par les enseignants, et est donc souvent dépeint comme un mauvais élément très étourdi par ces derniers. Il éprouve jusque tard dans son enfance des difficultés pour s'exprimer");
        tvDescription.setTextSize(10);
        tvUserProfile.setTextColor(Color.GRAY);

        List<UserActivityModel> list = new ArrayList<UserActivityModel>();
        svOrga = new ArrayList<OrganisationModel>();
        /*
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

    /*
        svOrga.add(new OrganisationModel("Java", "12/03/1994"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994"));svOrga.add(new OrganisationModel("Java", "12/03/1994"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994"));svOrga.add(new OrganisationModel("Java", "12/03/1994"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994"));svOrga.add(new OrganisationModel("Java", "12/03/1994"));
        svOrga.add(new OrganisationModel("FromSoft", "12/03/1994"));
        svOrga.add(new OrganisationModel("CDProject", "12/03/1994"));
      */

        String url = Constants.API_URL + "orga/";
        String tmp;
        for (int n = 0; n != Constants.ORGA.length; ++n) {
            tmp = url + Constants.ORGA[n];
            // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, tmp,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.v("onResponse", "response : " + response);
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String name = jsonObject.getString("name");
                                String addr = jsonObject.getString("address");
                                svOrga.add(new OrganisationModel(name, "12/03/1994", addr));
                                orgaAdapter.notifyDataSetChanged();

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

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);

        rvUserOrganisation.setLayoutManager(layoutManager);

        orgaAdapter = new RecyclerViewAdapter(svOrga);
        adapter = new ActivityListAdapter(getContext(), R.layout.row_activity, list);

        lvUserProfile.setAdapter(adapter);
        rvUserOrganisation.setAdapter(orgaAdapter);
        rvUserOrganisation.setItemAnimator(new DefaultItemAnimator());
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

