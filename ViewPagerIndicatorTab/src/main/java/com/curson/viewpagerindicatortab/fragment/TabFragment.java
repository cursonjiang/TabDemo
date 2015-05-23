package com.curson.viewpagerindicatortab.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.curson.viewpagerindicatortab.R;
import com.curson.viewpagerindicatortab.adapter.TabAdapter;

/**
 * Created by Curson on 15/3/22.
 */
public class TabFragment extends Fragment {

    private int position;

    public TabFragment(int position) {
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag, null);
        TextView tv = (TextView) view.findViewById(R.id.id_tv);
        tv.setText(TabAdapter.TITLES[position]);
        return view;
    }
}
