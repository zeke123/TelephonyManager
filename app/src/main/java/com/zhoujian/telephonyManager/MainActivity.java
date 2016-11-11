package com.zhoujian.telephonyManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private TelephonyManager mTelephonyManager;
    private String mId;
    private String mVersion;
    private String mOperator;
    private String mName;
    private int mType;
    private CellLocation mLocation;
    private String mIso;
    private String mNumber;
    private int mState;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注意要加权限
        //<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
        //<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
        //获取系统的TelephonyManager
        mTelephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        //获取设备编号
        mId = mTelephonyManager.getDeviceId();
        //获取系统平台版本
        mVersion = mTelephonyManager.getDeviceSoftwareVersion();
        //获取网络运营商代号
        mOperator = mTelephonyManager.getNetworkOperator();
        //获取网络运营商名称
        mName = mTelephonyManager.getNetworkOperatorName();
        //获取手机网络类型
        mType = mTelephonyManager.getPhoneType();
        //获取设备所在位置
        mLocation = mTelephonyManager.getCellLocation();
        //获取SIM卡的国别
        mIso = mTelephonyManager.getSimCountryIso();
        //获取SIM卡的序列号
        mNumber = mTelephonyManager.getSimSerialNumber();
        //获取SIM卡状态
        mState = mTelephonyManager.getSimState();


        mButton = (Button) findViewById(R.id.bt_start);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
