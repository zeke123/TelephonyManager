package com.zhoujian.telephonyManager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by zhoujian on 2016/11/11.
 *
 * 监听手机来电
 * 见监听电话状态需要权限
 * <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
 */

public class SecondActivity extends Activity
{
    private TelephonyManager mTelephonyManager;

    public static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        //control+command+g   同时选中
        mTelephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        PhoneStateListener listener = new PhoneStateListener()
        {
            //control+o   复写方法
            @Override
            public void onCallStateChanged(int state, String incomingNumber)
            {
                switch (state)
                {
                    //无任何状态
                    case TelephonyManager.CALL_STATE_IDLE:
                        break;
                    //挂断状态
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        break;
                    //来电响铃
                    case TelephonyManager.CALL_STATE_RINGING:
                        Log.e(TAG,"incomingNumber="+incomingNumber);
                        break;
                }
                super.onCallStateChanged(state, incomingNumber);
            }
        };

        //监听电话状态的改变
        mTelephonyManager.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
    }
    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}
