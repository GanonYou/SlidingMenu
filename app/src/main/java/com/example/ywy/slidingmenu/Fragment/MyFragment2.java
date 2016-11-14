package com.example.ywy.slidingmenu.Fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ywy.slidingmenu.ColumnContent;
import com.example.ywy.slidingmenu.LoadMoreRecyclerView;
import com.example.ywy.slidingmenu.Adapter.RecyclerViewAdapter1;
import com.example.ywy.slidingmenu.R;

public class MyFragment2 extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private RecyclerViewAdapter1 recyclerViewAdapter1;
    private LoadMoreRecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int page = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_item_list, container, false);
            recyclerView = (LoadMoreRecyclerView) view.findViewById(R.id.list);
            recyclerView.setHasFixedSize(true);


//            view.findViewById(R.id.iv_img).setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    if ( mColumnCount == 1) {
//                        mColumnCount = 2;
//                        ((TextView) v).setText("1");
//                        recyclerViewAdapter1.switchMode(true);
//                        recyclerView.switchLayoutManager(new StaggeredGridLayoutManager(mColumnCount, StaggeredGridLayoutManager.VERTICAL));
//                    } else {
//                        mColumnCount = 1;
//                        ((TextView) v).setText("2");
//                        recyclerViewAdapter1.switchMode(false);
//                        recyclerView.switchLayoutManager(new LinearLayoutManager(getActivity()));
//                    }
//                }
//            });

            swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    swipeRefreshLayout.setRefreshing(false);
                    page = 0;
                    recyclerViewAdapter1.setData(ColumnContent.generyData(page));
                    recyclerView.setAutoLoadMoreEnable(ColumnContent.hasMore(page));
                    recyclerViewAdapter1.notifyDataSetChanged();
                }
            });
            if (1 >= mColumnCount) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            } else {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(mColumnCount, StaggeredGridLayoutManager.VERTICAL));
            }
            recyclerViewAdapter1 = new RecyclerViewAdapter1(ColumnContent.generyData(page));
            recyclerView.setAdapter(recyclerViewAdapter1);
            recyclerView.setAutoLoadMoreEnable(true);
            recyclerView.setLoadMoreListener(new LoadMoreRecyclerView.LoadMoreListener() {
                @Override
                public void onLoadMore() {
                    recyclerView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            swipeRefreshLayout.setRefreshing(false);
                            recyclerViewAdapter1.addDatas(ColumnContent.generyData(++page));
                            recyclerView.notifyMoreFinish(ColumnContent.hasMore(page));
                        }
                    }, 1000);
                }
            });
            recyclerViewAdapter1.notifyDataSetChanged();
            return view;
        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
        }

        @Override
        public void onDetach() {
            super.onDetach();
//        mListener = null;
        }

}