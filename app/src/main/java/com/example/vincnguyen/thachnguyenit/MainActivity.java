package com.example.vincnguyen.thachnguyenit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Observable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{

    private MyObserver mMyObserver = new MyObserver();

    private Toolbar mToolbar;

    FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initViews();
        initToolbar();
        attachListeners();

    }

    private void initViews(){
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
    }

    private void attachListeners() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public MyObserver getObserver() {
        return mMyObserver;
    }

    public static class MyObserver extends Observable{

        private String value = "Hello World!";

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
            setChanged();
            notifyObservers(value);
        }
    }
}
