package com.example.jordan.societhy_android.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Adapter.NewsListAdapter;
import com.example.jordan.societhy_android.Models.NewsModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DashBoardFragment extends Fragment {


    @Bind(R.id.et_search)
    EditText etSearch;
    @Bind(R.id.tv_news)
    TextView tvNews;
    @Bind(R.id.tv_news_orga)
    TextView tvNewsOrga;
    @Bind(R.id.selector_layout)
    LinearLayout selectorLayout;
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

    public static DashBoardFragment newInstance() {
        DashBoardFragment fragment = new DashBoardFragment();
        return fragment;
    }

    public DashBoardFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
            list.add(new NewsModel("CDProjekt", "NEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWSNEWS", "17/02/2016"));
        } else {
            list.add(new NewsModel("CDProjekt", "newsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnews", "16/02/2016"));
            list.add(new NewsModel("CDProjekt", "newsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnews", "16/02/2016"));
            list.add(new NewsModel("CDProjekt", "newsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnews", "16/02/2016"));
            list.add(new NewsModel("CDProjekt", "newsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnews", "16/02/2016"));
            list.add(new NewsModel("CDProjekt", "newsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnews", "16/02/2016"));
            list.add(new NewsModel("CDProjekt", "newsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnewsnews", "16/02/2016"));
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
        adapter = new NewsListAdapter(getContext(), R.layout.row_news, list, this.getActivity());
        lvNews.setAdapter(adapter);

    }

    private void updateViews(int pager) {
        if (pager == NEWS_PAGE_SELECTED) {
            tvNews.setBackgroundResource(R.drawable.dashboard_button_selected_shape);
            tvNewsOrga.setBackgroundResource(R.drawable.dashboard_button_unselected_shape);
            adapter = new NewsListAdapter(getContext(), R.layout.row_news, newsGenerator(NEWS_PAGE_SELECTED), this.getActivity());
            lvNews.setAdapter(adapter);
        } else {
            tvNewsOrga.setBackgroundResource(R.drawable.dashboard_button_selected_shape);
            tvNews.setBackgroundResource(R.drawable.dashboard_button_unselected_shape);
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
