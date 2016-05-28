package com.example.zqwei.mvpdemo.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.zqwei.mvpdemo.R;
import com.example.zqwei.mvpdemo.presenter.LoadDataPresenter;
import com.example.zqwei.mvpdemo.presenter.LoadWeatherData;

public class MainActivity extends Activity implements LoadWeatherData.BaseView {

    private static final String TAG = "MainActivity";

    private LoadDataPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new LoadDataPresenter(this,this);

        mPresenter.loadChinaWeatherData();

    }

    @Override
    public void showData(String data) {
        if(data != null) {
            Log.d(TAG, "----showData-----" + data);
        } else {
            Log.d(TAG, "----showData-----data is null" );
        }

    }
}
