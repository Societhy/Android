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

import java.util.List;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Adapter.NewsListAdapter;
import com.example.jordan.societhy_android.Adapter.OrganisationUserListAdapter;
import com.example.jordan.societhy_android.Models.NewsModel;
import com.example.jordan.societhy_android.Models.UserModelTmp;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OrganisationProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OrganisationProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrganisationProfileFragment extends Fragment {
    @Bind(R.id.iv_orga_profile)
    ImageView ivOrgaProfile;
    @Bind(R.id.tv_orga_profile)
    TextView tvOrgaProfile;
    @Bind(R.id.lv_orga_profile)
    ListView lvOrgaProfile;
    @Bind(R.id.sv_orga_user)
    ScrollView svOrgaUser;
    @Bind(R.id.tv_Description)
    TextView tvDescription;

    private View view;
    private NewsListAdapter newsAdapter;
    private OrganisationUserListAdapter userAdapter;
    private OnFragmentInteractionListener mListener;

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
        tvOrgaProfile.setText("Aurélien Giudici, 14/04/1995\nMaitre des Penis Sacrée sisi");
        tvOrgaProfile.setTextSize(14);
        tvOrgaProfile.setTextColor(Color.GRAY);
        tvDescription.setText("Einstein présente un parcours scolaire relativement atypique par rapport aux éminents scientifiques qui furent plus tard ses contemporains. Très tôt, le jeune homme s'insurge du pouvoir arbitraire exercé par les enseignants, et est donc souvent dépeint comme un mauvais élément très étourdi par ces derniers. Il éprouve jusque tard dans son enfance des difficultés pour s'exprimer");
        tvDescription.setTextSize(10);
        tvOrgaProfile.setTextColor(Color.GRAY);
        List<NewsModel> list = new ArrayList<NewsModel>();
        list.add(new NewsModel("orga" , "14/02/2016", "Whesh les biatchs ça beigne"));
        list.add(new NewsModel("orga" , "14/02/2016", "Je suis un grand garçon, je plus pipi sur le pot"));
        list.add(new NewsModel("orga" , "14/02/2016", "OKKKKLM"));


        List<UserModelTmp> svOrga = new ArrayList<UserModelTmp>();
        svOrga.add(new UserModelTmp("Toto"));
        svOrga.add(new UserModelTmp("Jojo"));
        svOrga.add(new UserModelTmp("Tetraa"));


        userAdapter = new OrganisationUserListAdapter(getContext(), R.layout.row_user_organisation, svOrga, this.getActivity());
        newsAdapter = new NewsListAdapter(getContext(), R.layout.row_news, list, this.getActivity());
        lvOrgaProfile.setAdapter(newsAdapter);
        //tmp.addView(orgaAdapter.getView(0, null, null));

        svOrgaUser.addView(userAdapter.getView(1, null, null));
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
