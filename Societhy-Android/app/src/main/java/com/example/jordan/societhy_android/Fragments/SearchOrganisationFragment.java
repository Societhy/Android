package com.example.jordan.societhy_android.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Adapter.OrganisationListAdapter;
import com.example.jordan.societhy_android.Constants;
import com.example.jordan.societhy_android.Models.Organisation;
import com.example.jordan.societhy_android.Models.OrganisationModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SearchOrganisationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchOrganisationFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<Organisation> organisations;
    @Bind(R.id.lv_organisations)
    ListView lvOrganisations;
    @Bind(R.id.nav_view_filter)
    NavigationView navViewFilter;
    @Bind(R.id.drawer_layout_filter)
    DrawerLayout drawerLayoutFilter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private OrganisationListAdapter adapter;
    private TextView tvFilterSearch;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchOrganisationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchOrganisationFragment newInstance(String param1, String param2) {
        SearchOrganisationFragment fragment = new SearchOrganisationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SearchOrganisationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_organisation, container, false);
        ButterKnife.bind(this, view);
        tvFilterSearch = (TextView) view.findViewById(R.id.tv_filter_search);
        initViews();
        initMembers();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    private void initViews() {
        organisations = new ArrayList<Organisation>();
        /*
        organisations.add(new Organisation("Organisation 1", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation 2", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation 3", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation 4", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation 5", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation 6", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation 7", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation1", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation1", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation1", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation1", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation1", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation1", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation1", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation1", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation1", "s,fzefze,fzelf,zef,zefzefzef"));organisations.add(new Organisation("Organisation1", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation1", "s,fzefze,fzelf,zef,zefzefzef"));
        organisations.add(new Organisation("Organisation1", "s,fzefze,fzelf,zef,zefzefzef"));
        */

        String url = Constants.API_URL + "orga/all";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("onResponse", "response : " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String str = jsonObject.getString("name");
                            organisations.add(new Organisation(jsonObject.getString("name"), jsonObject.getString("address")));

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



        adapter = new OrganisationListAdapter(getContext(), R.layout.row_news, organisations, this.getActivity());
        lvOrganisations.setAdapter(adapter);

    }

    private void initMembers() {
        tvFilterSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayoutFilter.closeDrawers();
            }
        });
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
