package com.example.jordan.societhy_android.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Adapter.NewsListAdapter;
import com.example.jordan.societhy_android.Models.NewsModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {
    @Bind(R.id.tv_news)
    TextView tvNews;
    @Bind(R.id.tv_news_orga)
    TextView tvNewsOrga;
    @Bind(R.id.lv_news)
    ListView lvNews;

    private View view;
    private ListView notificationList;
    private TextView logTime;
    private ImageView userPicture;
    private NewsListAdapter adapter;
    private int NEWS_PAGE_SELECTED = 1;
    private int NEWS_ORGA_PAGE_SELECTED = 2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DashboardFragment.
     */
    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        return fragment;
    }

    public DashboardFragment() {
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
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
        initViews();
        updateViews(NEWS_PAGE_SELECTED);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    public List<NewsModel> newsGenerator(int pager) {
        List<NewsModel> list = new ArrayList<NewsModel>();
        if (pager == NEWS_PAGE_SELECTED) {
            Log.v("newsGenerator", "init les listes : ");
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            Log.v("newsGenerator", "fin init listes.");
        } else {
            list.add(new NewsModel("CDProjekt", "newsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnews", "16/02/2016"));
            list.add(new NewsModel("CDProjekt", "newsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnews", "16/02/2016"));
            list.add(new NewsModel("CDProjekt", "newsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnews", "16/02/2016"));
            list.add(new NewsModel("CDProjekt", "newsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnews", "16/02/2016"));
            list.add(new NewsModel("CDProjekt", "newsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnews", "16/02/2016"));
            list.add(new NewsModel("CDProjekt", "newsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnews", "16/02/2016"));
            list.add(new NewsModel("CDProjekt", "newsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnews", "16/02/2016"));
        }
        return list;
    }
    private void initViews() {
        tvNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateViews(NEWS_PAGE_SELECTED);
            }
        });
        tvNewsOrga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateViews(NEWS_ORGA_PAGE_SELECTED);
            }
        });
        List<NewsModel> list = newsGenerator(NEWS_PAGE_SELECTED);
        Log.v("initViews", "listes : " + list.toString());
        adapter = new NewsListAdapter(getContext(), R.layout.row_news, list, this.getActivity());
        Log.v("initViews", "afterAdapter");
        lvNews.setAdapter(adapter);
    }

    private void updateViews(int pager) {
        if (pager == NEWS_PAGE_SELECTED) {
            tvNews.setBackgroundColor(getResources().getColor(R.color.greyDashBoardButtonHighlight));
            tvNewsOrga.setBackgroundColor(getResources().getColor(R.color.greyDashBoardButton));
            adapter = new NewsListAdapter(getContext(), R.layout.row_news, newsGenerator(NEWS_PAGE_SELECTED), this.getActivity());
            lvNews.setAdapter(adapter);
        } else {
            tvNewsOrga.setBackgroundColor(getResources().getColor(R.color.greyDashBoardButtonHighlight));
            tvNews.setBackgroundColor(getResources().getColor(R.color.greyDashBoardButton));
            adapter = new NewsListAdapter(getContext(), R.layout.row_news, newsGenerator(NEWS_ORGA_PAGE_SELECTED), this.getActivity());
            lvNews.setAdapter(adapter);
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
        void onFragmentInteraction(Uri uri);
    }
}
