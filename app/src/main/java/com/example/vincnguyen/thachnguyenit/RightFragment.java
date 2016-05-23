package com.example.vincnguyen.thachnguyenit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RightFragment extends Fragment implements Observer {

    TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_right, container, false);

        mTextView = (TextView)view.findViewById(R.id.textView);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MainActivity) getActivity()).getObserver().addObserver(this);

    }

    @Override
    public void update(Observable observable, Object data) {
        if (data == null) {
            return;
        }

        mTextView.setText(data.toString());
    }
}
