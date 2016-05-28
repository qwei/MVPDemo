package com.example.zqwei.mvpdemo.model;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/**
 * Created by zqwei on 5/28/16.
 */
public class WeatherDataSource {

    private static final int MSG_LOAD_CHINA_DATA = 1;
    private static final int MSG_LOAD_GLOBAL_DATA = 2;
    private static WeatherDataSource sWeatherDataSource;
    private Context mContext;

    private MyHandler mHandler = null;

    class MyHandler extends Handler {

        public MyHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_LOAD_CHINA_DATA:
                    doLoadChinaData((ILoadWeatherDataListener)msg.obj);
                    break;
                case MSG_LOAD_GLOBAL_DATA:
                    break;
            }
        }
    }

    private WeatherDataSource(Context context) {
        mContext = context;
        //创建一个工作线程，用于从网络load数据
        HandlerThread handlerThead = new HandlerThread("work thread");
        mHandler = new MyHandler(handlerThead.getLooper());
        handlerThead.start();
    }

    public static synchronized WeatherDataSource getInstance(Context context) {
        if(sWeatherDataSource == null) {
            sWeatherDataSource = new WeatherDataSource(context);
        }
        return sWeatherDataSource;
    }

    /**
     * 从中央气象局接口load数据
     * @param listener
     */
    public void loadChinaData(ILoadWeatherDataListener listener){

        if(mHandler != null) {
            mHandler.sendMessage(mHandler.obtainMessage(MSG_LOAD_CHINA_DATA, listener));
        }
    }

    private void doLoadChinaData(ILoadWeatherDataListener listener) {
        //load data
    }

    public interface ILoadWeatherDataListener {
        void onLoadSuccess(String data);
        void onLoadFailed();
    }

}
