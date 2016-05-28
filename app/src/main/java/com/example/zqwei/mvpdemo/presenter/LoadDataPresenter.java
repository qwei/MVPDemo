package com.example.zqwei.mvpdemo.presenter;

import android.content.Context;

import com.example.zqwei.mvpdemo.model.WeatherDataSource;

/**
 * Created by zqwei on 5/28/16.
 */
public class LoadDataPresenter implements WeatherDataSource.ILoadWeatherDataListener{

    private Context mContext;
    private LoadWeatherData.BaseView mBaseView;

    @Override
    public void onLoadFailed() {
        mBaseView.showData(null);
    }

    @Override
    public void onLoadSuccess(String data) {
        mBaseView.showData(data);
    }

    public LoadDataPresenter(Context context, LoadWeatherData.BaseView baseView) {
        mContext = context;
        mBaseView = baseView;
    }

    public void loadChinaWeatherData() {
        WeatherDataSource.getInstance(mContext).loadChinaData(this);
    }
}
