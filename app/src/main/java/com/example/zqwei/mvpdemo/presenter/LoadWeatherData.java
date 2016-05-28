package com.example.zqwei.mvpdemo.presenter;

/**
 * Created by zqwei on 5/28/16.
 */
public interface LoadWeatherData {

    public interface BaseView {
        public void showData(String data);
    }

    public interface BasePresenter {
        public String loadChinaData();
    }
}
