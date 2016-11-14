package com.example.ywy.slidingmenu.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ywy.slidingmenu.ColumnContent;
import com.example.ywy.slidingmenu.LoadMoreRecyclerView;
import com.example.ywy.slidingmenu.R;

import java.util.List;

/**
 * Created by YWY on 16/3/30.
 */
public class RecyclerViewAdapter2  extends  RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<ColumnContent.ColumnItem> mValues;
    private boolean mIsStagger;

    public RecyclerViewAdapter2(List<ColumnContent.ColumnItem> items) {
        mValues = items;
    }

    public void switchMode(boolean mIsStagger) {
        this.mIsStagger = mIsStagger;
    }

    public void setData(List<ColumnContent.ColumnItem> datas) {
        mValues = datas;
    }

    public void addDatas(List<ColumnContent.ColumnItem> datas) {
        mValues.addAll(datas);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //if (viewType == LoadMoreRecyclerView.TYPE_STAGGER) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_item_staggel, parent, false);
            return new StaggerViewHolder(view);
//        } else {
//            View view = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.item, parent, false);
//            return new ViewHolder(view);
//        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


            StaggerViewHolder staggerViewHolder = (StaggerViewHolder) holder;
            staggerViewHolder.iconView.setVisibility(View.VISIBLE);
            //staggerViewHolder.mContentView.setText(mValues.get(position).details);
//
// else {
//            ViewHolder mHolder = (ViewHolder) holder;
//            mHolder.mItem = mValues.get(position);
//            mHolder.mContentView.setText(mValues.get(position).content);
//            mHolder.mIdView.setText(mValues.get(position).id);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class StaggerViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public View iconView;
        //public TextView mContentView;

        public StaggerViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            iconView = itemView.findViewById(R.id.icon);
            //mContentView = (TextView) itemView.findViewById(R.id.content);
        }
    }

//    public class ViewHolder extends RecyclerView.ViewHolder {
//        public final View mView;
//        //public final TextView mIdView;
//        public final TextView mContentView;
//        public ColumnContent.ColumnItem mItem;
//
//        public ViewHolder(View view) {
//            super(view);
//            mView = view;
//            //mIdView = (TextView) view.findViewById(R.id.tv_info_1);
//            mContentView = (TextView) view.findViewById(R.id.content);
//        }
//
//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
//    }

}
